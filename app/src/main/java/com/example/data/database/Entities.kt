package com.example.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserProfile(
    @PrimaryKey val id: Int = 1,
    val interests: String = "",
    val skills: String = "",
    val assets: String = "",
    val constraints: String = "",
    val onboardingCompleted: Boolean = false,
    val directionScore: Int = 15,
    val executionScore: Int = 10,
    val incomeScore: Int = 0,
    val consistencyScore: Int = 10,
    val skillScore: Int = 15,
    val overallScore: Int = 10,
    val currentEarnings: Double = 0.0,
    val incomeGoal: Double = 100.0,
    val activePathType: String = "",
    val activePathTitle: String = ""
)

@Entity(tableName = "income_opportunity")
data class IncomeOpportunity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val term: String, // IMMEDIATE, MEDIUM, LONG
    val description: String,
    val potentialEarnings: String,
    val difficulty: String,
    val actionSteps: String
)

@Entity(tableName = "roadmap_task")
data class RoadmapTask(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String,
    val daysText: String,
    val proofRequired: String,
    val evidenceType: String,
    val verificationLevel: String, // L1_SELF, L2_SCREENSHOT, L3_LINK, L4_REVENUE
    val approvalStatus: String = "NONE", // NONE, PENDING, APPROVED, REJECTED
    val submittedEvidence: String = "",
    val aiFeedback: String = "",
    val incomeGenerated: Double = 0.0
)

@Entity(tableName = "weekly_review")
data class WeeklyReview(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val timestamp: Long = System.currentTimeMillis(),
    val whatFinished: String,
    val whatStopped: String,
    val whatWorked: String,
    val whatFailed: String
)

@Entity(tableName = "achievement")
data class Achievement(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String,
    val isUnlocked: Boolean = false,
    val iconName: String
)
