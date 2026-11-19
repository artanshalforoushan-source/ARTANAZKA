package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.R
import com.example.data.TargetWord
import com.example.ui.components.BonusWordsDialog
import com.example.ui.components.GameControls
import com.example.ui.components.GameHeader
import com.example.ui.components.LetterWheel
import com.example.ui.components.LevelWinDialog
import com.example.ui.components.SettingsDialog
import com.example.ui.components.WordBoxesGrid
import com.example.ui.components.WordDefinitionDialog
import com.example.ui.components.WordPreviewPill
import com.example.ui.theme.BackgroundEnd
import com.example.ui.theme.BackgroundStart
import com.example.ui.theme.CardBackground
import com.example.ui.theme.PersianEmerald
import com.example.ui.theme.PersianGold
import com.example.ui.theme.PersianNavy
import com.example.ui.theme.PersianOffWhite
import com.example.ui.theme.PersianPomegranate
import com.example.ui.theme.PersianTurquoise
import com.example.ui.viewmodel.GameViewModel
import kotlin.math.roundToInt

@Composable
fun GameScreen(
    viewModel: GameViewModel,
    modifier: Modifier = Modifier
) {
    val currentLevel by viewModel.currentLevel.collectAsStateWithLifecycle()
    val levelNumber by viewModel.currentLevelNumber.collectAsStateWithLifecycle()
    val displayedLetters by viewModel.displayedLetters.collectAsStateWithLifecycle()
    val selectedIndices by viewModel.selectedLetterIndices.collectAsStateWithLifecycle()
    val currentInputWord by viewModel.currentInputWord.collectAsStateWithLifecycle()
    val solvedWords by viewModel.solvedWords.collectAsStateWithLifecycle()
    val revealedLetters by viewModel.revealedLetters.collectAsStateWithLifecycle()
    val bonusWordsFound by viewModel.bonusWordsFound.collectAsStateWithLifecycle()
    val playerStats by viewModel.playerStats.collectAsStateWithLifecycle()
    val feedbackMessage by viewModel.feedbackMessage.collectAsStateWithLifecycle()
    val shakeTrigger by viewModel.shakeTrigger.collectAsStateWithLifecycle()
    val isDailyMode by viewModel.isDailyMode.collectAsStateWithLifecycle()

    val showVictoryDialog by viewModel.showVictoryDialog.collectAsStateWithLifecycle()
    val showDictionaryDialog by viewModel.showDictionaryDialog.collectAsStateWithLifecycle()
    val showBonusChestDialog by viewModel.showBonusChestDialog.collectAsStateWithLifecycle()
    val showSettingsDialog by viewModel.showSettingsDialog.collectAsStateWithLifecycle()

    // Shake animation effect on error
    val shakeOffset = remember { Animatable(0f) }
    LaunchedEffect(shakeTrigger) {
        if (shakeTrigger > 0) {
            shakeOffset.animateTo(
                targetValue = 0f,
                animationSpec = keyframes {
                    durationMillis = 350
                    0f at 0
                    (-16f) at 50
                    16f at 100
                    (-12f) at 150
                    12f at 200
                    (-6f) at 250
                    6f at 300
                    0f at 350
                }
            )
        }
    }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(BackgroundStart, BackgroundEnd)
                    )
                )
                .testTag("game_screen")
        ) {
            // Background Decorative Persian Hero Banner
            Image(
                painter = painterResource(id = R.drawable.game_banner_persian),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .alpha(0.22f)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .offset { IntOffset(x = shakeOffset.value.roundToInt(), y = 0) },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Top Game Header Bar
                GameHeader(
                    levelNumber = levelNumber,
                    chapterTitle = currentLevel.chapterTitle,
                    coins = playerStats.coins,
                    stars = playerStats.totalStars,
                    isDaily = isDailyMode,
                    onMapClick = { viewModel.navigateTo(GameViewModel.Screen.LEVEL_SELECT) },
                    onDailyClick = { viewModel.openDaily() },
                    onSettingsClick = { viewModel.openSettings() }
                )

                // Middle Area: Word Grid + Feedback + Preview
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // Crossword Word Box Slots
                    WordBoxesGrid(
                        targetWords = currentLevel.targetWords,
                        solvedWords = solvedWords,
                        revealedLetters = revealedLetters,
                        onWordClick = { viewModel.openDictionary() }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Feedback Message Banner
                    AnimatedVisibility(
                        visible = feedbackMessage != null,
                        enter = fadeIn() + slideInVertically { it / 2 },
                        exit = fadeOut() + slideOutVertically { -it / 2 }
                    ) {
                        Surface(
                            modifier = Modifier
                                .shadow(6.dp, RoundedCornerShape(16.dp))
                                .border(1.dp, PersianGold.copy(alpha = 0.5f), RoundedCornerShape(16.dp)),
                            shape = RoundedCornerShape(16.dp),
                            color = CardBackground
                        ) {
                            Text(
                                text = feedbackMessage ?: "",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = PersianGold,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Floating Word Preview
                    WordPreviewPill(
                        word = currentInputWord,
                        modifier = Modifier.height(44.dp)
                    )
                }

                // Bottom Area: Letter Wheel & Controls
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Interactive Letter Wheel
                    LetterWheel(
                        letters = displayedLetters,
                        selectedIndices = selectedIndices,
                        onLetterTouch = { index -> viewModel.onLetterDragTouch(index) },
                        onDragEnd = { viewModel.onLetterDragEnd() },
                        wheelSize = 250.dp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    // Action Controls (Shuffle, Bonus Chest, Dictionary, Hint)
                    GameControls(
                        onShuffle = { viewModel.shuffleLetters() },
                        onHint = { viewModel.useHint() },
                        onBonusChest = { viewModel.openBonusChest() },
                        onDictionary = { viewModel.openDictionary() },
                        hintCost = 40,
                        bonusWordsCount = bonusWordsFound.size
                    )
                }
            }

            // Dialogs
            if (showVictoryDialog) {
                LevelWinDialog(
                    level = currentLevel,
                    onNextLevel = { viewModel.nextLevel() },
                    onDismiss = { viewModel.closeVictory() }
                )
            }

            if (showDictionaryDialog) {
                WordDefinitionDialog(
                    targetWords = currentLevel.targetWords,
                    solvedWords = solvedWords,
                    onDismiss = { viewModel.closeDictionary() }
                )
            }

            if (showBonusChestDialog) {
                BonusWordsDialog(
                    bonusWords = bonusWordsFound,
                    totalBonusCount = playerStats.bonusWordsCount,
                    onDismiss = { viewModel.closeBonusChest() }
                )
            }

            if (showSettingsDialog) {
                SettingsDialog(
                    soundEnabled = playerStats.soundEnabled,
                    hapticEnabled = playerStats.hapticEnabled,
                    onToggleSound = { viewModel.toggleSound() },
                    onToggleHaptic = { viewModel.toggleHaptic() },
                    onResetProgress = { viewModel.resetProgress() },
                    onDismiss = { viewModel.closeSettings() }
                )
            }
        }
    }
}
