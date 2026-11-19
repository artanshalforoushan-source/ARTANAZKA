package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.TargetWord
import com.example.ui.theme.CardBorder
import com.example.ui.theme.PersianEmerald
import com.example.ui.theme.PersianGold
import com.example.ui.theme.PersianGoldDark
import com.example.ui.theme.PersianTurquoise
import com.example.ui.theme.PersianTurquoiseDark
import com.example.ui.theme.TileBackground
import com.example.ui.theme.TileEmpty
import com.example.ui.theme.WoodBorder

@Composable
fun WordBoxesGrid(
    targetWords: List<TargetWord>,
    solvedWords: Set<String>,
    revealedLetters: Set<String>,
    onWordClick: (TargetWord) -> Unit,
    modifier: Modifier = Modifier
) {
    val count = targetWords.size
    val isTwoColumns = count >= 5
    val maxLen = targetWords.maxOfOrNull { it.word.length } ?: 4

    val tileSize: Dp = when {
        isTwoColumns && maxLen >= 6 -> 28.dp
        isTwoColumns -> 32.dp
        maxLen <= 4 -> 44.dp
        maxLen == 5 -> 38.dp
        maxLen == 6 -> 34.dp
        else -> 30.dp
    }

    val fontSize: TextUnit = when {
        isTwoColumns && maxLen >= 6 -> 14.sp
        isTwoColumns -> 16.sp
        maxLen <= 4 -> 22.sp
        maxLen == 5 -> 18.sp
        maxLen == 6 -> 16.sp
        else -> 14.sp
    }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        if (!isTwoColumns) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 2.dp)
                    .testTag("word_boxes_grid"),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                targetWords.forEachIndexed { wordIndex, targetWord ->
                    val isSolved = solvedWords.contains(targetWord.word)
                    WordRow(
                        wordIndex = wordIndex,
                        targetWord = targetWord,
                        isSolved = isSolved,
                        revealedLetters = revealedLetters,
                        tileSize = tileSize,
                        fontSize = fontSize,
                        onClick = {
                            if (isSolved) {
                                onWordClick(targetWord)
                            }
                        }
                    )
                }
            }
        } else {
            // Split into 2 columns
            val half = (count + 1) / 2
            val col1 = targetWords.take(half)
            val col2 = targetWords.drop(half)

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 2.dp)
                    .testTag("word_boxes_grid"),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier.padding(horizontal = 4.dp)
                ) {
                    col1.forEachIndexed { idx, targetWord ->
                        val isSolved = solvedWords.contains(targetWord.word)
                        WordRow(
                            wordIndex = idx,
                            targetWord = targetWord,
                            isSolved = isSolved,
                            revealedLetters = revealedLetters,
                            tileSize = tileSize,
                            fontSize = fontSize,
                            onClick = { if (isSolved) onWordClick(targetWord) }
                        )
                    }
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier.padding(horizontal = 4.dp)
                ) {
                    col2.forEachIndexed { idx, targetWord ->
                        val isSolved = solvedWords.contains(targetWord.word)
                        WordRow(
                            wordIndex = half + idx,
                            targetWord = targetWord,
                            isSolved = isSolved,
                            revealedLetters = revealedLetters,
                            tileSize = tileSize,
                            fontSize = fontSize,
                            onClick = { if (isSolved) onWordClick(targetWord) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun WordRow(
    wordIndex: Int,
    targetWord: TargetWord,
    isSolved: Boolean,
    revealedLetters: Set<String>,
    tileSize: Dp,
    fontSize: TextUnit,
    onClick: () -> Unit
) {
    val scaleAnim = remember { Animatable(1f) }

    LaunchedEffect(isSolved) {
        if (isSolved) {
            scaleAnim.animateTo(
                targetValue = 1.08f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
            scaleAnim.animateTo(1f, tween(150))
        }
    }

    Row(
        modifier = Modifier
            .scale(scaleAnim.value)
            .clip(RoundedCornerShape(8.dp))
            .clickable(enabled = isSolved, onClick = onClick)
            .padding(horizontal = 2.dp, vertical = 1.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        targetWord.word.forEachIndexed { charIndex, char ->
            val letterKey = "${wordIndex}_$charIndex"
            val isLetterRevealed = isSolved || revealedLetters.contains(letterKey)

            LetterTile(
                letter = if (isLetterRevealed) char.toString() else "",
                isSolved = isSolved,
                isHintRevealed = !isSolved && revealedLetters.contains(letterKey),
                tileSize = tileSize,
                fontSize = fontSize
            )
        }

        if (isSolved) {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + scaleIn()
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "معنی کلمه",
                    tint = PersianGold,
                    modifier = Modifier
                        .size(if (tileSize <= 32.dp) 16.dp else 20.dp)
                        .padding(start = 2.dp)
                )
            }
        }
    }
}

@Composable
private fun LetterTile(
    letter: String,
    isSolved: Boolean,
    isHintRevealed: Boolean,
    tileSize: Dp,
    fontSize: TextUnit
) {
    val backgroundBrush = when {
        isSolved -> Brush.verticalGradient(
            colors = listOf(PersianEmerald, Color(0xFF00695C))
        )
        isHintRevealed -> Brush.verticalGradient(
            colors = listOf(PersianGold, PersianGoldDark)
        )
        else -> Brush.verticalGradient(
            colors = listOf(TileBackground, Color(0xFF16253B))
        )
    }

    val borderColor = when {
        isSolved -> PersianGold
        isHintRevealed -> PersianGold
        else -> WoodBorder.copy(alpha = 0.5f)
    }

    Surface(
        modifier = Modifier
            .size(tileSize)
            .shadow(
                elevation = if (isSolved) 4.dp else 2.dp,
                shape = RoundedCornerShape(7.dp)
            ),
        shape = RoundedCornerShape(7.dp),
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .background(brush = backgroundBrush)
                .border(
                    width = if (isSolved || isHintRevealed) 1.5.dp else 1.dp,
                    color = borderColor,
                    shape = RoundedCornerShape(7.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            if (letter.isNotEmpty()) {
                Text(
                    text = letter,
                    fontSize = fontSize,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
            }
        }
    }
}
