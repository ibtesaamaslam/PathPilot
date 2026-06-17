package com.example.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PathPilotDao {
    // User Profile
    @Query("SELECT * FROM user_profile WHERE id = 1 LIMIT 1")
    fun getUserProfile(): Flow<UserProfile?>

    @Query("SELECT * FROM user_profile WHERE id = 1 LIMIT 1")
    suspend fun getUserProfileRaw(): UserProfile?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserProfile(profile: UserProfile)

    // Income Opportunities
    @Query("SELECT * FROM income_opportunity")
    fun getOpportunities(): Flow<List<IncomeOpportunity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOpportunities(opportunities: List<IncomeOpportunity>)

    @Query("DELETE FROM income_opportunity")
    suspend fun clearOpportunities()

    // Roadmap Tasks
    @Query("SELECT * FROM roadmap_task ORDER BY id ASC")
    fun getRoadmapTasks(): Flow<List<RoadmapTask>>

    @Query("SELECT * FROM roadmap_task WHERE id = :taskId LIMIT 1")
    suspend fun getTaskById(taskId: Int): RoadmapTask?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRoadmapTasks(tasks: List<RoadmapTask>)

    @Update
    suspend fun updateRoadmapTask(task: RoadmapTask)

    @Query("DELETE FROM roadmap_task")
    suspend fun clearRoadmapTasks()

    // Weekly Reviews
    @Query("SELECT * FROM weekly_review ORDER BY timestamp DESC")
    fun getWeeklyReviews(): Flow<List<WeeklyReview>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeeklyReview(review: WeeklyReview)

    // Achievements
    @Query("SELECT * FROM achievement")
    fun getAchievements(): Flow<List<Achievement>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAchievements(achievements: List<Achievement>)

    @Query("UPDATE achievement SET isUnlocked = 1 WHERE title = :title")
    suspend fun unlockAchievement(title: String)
}
