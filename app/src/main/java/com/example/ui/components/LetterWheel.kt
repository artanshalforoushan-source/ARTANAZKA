package com.example.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.PersianGold
import com.example.ui.theme.PersianGoldDark
import com.example.ui.theme.PersianNavy
import com.example.ui.theme.PersianTurquoise
import com.example.ui.theme.PersianTurquoiseLight
import com.example.ui.theme.WoodBorder
import com.example.ui.theme.WoodWarm
import kotlin.math.cos
import kotlin.math.hypot
import kotlin.math.sin

@Composable
fun LetterWheel(
    letters: List<String>,
    selectedIndices: List<Int>,
    onLetterTouch: (Int) -> Unit,
    onDragEnd: () -> Unit,
    modifier: Modifier = Modifier,
    wheelSize: Dp = 260.dp
) {
    val density = LocalDensity.current
    var currentTouchPoint by remember { mutableStateOf<Offset?>(null) }

    // Enforce LTR for the coordinate math so TopStart is (0,0) on left and trigonometric positions match precisely
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        BoxWithConstraints(
            modifier = modifier
                .size(wheelSize)
                .testTag("letter_wheel_container")
        ) {
            val sizePx = with(density) { wheelSize.toPx() }
            val center = Offset(sizePx / 2f, sizePx / 2f)

            val count = letters.size
            val (radius, letterNodeRadius) = remember(count, sizePx) {
                when {
                    count <= 3 -> Pair(sizePx * 0.32f, sizePx * 0.14f)
                    count == 4 -> Pair(sizePx * 0.34f, sizePx * 0.13f)
                    count == 5 -> Pair(sizePx * 0.35f, sizePx * 0.12f)
                    count == 6 -> Pair(sizePx * 0.36f, sizePx * 0.11f)
                    count == 7 -> Pair(sizePx * 0.37f, sizePx * 0.10f)
                    else -> Pair(sizePx * 0.37f, sizePx * 0.09f)
                }
            }

            // Calculate precise Cartesian positions of each letter node
            val letterPositions = remember(letters, count, sizePx, radius) {
                val startAngle = -Math.PI / 2.0 // Top
                List(count) { i ->
                    val angle = startAngle + (2.0 * Math.PI * i / count)
                    Offset(
                        x = (center.x + radius * cos(angle)).toFloat(),
                        y = (center.y + radius * sin(angle)).toFloat()
                    )
                }
            }

            // Background Disc & Drag Gesture Canvas
            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(letters, letterPositions, letterNodeRadius) {
                        detectDragGestures(
                            onDragStart = { offset ->
                                currentTouchPoint = offset
                                letterPositions.forEachIndexed { index, nodePos ->
                                    val dist = hypot(offset.x - nodePos.x, offset.y - nodePos.y)
                                    if (dist <= letterNodeRadius * 1.6f) {
                                        onLetterTouch(index)
                                    }
                                }
                            },
                            onDrag = { change, _ ->
                                change.consume()
                                val offset = change.position
                                currentTouchPoint = offset
                                letterPositions.forEachIndexed { index, nodePos ->
                                    val dist = hypot(offset.x - nodePos.x, offset.y - nodePos.y)
                                    if (dist <= letterNodeRadius * 1.5f) {
                                        onLetterTouch(index)
                                    }
                                }
                            },
                            onDragEnd = {
                                currentTouchPoint = null
                                onDragEnd()
                            },
                            onDragCancel = {
                                currentTouchPoint = null
                                onDragEnd()
                            }
                        )
                    }
            ) {
                // Background Radial Wheel Disc
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            Color(0xFF243B5C),
                            Color(0xFF14243B)
                        ),
                        center = center,
                        radius = sizePx * 0.48f
                    ),
                    radius = sizePx * 0.47f,
                    center = center
                )

                // Outer decorative border
                drawCircle(
                    color = PersianGold.copy(alpha = 0.5f),
                    radius = sizePx * 0.47f,
                    center = center,
                    style = Stroke(
                        width = 2.5.dp.toPx(),
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(16f, 12f), 0f)
                    )
                )

                // Inner track ring
                drawCircle(
                    color = PersianTurquoise.copy(alpha = 0.25f),
                    radius = radius,
                    center = center,
                    style = Stroke(width = 2.dp.toPx())
                )

                // Draw glowing connected paths between selected letters
                if (selectedIndices.isNotEmpty()) {
                    val pathPoints = selectedIndices.mapNotNull { letterPositions.getOrNull(it) }
                    for (i in 0 until pathPoints.size - 1) {
                        val p1 = pathPoints[i]
                        val p2 = pathPoints[i + 1]

                        // Wide outer glow
                        drawLine(
                            brush = Brush.linearGradient(listOf(PersianTurquoiseLight, PersianGold)),
                            start = p1,
                            end = p2,
                            strokeWidth = 14.dp.toPx(),
                            cap = StrokeCap.Round,
                            alpha = 0.4f
                        )

                        // Core solid line
                        drawLine(
                            brush = Brush.linearGradient(listOf(PersianTurquoise, PersianGold)),
                            start = p1,
                            end = p2,
                            strokeWidth = 5.dp.toPx(),
                            cap = StrokeCap.Round
                        )
                    }

                    // Trailing line to current finger drag position
                    currentTouchPoint?.let { touch ->
                        val lastPoint = pathPoints.lastOrNull()
                        if (lastPoint != null) {
                            drawLine(
                                brush = Brush.linearGradient(listOf(PersianGold, PersianTurquoiseLight)),
                                start = lastPoint,
                                end = touch,
                                strokeWidth = 4.5.dp.toPx(),
                                cap = StrokeCap.Round,
                                alpha = 0.85f
                            )
                        }
                    }
                }
            }

            // Render Letter Nodes with exact absolute coordinates
            letters.forEachIndexed { index, letter ->
                val pos = letterPositions.getOrNull(index) ?: Offset.Zero
                val isSelected = selectedIndices.contains(index)

                val nodeDiameterPx = letterNodeRadius * 2f
                val leftPx = pos.x - letterNodeRadius
                val topPx = pos.y - letterNodeRadius

                val leftDp = with(density) { leftPx.toDp() }
                val topDp = with(density) { topPx.toDp() }
                val nodeSizeDp = with(density) { nodeDiameterPx.toDp() }

                val scaleAnim = remember { Animatable(1f) }
                LaunchedEffect(isSelected) {
                    if (isSelected) {
                        scaleAnim.animateTo(
                            targetValue = 1.18f,
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessMedium
                            )
                        )
                    } else {
                        scaleAnim.animateTo(1f, tween(120))
                    }
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(x = leftDp, y = topDp)
                        .size(nodeSizeDp)
                        .scale(scaleAnim.value)
                        .shadow(
                            elevation = if (isSelected) 10.dp else 4.dp,
                            shape = CircleShape,
                            spotColor = if (isSelected) PersianGold else Color.Black
                        )
                        .clip(CircleShape)
                        .border(
                            width = if (isSelected) 2.5.dp else 1.5.dp,
                            color = if (isSelected) PersianGold else Color(0xFF8D6E63),
                            shape = CircleShape
                        )
                        .background(
                            brush = if (isSelected) {
                                Brush.verticalGradient(listOf(PersianGold, PersianGoldDark))
                            } else {
                                Brush.verticalGradient(listOf(Color(0xFFFFF8E7), Color(0xFFE8DCC4)))
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = letter,
                        fontSize = if (nodeSizeDp >= 60.dp) 28.sp else if (nodeSizeDp >= 50.dp) 24.sp else 20.sp,
                        fontWeight = FontWeight.Black,
                        color = if (isSelected) PersianNavy else Color(0xFF3E2723)
                    )
                }
            }
        }
    }
}
