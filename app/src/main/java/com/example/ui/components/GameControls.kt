package com.example.ui.components

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material.icons.filled.Workspaces
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.PersianUtils
import com.example.ui.theme.CardBackground
import com.example.ui.theme.CardBorder
import com.example.ui.theme.PersianEmerald
import com.example.ui.theme.PersianGold
import com.example.ui.theme.PersianGoldDark
import com.example.ui.theme.PersianNavy
import com.example.ui.theme.PersianOffWhite
import com.example.ui.theme.PersianTurquoise

@Composable
fun GameControls(
    onShuffle: () -> Unit,
    onHint: () -> Unit,
    onBonusChest: () -> Unit,
    onDictionary: () -> Unit,
    hintCost: Int = 40,
    bonusWordsCount: Int = 0,
    modifier: Modifier = Modifier
) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 8.dp)
                .testTag("game_controls"),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left: Shuffle button
            ControlButton(
                icon = Icons.Default.Shuffle,
                label = "بر زدن",
                onClick = onShuffle,
                testTag = "shuffle_button",
                tint = PersianTurquoise
            )

            // Bonus Chest Button
            ControlButton(
                icon = Icons.Default.AutoAwesome,
                label = if (bonusWordsCount > 0) "${PersianUtils.toPersianNumber(bonusWordsCount)} کلمه" else "شانس",
                onClick = onBonusChest,
                testTag = "bonus_chest_button",
                tint = PersianEmerald
            )

            // Dictionary / Words Meaning Button
            ControlButton(
                icon = Icons.Default.MenuBook,
                label = "معنی واژه‌ها",
                onClick = onDictionary,
                testTag = "dictionary_button",
                tint = PersianOffWhite
            )

            // Right: Hint Button with Cost
            HintButton(
                onClick = onHint,
                cost = hintCost
            )
        }
    }
}

@Composable
private fun ControlButton(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit,
    testTag: String,
    tint: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Surface(
            modifier = Modifier
                .size(48.dp)
                .shadow(4.dp, CircleShape),
            shape = CircleShape,
            color = CardBackground
        ) {
            IconButton(
                onClick = onClick,
                modifier = Modifier.testTag(testTag)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = tint,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            color = PersianOffWhite.copy(alpha = 0.85f)
        )
    }
}

@Composable
private fun HintButton(
    onClick: () -> Unit,
    cost: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Surface(
            modifier = Modifier
                .size(48.dp)
                .shadow(6.dp, CircleShape)
                .border(1.5.dp, PersianGold, CircleShape),
            shape = CircleShape,
            color = Color(0xFF2C1F05)
        ) {
            IconButton(
                onClick = onClick,
                modifier = Modifier.testTag("hint_button")
            ) {
                Icon(
                    imageVector = Icons.Default.Lightbulb,
                    contentDescription = "راهنمایی",
                    tint = PersianGold,
                    modifier = Modifier.size(26.dp)
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = "🪙",
                fontSize = 10.sp
            )
            Text(
                text = PersianUtils.toPersianNumber(cost),
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = PersianGold
            )
        }
    }
}
