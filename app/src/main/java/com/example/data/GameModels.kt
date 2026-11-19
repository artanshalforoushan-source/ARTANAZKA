package com.example.data

data class TargetWord(
    val word: String,
    val definition: String
)

enum class LevelDifficulty {
    EASY, MEDIUM, HARD, EXPERT
}

data class Level(
    val id: Int,
    val chapterId: Int,
    val chapterTitle: String,
    val letters: List<String>,
    val targetWords: List<TargetWord>,
    val bonusWords: List<String> = emptyList(),
    val difficulty: LevelDifficulty = LevelDifficulty.EASY
)

data class Chapter(
    val id: Int,
    val title: String,
    val subtitle: String,
    val startLevel: Int,
    val endLevel: Int,
    val colorHex: Long,
    val iconEmoji: String
)

object PersianUtils {
    private val englishDigits = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
    private val persianDigits = charArrayOf('۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹')

    fun toPersianNumber(number: Int): String {
        return toPersianDigits(number.toString())
    }

    fun toPersianDigits(text: String): String {
        var result = text
        for (i in 0..9) {
            result = result.replace(englishDigits[i], persianDigits[i])
        }
        return result
    }

    fun normalizePersianWord(input: String): String {
        return input.trim()
            .replace('ي', 'ی')
            .replace('ك', 'ک')
            .replace('ة', 'ه')
            .replace('آ', 'ا') // In game word connects, آ and ا can often match smoothly
            .replace(" ", "")
    }

    fun wordsMatch(w1: String, w2: String): Boolean {
        val n1 = normalizePersianWord(w1)
        val n2 = normalizePersianWord(w2)
        return n1 == n2
    }
}
