package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.PersianGold
import com.example.ui.theme.PersianGoldDark
import com.example.ui.theme.PersianNavy

@Composable
fun WordPreviewPill(
    word: String,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = word.isNotEmpty(),
        enter = fadeIn(tween(100)) + scaleIn(tween(100)),
        exit = fadeOut(tween(100)) + scaleOut(tween(100)),
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .shadow(8.dp, RoundedCornerShape(24.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(PersianGoldDark, PersianGold, PersianGoldDark)
                    ),
                    shape = RoundedCornerShape(24.dp)
                )
                .border(2.dp, Color.White.copy(alpha = 0.8f), RoundedCornerShape(24.dp))
                .padding(horizontal = 24.dp, vertical = 8.dp)
                .testTag("word_preview_pill"),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = word,
                fontSize = 24.sp,
                fontWeight = FontWeight.Black,
                color = PersianNavy,
                letterSpacing = 1.sp
            )
        }
    }
}
