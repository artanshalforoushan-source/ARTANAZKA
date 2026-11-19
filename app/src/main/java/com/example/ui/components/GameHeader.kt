package com.example.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.PersianUtils
import com.example.ui.theme.CardBackground
import com.example.ui.theme.CardBorder
import com.example.ui.theme.PersianGold
import com.example.ui.theme.PersianGoldDark
import com.example.ui.theme.PersianNavy
import com.example.ui.theme.PersianOffWhite
import com.example.ui.theme.PersianTurquoise

@Composable
fun GameHeader(
    levelNumber: Int,
    chapterTitle: String,
    coins: Int,
    stars: Int,
    isDaily: Boolean,
    onMapClick: () -> Unit,
    onDailyClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .testTag("game_header")
        ) {
            // Top decorative banner bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Left side: Level Map / Back Button
                Surface(
                    modifier = Modifier
                        .size(44.dp)
                        .shadow(4.dp, CircleShape),
                    shape = CircleShape,
                    color = CardBackground
                ) {
                    IconButton(
                        onClick = onMapClick,
                        modifier = Modifier.testTag("map_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = "لیست مراحل",
                            tint = PersianTurquoise
                        )
                    }
                }

                // Middle: Level Title Badge
                Surface(
                    modifier = Modifier
                        .shadow(6.dp, RoundedCornerShape(20.dp))
                        .border(1.5.dp, CardBorder, RoundedCornerShape(20.dp)),
                    shape = RoundedCornerShape(20.dp),
                    color = CardBackground
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = if (isDaily) "چالش روزانه" else "مرحله ${PersianUtils.toPersianNumber(levelNumber)}",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = PersianGold
                        )
                        Text(
                            text = chapterTitle,
                            fontSize = 11.sp,
                            color = PersianOffWhite.copy(alpha = 0.8f)
                        )
                    }
                }

                // Right side: Coins Pill & Settings
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Coins Pill
                    Surface(
                        modifier = Modifier
                            .shadow(4.dp, RoundedCornerShape(16.dp))
                            .border(1.dp, PersianGold.copy(alpha = 0.6f), RoundedCornerShape(16.dp)),
                        shape = RoundedCornerShape(16.dp),
                        color = Color(0xFF1E2D42)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(
                                text = "🪙",
                                fontSize = 14.sp
                            )
                            AnimatedContent(
                                targetState = coins,
                                transitionSpec = {
                                    fadeIn(tween(150)) togetherWith fadeOut(tween(150))
                                },
                                label = "coins"
                            ) { targetCoins ->
                                Text(
                                    text = PersianUtils.toPersianNumber(targetCoins),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = PersianGold
                                )
                            }
                        }
                    }

                    // Settings Button
                    Surface(
                        modifier = Modifier
                            .size(44.dp)
                            .shadow(4.dp, CircleShape),
                        shape = CircleShape,
                        color = CardBackground
                    ) {
                        IconButton(
                            onClick = onSettingsClick,
                            modifier = Modifier.testTag("settings_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "تنظیمات",
                                tint = PersianOffWhite
                            )
                        }
                    }
                }
            }
        }
    }
}
