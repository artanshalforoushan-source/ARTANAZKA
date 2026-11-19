package com.example.ui.audio

import android.content.Context
import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SoundManager(private val context: Context) {

    private var toneGenerator: ToneGenerator? = null
    private val scope = CoroutineScope(Dispatchers.Default)

    init {
        try {
            toneGenerator = ToneGenerator(AudioManager.STREAM_MUSIC, 70)
        } catch (e: Exception) {
            toneGenerator = null
        }
    }

    private val vibrator: Vibrator? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as? VibratorManager
            vibratorManager?.defaultVibrator
        } else {
            @Suppress("DEPRECATION")
            context.getSystemService(Context.VIBRATOR_SERVICE) as? Vibrator
        }
    }

    fun playLetterSelect(letterIndex: Int, isSoundEnabled: Boolean, isHapticEnabled: Boolean) {
        if (isHapticEnabled) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator?.vibrate(VibrationEffect.createOneShot(18, VibrationEffect.DEFAULT_AMPLITUDE))
                } else {
                    @Suppress("DEPRECATION")
                    vibrator?.vibrate(18)
                }
            } catch (_: Exception) {}
        }

        if (isSoundEnabled) {
            try {
                // Play melodic tone based on letter count
                val tones = listOf(
                    ToneGenerator.TONE_DTMF_1,
                    ToneGenerator.TONE_DTMF_2,
                    ToneGenerator.TONE_DTMF_3,
                    ToneGenerator.TONE_DTMF_4,
                    ToneGenerator.TONE_DTMF_5,
                    ToneGenerator.TONE_DTMF_6,
                    ToneGenerator.TONE_DTMF_7,
                    ToneGenerator.TONE_DTMF_8
                )
                val tone = tones[letterIndex.coerceIn(0, tones.size - 1)]
                toneGenerator?.startTone(tone, 45)
            } catch (_: Exception) {}
        }
    }

    fun playWordFound(isSoundEnabled: Boolean, isHapticEnabled: Boolean) {
        if (isHapticEnabled) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator?.vibrate(VibrationEffect.createWaveform(longArrayOf(0, 30, 40, 45), -1))
                } else {
                    @Suppress("DEPRECATION")
                    vibrator?.vibrate(60)
                }
            } catch (_: Exception) {}
        }

        if (isSoundEnabled) {
            scope.launch {
                try {
                    toneGenerator?.startTone(ToneGenerator.TONE_PROP_BEEP, 70)
                    delay(80)
                    toneGenerator?.startTone(ToneGenerator.TONE_PROP_ACK, 120)
                } catch (_: Exception) {}
            }
        }
    }

    fun playBonusWordFound(isSoundEnabled: Boolean, isHapticEnabled: Boolean) {
        if (isHapticEnabled) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator?.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE))
                }
            } catch (_: Exception) {}
        }

        if (isSoundEnabled) {
            scope.launch {
                try {
                    toneGenerator?.startTone(ToneGenerator.TONE_DTMF_9, 80)
                    delay(90)
                    toneGenerator?.startTone(ToneGenerator.TONE_DTMF_A, 100)
                } catch (_: Exception) {}
            }
        }
    }

    fun playLevelWin(isSoundEnabled: Boolean, isHapticEnabled: Boolean) {
        if (isHapticEnabled) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator?.vibrate(VibrationEffect.createWaveform(longArrayOf(0, 40, 60, 50, 70, 70), -1))
                } else {
                    @Suppress("DEPRECATION")
                    vibrator?.vibrate(200)
                }
            } catch (_: Exception) {}
        }

        if (isSoundEnabled) {
            scope.launch {
                try {
                    val fanfare = listOf(
                        ToneGenerator.TONE_DTMF_1,
                        ToneGenerator.TONE_DTMF_3,
                        ToneGenerator.TONE_DTMF_5,
                        ToneGenerator.TONE_DTMF_8
                    )
                    for (tone in fanfare) {
                        toneGenerator?.startTone(tone, 100)
                        delay(110)
                    }
                } catch (_: Exception) {}
            }
        }
    }

    fun playWrongWord(isSoundEnabled: Boolean, isHapticEnabled: Boolean) {
        if (isHapticEnabled) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator?.vibrate(VibrationEffect.createWaveform(longArrayOf(0, 25, 40, 25), -1))
                }
            } catch (_: Exception) {}
        }

        if (isSoundEnabled) {
            try {
                toneGenerator?.startTone(ToneGenerator.TONE_PROP_NACK, 100)
            } catch (_: Exception) {}
        }
    }

    fun playHint(isSoundEnabled: Boolean, isHapticEnabled: Boolean) {
        if (isHapticEnabled) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator?.vibrate(VibrationEffect.createOneShot(30, VibrationEffect.DEFAULT_AMPLITUDE))
                }
            } catch (_: Exception) {}
        }

        if (isSoundEnabled) {
            scope.launch {
                try {
                    toneGenerator?.startTone(ToneGenerator.TONE_DTMF_B, 70)
                    delay(80)
                    toneGenerator?.startTone(ToneGenerator.TONE_DTMF_D, 110)
                } catch (_: Exception) {}
            }
        }
    }
}
