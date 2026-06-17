package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.database.Achievement
import com.example.data.database.RoadmapTask
import com.example.data.database.UserProfile
import com.example.ui.theme.*
import com.example.ui.viewmodel.PathPilotViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    viewModel: PathPilotViewModel,
    userProfile: UserProfile,
    onNavigateToSubmit: () -> Unit
) {
    val tasks by viewModel.roadmapTasks.collectAsState()
    val achievements by viewModel.achievements.collectAsState()

    var selectedTaskForDetails by remember { mutableStateOf<RoadmapTask?>(null) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(SpaceBackground)
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 24.dp, bottom = 100.dp)
    ) {
        // App top identity banner
        item {
            Row(
                modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "PATHPILOT ACTIVE BOARD",
                        style = MaterialTheme.typography.labelSmall,
                        color = IndigoElectric,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "Welcome back, Pilot",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.ExtraBold,
                        color = TextPrimaryClean
                    )
                }

                IconButton(
                    onClick = { viewModel.resetOnboarding() },
                    modifier = Modifier
                        .background(SurfaceCardOff, CircleShape)
                        .testTag("reset_data_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Reset All Onboarding Data",
                        tint = CoralVibrant
                    )
                }
            }
        }

        // Selected path and active targets
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = SurfaceSlate),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
                    .border(1.dp, BorderLight, RoundedCornerShape(16.dp))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(IndigoElectric.copy(alpha = 0.2f), RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.TrendingUp, contentDescription = null, tint = IndigoElectric)
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text(
                                text = "ACTIVE PATH: ${userProfile.activePathType.uppercase()}",
                                style = MaterialTheme.typography.labelMedium,
                                color = IndigoElectric,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = userProfile.activePathTitle,
                                style = MaterialTheme.typography.titleMedium,
                                color = TextPrimaryClean,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Earnings display
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "VERIFIED CASH GENERATION",
                                style = MaterialTheme.typography.labelSmall,
                                color = TextSecondaryMuted,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "$${String.format("%.2f", userProfile.currentEarnings)}",
                                style = MaterialTheme.typography.headlineMedium,
                                color = EmeraldSleek,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }

                        Card(
                            colors = CardDefaults.cardColors(containerColor = SurfaceCardOff),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = "GOAL: $${String.format("%.0f", userProfile.incomeGoal)}",
                                style = MaterialTheme.typography.labelMedium,
                                color = AmberAesthetic,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Income goal progress builder
                    val pct = (userProfile.currentEarnings / userProfile.incomeGoal).toFloat().coerceIn(0f, 1f)
                    LinearProgressIndicator(
                        progress = { pct },
                        color = EmeraldSleek,
                        trackColor = SurfaceCardOff,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp))
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "First Milestone Progress", fontSize = 11.sp, color = TextSecondaryMuted)
                        Text(text = "${(pct * 100).toInt()}% Achieved", fontSize = 11.sp, color = EmeraldSleek, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        // Metrics cockpit grid
        item {
            Text(
                text = "PILOT SUCCESS CORE SCORES",
                style = MaterialTheme.typography.labelSmall,
                color = TextSecondaryMuted,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ScoreMeterBox(
                    label = "Overall Growth",
                    score = userProfile.overallScore,
                    icon = Icons.Default.BarChart,
                    color = IndigoElectric,
                    modifier = Modifier.weight(1.5f)
                )

                Column(
                    modifier = Modifier.weight(2f),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        ScoreMeterBoxSmall(label = "Direction", score = userProfile.directionScore, color = IndigoElectric, modifier = Modifier.weight(1f))
                        ScoreMeterBoxSmall(label = "Execution", score = userProfile.executionScore, color = EmeraldSleek, modifier = Modifier.weight(1f))
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        ScoreMeterBoxSmall(label = "Income", score = userProfile.incomeScore, color = AmberAesthetic, modifier = Modifier.weight(1f))
                        ScoreMeterBoxSmall(label = "Consistency", score = userProfile.consistencyScore, color = TextPrimaryClean, modifier = Modifier.weight(1f))
                    }
                }
            }
        }

        // Achievements Section
        item {
            Text(
                text = "UNLOCKED PILOT MILESTONES",
                style = MaterialTheme.typography.labelSmall,
                color = TextSecondaryMuted,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
                    .background(SurfaceSlate, RoundedCornerShape(12.dp))
                    .border(1.dp, BorderLight, RoundedCornerShape(12.dp))
                    .padding(12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (achievements.isEmpty()) {
                    Text("Loading milestones...", color = TextSecondaryMuted, fontSize = 12.sp)
                } else {
                    achievements.forEach { achievement ->
                        AchievementIcon(achievement)
                    }
                }
            }
        }

        // Sequential Roadmaps Header
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "ROADMAP SEQUENCE (TASKS)",
                    style = MaterialTheme.typography.labelSmall,
                    color = TextSecondaryMuted,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${tasks.count { it.approvalStatus == "APPROVED" }} / ${tasks.size} DONE",
                    style = MaterialTheme.typography.labelSmall,
                    color = EmeraldSleek,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }

        // Task Items list
        if (tasks.isEmpty()) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(SurfaceSlate, RoundedCornerShape(12.dp))
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Roadmap sequence empty. Complete onboarding to generate milestones.",
                        color = TextSecondaryMuted,
                        textAlign = TextAlign.Center,
                        fontSize = 13.sp
                    )
                }
            }
        } else {
            itemsIndexed(tasks) { index, task ->
                TaskCard(
                    task = task,
                    stepIndex = index + 1,
                    onSelected = {
                        selectedTaskForDetails = task
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }

    // Modal Drawer for task outline & feedback
    selectedTaskForDetails?.let { task ->
        AlertDialog(
            onDismissRequest = { selectedTaskForDetails = null },
            confirmButton = {},
            dismissButton = {
                TextButton(onClick = { selectedTaskForDetails = null }) {
                    Text("Close", color = TextSecondaryMuted)
                }
            },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(IndigoElectric.copy(alpha = 0.2f), RoundedCornerShape(6.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = task.daysText.replace("Day ", "D"),
                            fontWeight = FontWeight.Bold,
                            fontSize = 11.sp,
                            color = IndigoElectric
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = task.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = TextPrimaryClean
                    )
                }
            },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Text(
                        text = "DESCRIPTION",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextSecondaryMuted,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = task.description,
                        fontSize = 14.sp,
                        color = TextPrimaryClean,
                        modifier = Modifier.padding(bottom = 12.dp, top = 2.dp)
                    )

                    Divider(color = BorderLight, modifier = Modifier.padding(vertical = 8.dp))

                    Text(
                        text = "PROOF REQUIRED",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextSecondaryMuted,
                        letterSpacing = 1.sp
                    )
                    Row(
                        modifier = Modifier.padding(top = 2.dp, bottom = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Verified,
                            contentDescription = null,
                            tint = AmberAesthetic,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "${task.proofRequired} (Expected: ${task.evidenceType})",
                            fontSize = 13.sp,
                            color = TextPrimaryClean,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    if (task.approvalStatus != "NONE") {
                        Divider(color = BorderLight, modifier = Modifier.padding(vertical = 8.dp))

                        Text(
                            text = "YOUR EVIDENCE SUBMISSION",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextSecondaryMuted,
                            letterSpacing = 1.sp
                        )
                        Text(
                            text = task.submittedEvidence,
                            fontSize = 13.sp,
                            color = TextPrimaryClean,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top = 2.dp, bottom = 8.dp)
                        )

                        // AI mentor reaction statement
                        if (task.aiFeedback.isNotEmpty()) {
                            Card(
                                colors = CardDefaults.cardColors(containerColor = SurfaceCardOff),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp)
                            ) {
                                Row(
                                    modifier = Modifier.padding(12.dp),
                                    verticalAlignment = Alignment.Top
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Psychology,
                                        contentDescription = null,
                                        tint = IndigoElectric,
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Column {
                                        Text(
                                            text = "AI PILOT MENTOR",
                                            fontSize = 9.sp,
                                            color = IndigoElectric,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = task.aiFeedback,
                                            fontSize = 12.sp,
                                            color = TextPrimaryClean,
                                            modifier = Modifier.padding(top = 2.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }

                    if (task.approvalStatus != "APPROVED") {
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                viewModel.selectTaskForSubmission(task)
                                selectedTaskForDetails = null
                                onNavigateToSubmit()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = IndigoElectric),
                            modifier = Modifier.fillMaxWidth().testTag("open_submit_button_dialog")
                        ) {
                            Icon(Icons.Default.UploadFile, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (task.approvalStatus == "NONE") "SUBMIT PROOF EVIDENCE" else "RESUBMIT PROOF",
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            },
            containerColor = SpaceBackground,
            shape = RoundedCornerShape(16.dp)
        )
    }
}

@Composable
fun ScoreMeterBox(
    label: String,
    score: Int,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = SurfaceSlate),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier.border(1.dp, BorderLight, RoundedCornerShape(12.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(imageVector = icon, contentDescription = null, tint = color, modifier = Modifier.size(24.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$score",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = color
            )
            Text(
                text = label.uppercase(),
                fontSize = 9.sp,
                color = TextSecondaryMuted,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun ScoreMeterBoxSmall(
    label: String,
    score: Int,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = SurfaceSlate),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.border(1.dp, BorderLight, RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$score",
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold,
                color = color
            )
            Text(
                text = label,
                fontSize = 9.sp,
                color = TextSecondaryMuted,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun AchievementIcon(achievement: Achievement) {
    val enabled = achievement.isUnlocked
    val tintColor = if (enabled) AmberAesthetic else TextSecondaryMuted.copy(alpha = 0.4f)
    val bgColor = if (enabled) IndigoElectric.copy(alpha = 0.2f) else SurfaceCardOff

    Box(
        modifier = Modifier
            .size(44.dp)
            .background(bgColor, RoundedCornerShape(8.dp))
            .border(
                width = if (enabled) 1.dp else 0.dp,
                color = if (enabled) IndigoElectric else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = when (achievement.iconName) {
                "monetization_on" -> Icons.Default.MonetizationOn
                "verified" -> Icons.Default.Verified
                "assistant_navigation" -> Icons.Default.Explore
                "update" -> Icons.Default.Update
                else -> Icons.Default.EmojiEvents
            },
            contentDescription = achievement.title,
            tint = tintColor,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun TaskCard(
    task: RoadmapTask,
    stepIndex: Int,
    onSelected: () -> Unit
) {
    val borderCol = when (task.approvalStatus) {
        "APPROVED" -> EmeraldSleek
        "PENDING" -> AmberAesthetic
        "REJECTED" -> CoralVibrant
        else -> BorderLight
    }

    Card(
        colors = CardDefaults.cardColors(containerColor = SurfaceSlate),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, borderCol, RoundedCornerShape(12.dp))
            .clickable { onSelected() }
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Circle progressive task number
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(
                        if (task.approvalStatus == "APPROVED") EmeraldSleek else SurfaceCardOff,
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (task.approvalStatus == "APPROVED") {
                    Icon(Icons.Default.Check, contentDescription = null, tint = SpaceBackground, modifier = Modifier.size(14.dp))
                } else {
                    Text(text = "$stepIndex", color = TextSecondaryMuted, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = task.daysText.uppercase(),
                        fontSize = 10.sp,
                        color = IndigoElectric,
                        fontWeight = FontWeight.Bold
                    )

                    // Compact action tag status banner
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .background(
                                color = when (task.approvalStatus) {
                                    "APPROVED" -> EmeraldSleek.copy(alpha = 0.1f)
                                    "PENDING" -> AmberAesthetic.copy(alpha = 0.1f)
                                    "REJECTED" -> CoralVibrant.copy(alpha = 0.1f)
                                    else -> SurfaceCardOff
                                },
                                shape = RoundedCornerShape(4.dp)
                            )
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        val statusText = when (task.approvalStatus) {
                            "APPROVED" -> "COMPLETE"
                            "PENDING" -> "UNDER REVIEW"
                            "REJECTED" -> "NEEDS FIX"
                            else -> "TODO"
                        }
                        val statusColor = when (task.approvalStatus) {
                            "APPROVED" -> EmeraldSleek
                            "PENDING" -> AmberAesthetic
                            "REJECTED" -> CoralVibrant
                            else -> TextSecondaryMuted
                        }
                        Text(
                            text = statusText,
                            fontSize = 8.sp,
                            color = statusColor,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Text(
                    text = task.title,
                    fontSize = 14.sp,
                    color = TextPrimaryClean,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 2.dp)
                )

                Text(
                    text = "Requires: ${task.proofRequired}",
                    fontSize = 11.sp,
                    color = TextSecondaryMuted,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
        }
    }
}
