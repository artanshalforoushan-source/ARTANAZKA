package com.example.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material.icons.filled.Vibration
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
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
import androidx.compose.ui.window.Dialog
import com.example.data.Level
import com.example.data.PersianUtils
import com.example.data.TargetWord
import com.example.ui.theme.CardBackground
import com.example.ui.theme.CardBorder
import com.example.ui.theme.PersianEmerald
import com.example.ui.theme.PersianGold
import com.example.ui.theme.PersianGoldDark
import com.example.ui.theme.PersianNavy
import com.example.ui.theme.PersianOffWhite
import com.example.ui.theme.PersianPomegranate
import com.example.ui.theme.PersianTurquoise
import com.example.ui.theme.TileBackground

@Composable
fun LevelWinDialog(
    level: Level,
    onNextLevel: () -> Unit,
    onDismiss: () -> Unit
) {
    val scaleAnim = remember { Animatable(0.7f) }
    LaunchedEffect(Unit) {
        scaleAnim.animateTo(
            targetValue = 1f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
    }

    Dialog(onDismissRequest = onDismiss) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .scale(scaleAnim.value)
                    .shadow(16.dp, RoundedCornerShape(28.dp))
                    .border(2.dp, PersianGold, RoundedCornerShape(28.dp))
                    .testTag("level_win_dialog"),
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(containerColor = CardBackground)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // Header Trophy & Stars
                    Text(
                        text = "🎉 آفرین! مرحله حل شد 🎉",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black,
                        color = PersianGold,
                        textAlign = TextAlign.Center
                    )

                    // 3 Animated Stars
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        repeat(3) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "ستاره",
                                tint = PersianGold,
                                modifier = Modifier.size(38.dp)
                            )
                        }
                    }

                    // Reward badge
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = Color(0xFF1E3A2F),
                        border = androidx.compose.foundation.BorderStroke(1.dp, PersianEmerald)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Text(text = "🪙", fontSize = 16.sp)
                            Text(
                                text = "جایزه: +۵۰ سکه طلایی",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = PersianOffWhite
                            )
                        }
                    }

                    // Words summary list
                    Text(
                        text = "واژه‌های کشف شده:",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = PersianTurquoise
                    )

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        level.targetWords.forEach { target ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(TileBackground, RoundedCornerShape(10.dp))
                                    .padding(horizontal = 12.dp, vertical = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = target.word,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = PersianGold
                                )
                                Text(
                                    text = target.definition,
                                    fontSize = 12.sp,
                                    color = PersianOffWhite.copy(alpha = 0.85f),
                                    modifier = Modifier.padding(start = 8.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    // Next Level Button
                    Button(
                        onClick = onNextLevel,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                            .testTag("next_level_button"),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = PersianGoldDark)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "مرحله بعدی",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun WordDefinitionDialog(
    targetWords: List<TargetWord>,
    solvedWords: Set<String>,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(16.dp, RoundedCornerShape(24.dp))
                    .border(1.5.dp, PersianTurquoise, RoundedCornerShape(24.dp))
                    .testTag("dictionary_dialog"),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = CardBackground)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "📖 فرهنگ لغت و معانی کلمات",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = PersianTurquoise
                        )
                        IconButton(onClick = onDismiss) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "بستن",
                                tint = PersianOffWhite
                            )
                        }
                    }

                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(targetWords) { target ->
                            val isSolved = solvedWords.contains(target.word)
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(TileBackground, RoundedCornerShape(12.dp))
                                    .padding(12.dp),
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = if (isSolved) target.word else "؟؟؟",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isSolved) PersianGold else PersianOffWhite.copy(alpha = 0.5f)
                                    )
                                    Text(
                                        text = if (isSolved) "کشف شده ✅" else "قفل 🔒",
                                        fontSize = 12.sp,
                                        color = if (isSolved) PersianEmerald else PersianOffWhite.copy(alpha = 0.6f)
                                    )
                                }
                                Text(
                                    text = if (isSolved) target.definition else "با حدس زدن کلمه معنی آن باز می‌شود.",
                                    fontSize = 13.sp,
                                    color = PersianOffWhite.copy(alpha = 0.85f)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BonusWordsDialog(
    bonusWords: Set<String>,
    totalBonusCount: Int,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(16.dp, RoundedCornerShape(24.dp))
                    .border(1.5.dp, PersianEmerald, RoundedCornerShape(24.dp))
                    .testTag("bonus_words_dialog"),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = CardBackground)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "🎁 صندوقچه کلمات اضافی",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = PersianEmerald
                        )
                        IconButton(onClick = onDismiss) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "بستن",
                                tint = PersianOffWhite
                            )
                        }
                    }

                    Text(
                        text = "با پیدا کردن کلمات معنادار دیگری که در جدول نیستند، سکه جایزه بگیرید! هر کلمه اضافه = ۱۰ سکه 🪙",
                        fontSize = 13.sp,
                        color = PersianOffWhite.copy(alpha = 0.9f),
                        textAlign = TextAlign.Center
                    )

                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = TileBackground,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(14.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "مجموع کلمات اضافی کشف شده: ${PersianUtils.toPersianNumber(totalBonusCount)}",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = PersianGold
                            )

                            if (bonusWords.isNotEmpty()) {
                                Text(
                                    text = "کلمات پیدا شده در این مرحله: " + bonusWords.joinToString(" ، "),
                                    fontSize = 13.sp,
                                    color = PersianTurquoise
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SettingsDialog(
    soundEnabled: Boolean,
    hapticEnabled: Boolean,
    onToggleSound: () -> Unit,
    onToggleHaptic: () -> Unit,
    onResetProgress: () -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(16.dp, RoundedCornerShape(24.dp))
                    .border(1.5.dp, CardBorder, RoundedCornerShape(24.dp))
                    .testTag("settings_dialog"),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = CardBackground)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "⚙️ تنظیمات بازی",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = PersianOffWhite
                        )
                        IconButton(onClick = onDismiss) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "بستن",
                                tint = PersianOffWhite
                            )
                        }
                    }

                    // Sound Toggle Row
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(TileBackground, RoundedCornerShape(12.dp))
                            .padding(horizontal = 14.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(imageVector = Icons.Default.VolumeUp, contentDescription = null, tint = PersianTurquoise)
                            Text(text = "صدای بازی", fontSize = 15.sp, color = PersianOffWhite)
                        }
                        Switch(
                            checked = soundEnabled,
                            onCheckedChange = { onToggleSound() },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = PersianGold,
                                checkedTrackColor = PersianGoldDark
                            )
                        )
                    }

                    // Vibration Toggle Row
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(TileBackground, RoundedCornerShape(12.dp))
                            .padding(horizontal = 14.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(imageVector = Icons.Default.Vibration, contentDescription = null, tint = PersianTurquoise)
                            Text(text = "لرزش (ویبره)", fontSize = 15.sp, color = PersianOffWhite)
                        }
                        Switch(
                            checked = hapticEnabled,
                            onCheckedChange = { onToggleHaptic() },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = PersianGold,
                                checkedTrackColor = PersianGoldDark
                            )
                        )
                    }

                    HorizontalDivider(color = CardBorder)

                    // Reset progress button
                    Button(
                        onClick = onResetProgress,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(44.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = PersianPomegranate.copy(alpha = 0.8f))
                    ) {
                        Text(
                            text = "شروع مجدد از مرحله ۱",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}
