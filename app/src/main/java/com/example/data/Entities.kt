package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_stats")
data class PlayerStatsEntity(
    @PrimaryKey val id: Int = 1,
    val coins: Int = 200,
    val currentLevel: Int = 1,
    val totalStars: Int = 0,
    val soundEnabled: Boolean = true,
    val hapticEnabled: Boolean = true,
    val bonusWordsCount: Int = 0,
    val lastDailyChallengeDate: String = "",
    val dailyStreak: Int = 0
)

@Entity(tableName = "level_records")
data class LevelRecordEntity(
    @PrimaryKey val levelNumber: Int,
    val isCompleted: Boolean = false,
    val stars: Int = 0,
    val solvedWords: String = "", // Comma separated list of solved words
    val revealedLetters: String = "", // Revealed hint letters format: "WORD_INDEX:LETTER_INDEX,..."
    val bonusWordsFound: String = "" // Comma separated list of bonus words found
)
