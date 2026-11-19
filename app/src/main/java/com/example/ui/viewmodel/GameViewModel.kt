package com.example.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.data.AppDatabase
import com.example.data.GameRepository
import com.example.data.Level
import com.example.data.LevelDataProvider
import com.example.data.PersianUtils
import com.example.data.PlayerStatsEntity
import com.example.ui.audio.SoundManager
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Calendar

class GameViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "word_guess_game.db"
    ).build()

    private val repository = GameRepository(db.gameDao())
    val soundManager = SoundManager(application)

    val playerStats: StateFlow<PlayerStatsEntity> = repository.playerStats.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = PlayerStatsEntity()
    )

    val allLevelRecords: StateFlow<List<com.example.data.LevelRecordEntity>> = repository.allLevelRecords.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    private val _currentLevelNumber = MutableStateFlow(1)
    val currentLevelNumber = _currentLevelNumber.asStateFlow()

    private val _currentLevel = MutableStateFlow(LevelDataProvider.getLevel(1))
    val currentLevel = _currentLevel.asStateFlow()

    private val _displayedLetters = MutableStateFlow<List<String>>(emptyList())
    val displayedLetters = _displayedLetters.asStateFlow()

    private val _selectedLetterIndices = MutableStateFlow<List<Int>>(emptyList())
    val selectedLetterIndices = _selectedLetterIndices.asStateFlow()

    private val _currentInputWord = MutableStateFlow("")
    val currentInputWord = _currentInputWord.asStateFlow()

    private val _solvedWords = MutableStateFlow<Set<String>>(emptySet())
    val solvedWords = _solvedWords.asStateFlow()

    private val _revealedLetters = MutableStateFlow<Set<String>>(emptySet())
    val revealedLetters = _revealedLetters.asStateFlow()

    private val _bonusWordsFound = MutableStateFlow<Set<String>>(emptySet())
    val bonusWordsFound = _bonusWordsFound.asStateFlow()

    private val _isLevelCompleted = MutableStateFlow(false)
    val isLevelCompleted = _isLevelCompleted.asStateFlow()

    private val _showVictoryDialog = MutableStateFlow(false)
    val showVictoryDialog = _showVictoryDialog.asStateFlow()

    private val _showDictionaryDialog = MutableStateFlow(false)
    val showDictionaryDialog = _showDictionaryDialog.asStateFlow()

    private val _showBonusChestDialog = MutableStateFlow(false)
    val showBonusChestDialog = _showBonusChestDialog.asStateFlow()

    private val _showSettingsDialog = MutableStateFlow(false)
    val showSettingsDialog = _showSettingsDialog.asStateFlow()

    private val _showDailyDialog = MutableStateFlow(false)
    val showDailyDialog = _showDailyDialog.asStateFlow()

    private val _isDailyMode = MutableStateFlow(false)
    val isDailyMode = _isDailyMode.asStateFlow()

    private val _feedbackMessage = MutableStateFlow<String?>(null)
    val feedbackMessage = _feedbackMessage.asStateFlow()

    private val _shakeTrigger = MutableStateFlow(0L)
    val shakeTrigger = _shakeTrigger.asStateFlow()

    private val _activeScreen = MutableStateFlow(Screen.GAME)
    val activeScreen = _activeScreen.asStateFlow()

    enum class Screen {
        GAME, LEVEL_SELECT
    }

    private var feedbackJob: Job? = null

    init {
        viewModelScope.launch {
            val stats = repository.getInitialStats()
            loadLevel(stats.currentLevel)
        }
    }

    fun navigateTo(screen: Screen) {
        _activeScreen.value = screen
    }

    fun loadLevel(levelNum: Int, isDaily: Boolean = false) {
        _isDailyMode.value = isDaily
        _currentLevelNumber.value = levelNum
        val level = if (isDaily) {
            val day = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
            LevelDataProvider.getDailyChallenge(day)
        } else {
            LevelDataProvider.getLevel(levelNum)
        }
        _currentLevel.value = level
        _displayedLetters.value = level.letters
        _selectedLetterIndices.value = emptyList()
        _currentInputWord.value = ""
        _isLevelCompleted.value = false
        _showVictoryDialog.value = false

        viewModelScope.launch {
            val record = repository.getLevelRecord(levelNum)
            // Restore solved words if any
            record.collect { rec ->
                if (rec != null) {
                    val solved = if (rec.solvedWords.isNotBlank()) rec.solvedWords.split(",").toSet() else emptySet()
                    val revealed = if (rec.revealedLetters.isNotBlank()) rec.revealedLetters.split(",").toSet() else emptySet()
                    val bonus = if (rec.bonusWordsFound.isNotBlank()) rec.bonusWordsFound.split(",").toSet() else emptySet()
                    _solvedWords.value = solved
                    _revealedLetters.value = revealed
                    _bonusWordsFound.value = bonus
                    _isLevelCompleted.value = rec.isCompleted
                } else {
                    _solvedWords.value = emptySet()
                    _revealedLetters.value = emptySet()
                    _bonusWordsFound.value = emptySet()
                    _isLevelCompleted.value = false
                }
            }
        }
    }

    fun onLetterDragTouch(index: Int) {
        val currentIndices = _selectedLetterIndices.value
        if (index !in 0 until _displayedLetters.value.size) return

        if (currentIndices.contains(index)) {
            // If user backtracks to the second-to-last letter, undo the last one
            if (currentIndices.size > 1 && currentIndices[currentIndices.size - 2] == index) {
                val newIndices = currentIndices.dropLast(1)
                _selectedLetterIndices.value = newIndices
                updateCurrentWord(newIndices)
                soundManager.playLetterSelect(newIndices.size, isSoundOn(), isHapticOn())
            }
            return
        }

        val newIndices = currentIndices + index
        _selectedLetterIndices.value = newIndices
        updateCurrentWord(newIndices)
        soundManager.playLetterSelect(newIndices.size, isSoundOn(), isHapticOn())
    }

    private fun updateCurrentWord(indices: List<Int>) {
        val letters = _displayedLetters.value
        val word = indices.mapNotNull { letters.getOrNull(it) }.joinToString("")
        _currentInputWord.value = word
    }

    fun onLetterDragEnd() {
        val word = _currentInputWord.value.trim()
        val currentLvl = _currentLevel.value

        if (word.isEmpty()) {
            _selectedLetterIndices.value = emptyList()
            return
        }

        // Check if matches any target word
        val targetMatch = currentLvl.targetWords.find {
            PersianUtils.wordsMatch(it.word, word)
        }

        if (targetMatch != null) {
            val normalizedTarget = targetMatch.word
            if (_solvedWords.value.contains(normalizedTarget)) {
                showFeedback("این کلمه رو قبلاً حدس زدی! 😊")
                _shakeTrigger.value = System.currentTimeMillis()
                soundManager.playWrongWord(isSoundOn(), isHapticOn())
            } else {
                // Correct target word!
                val updatedSolved = _solvedWords.value + normalizedTarget
                _solvedWords.value = updatedSolved
                soundManager.playWordFound(isSoundOn(), isHapticOn())
                showFeedback("آفرین! «$normalizedTarget» درسته! 👏")

                // Check if level complete
                if (updatedSolved.size >= currentLvl.targetWords.size) {
                    onLevelComplete()
                } else {
                    saveCurrentProgress()
                }
            }
        } else {
            // Check bonus words
            val isBonus = currentLvl.bonusWords.any { PersianUtils.wordsMatch(it, word) }
            if (isBonus) {
                if (_bonusWordsFound.value.contains(word)) {
                    showFeedback("کلمه اضافی قبلاً پیدا شده! ✨")
                    _shakeTrigger.value = System.currentTimeMillis()
                    soundManager.playWrongWord(isSoundOn(), isHapticOn())
                } else {
                    _bonusWordsFound.value = _bonusWordsFound.value + word
                    showFeedback("کلمه مخفی و شانس! +۱۰ سکه 🪙")
                    soundManager.playBonusWordFound(isSoundOn(), isHapticOn())
                    viewModelScope.launch {
                        repository.addBonusWordCount(1)
                    }
                    saveCurrentProgress()
                }
            } else {
                // Wrong word
                if (word.length >= 2) {
                    showFeedback("کلمه در جدول نیست! ❌")
                    _shakeTrigger.value = System.currentTimeMillis()
                    soundManager.playWrongWord(isSoundOn(), isHapticOn())
                }
            }
        }

        _selectedLetterIndices.value = emptyList()
        _currentInputWord.value = ""
    }

    private fun onLevelComplete() {
        _isLevelCompleted.value = true
        _showVictoryDialog.value = true
        soundManager.playLevelWin(isSoundOn(), isHapticOn())

        viewModelScope.launch {
            val stars = 3 // 3 stars on completion
            repository.saveLevelProgress(
                levelNumber = _currentLevelNumber.value,
                solvedWords = _solvedWords.value,
                revealedLetters = _revealedLetters.value,
                bonusWordsFound = _bonusWordsFound.value,
                isCompleted = true,
                stars = stars
            )
        }
    }

    private fun saveCurrentProgress() {
        viewModelScope.launch {
            repository.saveLevelProgress(
                levelNumber = _currentLevelNumber.value,
                solvedWords = _solvedWords.value,
                revealedLetters = _revealedLetters.value,
                bonusWordsFound = _bonusWordsFound.value,
                isCompleted = false,
                stars = 0
            )
        }
    }

    fun nextLevel() {
        _showVictoryDialog.value = false
        val nextLvl = _currentLevelNumber.value + 1
        loadLevel(nextLvl)
    }

    fun shuffleLetters() {
        _displayedLetters.value = _displayedLetters.value.shuffled()
        soundManager.playLetterSelect(1, isSoundOn(), isHapticOn())
    }

    fun useHint() {
        val cost = 40
        val currentCoins = playerStats.value.coins
        if (currentCoins < cost) {
            showFeedback("سکه کافی نداری! (نیاز به ۴۰ سکه) 💰")
            _shakeTrigger.value = System.currentTimeMillis()
            return
        }

        val currentLvl = _currentLevel.value
        val unsolvedTargets = currentLvl.targetWords.filterIndexed { index, targetWord ->
            !_solvedWords.value.contains(targetWord.word)
        }

        if (unsolvedTargets.isEmpty()) return

        // Find an unrevealed letter slot in one of the unsolved words
        val candidates = mutableListOf<Pair<Int, Int>>() // targetWordIndex, letterIndex
        currentLvl.targetWords.forEachIndexed { wordIdx, targetWord ->
            if (!_solvedWords.value.contains(targetWord.word)) {
                for (charIdx in targetWord.word.indices) {
                    val key = "$wordIdx:$charIdx"
                    if (!_revealedLetters.value.contains(key)) {
                        candidates.add(Pair(wordIdx, charIdx))
                    }
                }
            }
        }

        if (candidates.isEmpty()) return

        val chosen = candidates.random()
        val key = "${chosen.first}:${chosen.second}"
        _revealedLetters.value = _revealedLetters.value + key

        viewModelScope.launch {
            val success = repository.spendCoins(cost)
            if (success) {
                soundManager.playHint(isSoundOn(), isHapticOn())
                showFeedback("یک حرف راهنمایی فاش شد! 💡")
                saveCurrentProgress()
            }
        }
    }

    fun showFeedback(msg: String) {
        feedbackJob?.cancel()
        _feedbackMessage.value = msg
        feedbackJob = viewModelScope.launch {
            delay(2400)
            _feedbackMessage.value = null
        }
    }

    fun toggleSound() {
        viewModelScope.launch {
            repository.toggleSound(!playerStats.value.soundEnabled)
        }
    }

    fun toggleHaptic() {
        viewModelScope.launch {
            repository.toggleHaptic(!playerStats.value.hapticEnabled)
        }
    }

    fun openDictionary() { _showDictionaryDialog.value = true }
    fun closeDictionary() { _showDictionaryDialog.value = false }

    fun openBonusChest() { _showBonusChestDialog.value = true }
    fun closeBonusChest() { _showBonusChestDialog.value = false }

    fun openSettings() { _showSettingsDialog.value = true }
    fun closeSettings() { _showSettingsDialog.value = false }

    fun openDaily() { _showDailyDialog.value = true }
    fun closeDaily() { _showDailyDialog.value = false }

    fun closeVictory() { _showVictoryDialog.value = false }

    fun resetProgress() {
        viewModelScope.launch {
            repository.resetAllProgress()
            loadLevel(1)
            _showSettingsDialog.value = false
            showFeedback("پیشرفت بازی بازنشانی شد! 🔄")
        }
    }

    private fun isSoundOn(): Boolean = playerStats.value.soundEnabled
    private fun isHapticOn(): Boolean = playerStats.value.hapticEnabled
}
