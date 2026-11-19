package com.example.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GameRepository(private val gameDao: GameDao) {

    val playerStats: Flow<PlayerStatsEntity> = gameDao.getPlayerStatsFlow().map {
        it ?: PlayerStatsEntity(
            id = 1,
            coins = 250,
            currentLevel = 1,
            totalStars = 0,
            soundEnabled = true,
            hapticEnabled = true,
            bonusWordsCount = 0,
            lastDailyChallengeDate = "",
            dailyStreak = 0
        )
    }

    val allLevelRecords: Flow<List<LevelRecordEntity>> = gameDao.getAllLevelRecordsFlow()

    fun getLevelRecord(levelNumber: Int): Flow<LevelRecordEntity?> {
        return gameDao.getLevelRecordFlow(levelNumber)
    }

    suspend fun getInitialStats(): PlayerStatsEntity {
        var stats = gameDao.getPlayerStats()
        if (stats == null) {
            stats = PlayerStatsEntity(
                id = 1,
                coins = 250,
                currentLevel = 1,
                totalStars = 0,
                soundEnabled = true,
                hapticEnabled = true,
                bonusWordsCount = 0
            )
            gameDao.insertOrUpdatePlayerStats(stats)
        }
        return stats
    }

    suspend fun savePlayerStats(stats: PlayerStatsEntity) {
        gameDao.insertOrUpdatePlayerStats(stats)
    }

    suspend fun saveLevelProgress(
        levelNumber: Int,
        solvedWords: Set<String>,
        revealedLetters: Set<String>,
        bonusWordsFound: Set<String>,
        isCompleted: Boolean,
        stars: Int
    ) {
        val record = LevelRecordEntity(
            levelNumber = levelNumber,
            isCompleted = isCompleted,
            stars = stars,
            solvedWords = solvedWords.joinToString(","),
            revealedLetters = revealedLetters.joinToString(","),
            bonusWordsFound = bonusWordsFound.joinToString(",")
        )
        gameDao.insertOrUpdateLevelRecord(record)

        if (isCompleted) {
            val stats = getInitialStats()
            val nextLevel = maxOf(stats.currentLevel, levelNumber + 1)
            val updatedStars = stats.totalStars + stars
            val updatedCoins = stats.coins + (stars * 20) + 15 // Bonus reward for completing level
            gameDao.insertOrUpdatePlayerStats(
                stats.copy(
                    currentLevel = nextLevel,
                    totalStars = updatedStars,
                    coins = updatedCoins
                )
            )
        }
    }

    suspend fun addCoins(amount: Int) {
        gameDao.addCoins(amount)
    }

    suspend fun spendCoins(amount: Int): Boolean {
        val stats = getInitialStats()
        if (stats.coins >= amount) {
            gameDao.spendCoins(amount)
            return true
        }
        return false
    }

    suspend fun toggleSound(enabled: Boolean) {
        val stats = getInitialStats()
        gameDao.insertOrUpdatePlayerStats(stats.copy(soundEnabled = enabled))
    }

    suspend fun toggleHaptic(enabled: Boolean) {
        val stats = getInitialStats()
        gameDao.insertOrUpdatePlayerStats(stats.copy(hapticEnabled = enabled))
    }

    suspend fun addBonusWordCount(amount: Int) {
        val stats = getInitialStats()
        gameDao.insertOrUpdatePlayerStats(
            stats.copy(
                bonusWordsCount = stats.bonusWordsCount + amount,
                coins = stats.coins + (amount * 10)
            )
        )
    }

    suspend fun resetAllProgress() {
        gameDao.clearAllRecords()
        gameDao.insertOrUpdatePlayerStats(
            PlayerStatsEntity(
                id = 1,
                coins = 250,
                currentLevel = 1,
                totalStars = 0,
                soundEnabled = true,
                hapticEnabled = true,
                bonusWordsCount = 0
            )
        )
    }
}
