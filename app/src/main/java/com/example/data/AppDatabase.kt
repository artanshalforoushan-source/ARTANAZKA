package com.example.data

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {
    @Query("SELECT * FROM player_stats WHERE id = 1")
    fun getPlayerStatsFlow(): Flow<PlayerStatsEntity?>

    @Query("SELECT * FROM player_stats WHERE id = 1")
    suspend fun getPlayerStats(): PlayerStatsEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdatePlayerStats(stats: PlayerStatsEntity)

    @Query("SELECT * FROM level_records WHERE levelNumber = :levelNumber")
    fun getLevelRecordFlow(levelNumber: Int): Flow<LevelRecordEntity?>

    @Query("SELECT * FROM level_records WHERE levelNumber = :levelNumber")
    suspend fun getLevelRecord(levelNumber: Int): LevelRecordEntity?

    @Query("SELECT * FROM level_records")
    fun getAllLevelRecordsFlow(): Flow<List<LevelRecordEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateLevelRecord(record: LevelRecordEntity)

    @Query("UPDATE player_stats SET coins = coins + :amount WHERE id = 1")
    suspend fun addCoins(amount: Int)

    @Query("UPDATE player_stats SET coins = coins - :amount WHERE id = 1")
    suspend fun spendCoins(amount: Int)

    @Query("DELETE FROM level_records")
    suspend fun clearAllRecords()
}

@Database(
    entities = [PlayerStatsEntity::class, LevelRecordEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}
