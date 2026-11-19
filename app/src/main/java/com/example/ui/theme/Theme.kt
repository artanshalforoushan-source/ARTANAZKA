package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val PersianWordPuzzleColorScheme = darkColorScheme(
    primary = PersianGold,
    onPrimary = Color(0xFF1A1A1A),
    primaryContainer = PersianGoldDark,
    onPrimaryContainer = Color.White,
    secondary = PersianTurquoise,
    onSecondary = Color(0xFF0D1B2A),
    secondaryContainer = PersianTurquoiseDark,
    onSecondaryContainer = Color.White,
    tertiary = PersianEmerald,
    onTertiary = Color.White,
    background = BackgroundStart,
    onBackground = PersianOffWhite,
    surface = CardBackground,
    onSurface = Color.White,
    surfaceVariant = TileBackground,
    onSurfaceVariant = PersianOffWhite,
    outline = CardBorder,
    error = PersianPomegranate,
    onError = Color.White
)

@Composable
fun MyApplicationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = PersianWordPuzzleColorScheme,
        typography = Typography,
        content = content
    )
}
