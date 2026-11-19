package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.Chapter
import com.example.data.LevelDataProvider
import com.example.data.LevelRecordEntity
import com.example.data.PersianUtils
import com.example.ui.theme.BackgroundEnd
import com.example.ui.theme.BackgroundStart
import com.example.ui.theme.CardBackground
import com.example.ui.theme.CardBorder
import com.example.ui.theme.PersianEmerald
import com.example.ui.theme.PersianGold
import com.example.ui.theme.PersianGoldDark
import com.example.ui.theme.PersianNavy
import com.example.ui.theme.PersianOffWhite
import com.example.ui.theme.PersianTurquoise
import com.example.ui.theme.TileBackground
import com.example.ui.theme.TileEmpty

@Composable
fun LevelSelectScreen(
    currentUnlockedLevel: Int,
    levelRecords: List<LevelRecordEntity>,
    onSelectLevel: (Int) -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val chapters = LevelDataProvider.chapters
    var selectedChapterId by remember {
        val currentChapter = LevelDataProvider.getChapterForLevel(currentUnlockedLevel)
        mutableStateOf(currentChapter.id)
    }

    val selectedChapter = chapters.find { it.id == selectedChapterId } ?: chapters.first()

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(BackgroundStart, BackgroundEnd)
                    )
                )
                .testTag("level_select_screen")
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Top Bar
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier
                            .size(44.dp)
                            .shadow(4.dp, CircleShape)
                            .background(CardBackground, CircleShape)
                            .testTag("level_select_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "بازگشت",
                            tint = PersianOffWhite
                        )
                    }

                    Text(
                        text = "🗺️ انتخاب مرحله و فصل‌ها",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = PersianGold
                    )

                    Spacer(modifier = Modifier.size(44.dp))
                }

                // Chapters Horizontal Selector
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(horizontal = 4.dp)
                ) {
                    items(chapters) { chapter ->
                        val isSelected = chapter.id == selectedChapterId
                        ChapterCard(
                            chapter = chapter,
                            isSelected = isSelected,
                            currentUnlockedLevel = currentUnlockedLevel,
                            onClick = { selectedChapterId = chapter.id }
                        )
                    }
                }

                // Active Chapter Header Info
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(4.dp, RoundedCornerShape(16.dp))
                        .border(1.dp, CardBorder, RoundedCornerShape(16.dp)),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = CardBackground)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(
                                text = "${selectedChapter.iconEmoji} فصل ${PersianUtils.toPersianNumber(selectedChapter.id)}: ${selectedChapter.title}",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = PersianTurquoise
                            )
                            Text(
                                text = selectedChapter.subtitle,
                                fontSize = 12.sp,
                                color = PersianOffWhite.copy(alpha = 0.8f)
                            )
                        }
                        Text(
                            text = "مراحل ${PersianUtils.toPersianNumber(selectedChapter.startLevel)} تا ${PersianUtils.toPersianNumber(selectedChapter.endLevel)}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = PersianGold
                        )
                    }
                }

                // Levels Grid
                val levelsList = (selectedChapter.startLevel..selectedChapter.endLevel).toList()
                LazyVerticalGrid(
                    columns = GridCells.Fixed(5),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(levelsList.size) { index ->
                        val levelNum = levelsList[index]
                        val isUnlocked = levelNum <= currentUnlockedLevel
                        val isCurrent = levelNum == currentUnlockedLevel
                        val record = levelRecords.find { it.levelNumber == levelNum }
                        val isCompleted = record?.isCompleted == true
                        val stars = record?.stars ?: 0

                        LevelGridItem(
                            levelNumber = levelNum,
                            isUnlocked = isUnlocked,
                            isCurrent = isCurrent,
                            isCompleted = isCompleted,
                            stars = stars,
                            onClick = {
                                if (isUnlocked) {
                                    onSelectLevel(levelNum)
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ChapterCard(
    chapter: Chapter,
    isSelected: Boolean,
    currentUnlockedLevel: Int,
    onClick: () -> Unit
) {
    val isChapterUnlocked = currentUnlockedLevel >= chapter.startLevel

    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
            .border(
                width = if (isSelected) 2.dp else 1.dp,
                color = if (isSelected) PersianGold else CardBorder,
                shape = RoundedCornerShape(16.dp)
            )
            .shadow(if (isSelected) 6.dp else 2.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color(0xFF223A5E) else CardBackground
        )
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = chapter.iconEmoji,
                fontSize = 24.sp
            )
            Text(
                text = chapter.title,
                fontSize = 13.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                color = if (isSelected) PersianGold else PersianOffWhite
            )
        }
    }
}

@Composable
private fun LevelGridItem(
    levelNumber: Int,
    isUnlocked: Boolean,
    isCurrent: Boolean,
    isCompleted: Boolean,
    stars: Int,
    onClick: () -> Unit
) {
    val backgroundBrush = when {
        isCurrent -> Brush.verticalGradient(listOf(PersianGold, PersianGoldDark))
        isCompleted -> Brush.verticalGradient(listOf(PersianEmerald, Color(0xFF00695C)))
        isUnlocked -> Brush.verticalGradient(listOf(TileBackground, Color(0xFF213752)))
        else -> Brush.verticalGradient(listOf(TileEmpty, Color(0xFF162436)))
    }

    val borderStrokeColor = when {
        isCurrent -> Color.White
        isCompleted -> PersianGold
        isUnlocked -> PersianTurquoise.copy(alpha = 0.5f)
        else -> Color.Transparent
    }

    Surface(
        modifier = Modifier
            .size(56.dp)
            .shadow(if (isCurrent || isCompleted) 4.dp else 1.dp, RoundedCornerShape(14.dp))
            .clip(RoundedCornerShape(14.dp))
            .clickable(enabled = isUnlocked, onClick = onClick)
            .border(1.5.dp, borderStrokeColor, RoundedCornerShape(14.dp)),
        shape = RoundedCornerShape(14.dp),
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundBrush),
            contentAlignment = Alignment.Center
        ) {
            if (isUnlocked) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = PersianUtils.toPersianNumber(levelNumber),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isCurrent) PersianNavy else Color.White
                    )
                    if (isCompleted && stars > 0) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(1.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            repeat(stars) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = null,
                                    tint = PersianGold,
                                    modifier = Modifier.size(10.dp)
                                )
                            }
                        }
                    }
                }
            } else {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "قفل",
                    tint = PersianOffWhite.copy(alpha = 0.35f),
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}
