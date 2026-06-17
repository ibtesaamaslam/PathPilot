package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssignmentTurnedIn
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*
import com.example.ui.viewmodel.PathPilotViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeeklyReviewScreen(
    viewModel: PathPilotViewModel
) {
    val whatFinished by viewModel.weeklyWhatFinished
    val whatStopped by viewModel.weeklyWhatStopped
    val whatWorked by viewModel.weeklyWhatWorked
    val whatFailed by viewModel.weeklyWhatFailed
    val isSubmitting by viewModel.isWeeklySubmitting
    val advisoryFeedback by viewModel.weeklyFeedbackText

    val scrollState = rememberScrollState()
    var displayLoadingText by remember { mutableStateOf("Processing weekly logs...") }

    // Dynamic reflection phrases
    LaunchedEffect(isSubmitting) {
        if (isSubmitting) {
            val phrases = listOf(
                "Aggregating weekly execution performance logs...",
                "Calculating milestone velocity analytics...",
                "Drafting structured mentor recommendations...",
                "Assembling dynamic roadmap adjustments based on triggers...",
                "Polishing advisory feedback..."
            )
            var index = 0
            while (isSubmitting) {
                displayLoadingText = phrases[index % phrases.size]
                delay(2400)
                index++
            }
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(SpaceBackground)
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 24.dp, bottom = 100.dp)
    ) {
        item {
            Column(modifier = Modifier.padding(bottom = 20.dp)) {
                Text(
                    text = "7-DAY REVIEWS",
                    style = MaterialTheme.typography.labelSmall,
                    color = IndigoElectric,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
                Text(
                    text = "Weekly Accountability",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.ExtraBold,
                    color = TextPrimaryClean
                )
                Text(
                    text = "Every 7 days, complete an advisory review. Honest self-reflections help dynamic roadmap calibration and unlock consistency badges.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondaryMuted,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        // Onboarding Check
        item {
            Card(
                colors = CardDefaults.cardColors(containerColor = SurfaceSlate),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
                    .border(1.dp, BorderLight, RoundedCornerShape(12.dp))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "1. WHAT DID YOU FINISH THIS WEEK?",
                        style = MaterialTheme.typography.titleSmall,
                        color = TextPrimaryClean,
                        fontWeight = FontWeight.Bold
                    )
                    OutlinedTextField(
                        value = whatFinished,
                        onValueChange = { viewModel.weeklyWhatFinished.value = it },
                        placeholder = { Text("Describe milestones completed, tasks submitted, or other progress...") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(vertical = 8.dp)
                            .testTag("weekly_finished_input"),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = TextPrimaryClean,
                            unfocusedTextColor = TextPrimaryClean,
                            focusedContainerColor = SpaceBackground,
                            unfocusedContainerColor = SpaceBackground,
                            focusedBorderColor = IndigoElectric,
                            unfocusedBorderColor = BorderLight
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "2. WHAT OBSTACLES OR BLOCKS STOPPED YOU?",
                        style = MaterialTheme.typography.titleSmall,
                        color = TextPrimaryClean,
                        fontWeight = FontWeight.Bold
                    )
                    OutlinedTextField(
                        value = whatStopped,
                        onValueChange = { viewModel.weeklyWhatStopped.value = it },
                        placeholder = { Text("What distracted you? Lack of time? Technical difficulties?") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .padding(vertical = 8.dp)
                            .testTag("weekly_obstacles_input"),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = TextPrimaryClean,
                            unfocusedTextColor = TextPrimaryClean,
                            focusedContainerColor = SpaceBackground,
                            unfocusedContainerColor = SpaceBackground,
                            focusedBorderColor = IndigoElectric,
                            unfocusedBorderColor = BorderLight
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "3. WHAT WORKED? WHAT ACTIONABLE STRATEGY FAILED?",
                        style = MaterialTheme.typography.titleSmall,
                        color = TextPrimaryClean,
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = whatWorked,
                            onValueChange = { viewModel.weeklyWhatWorked.value = it },
                            placeholder = { Text("Strategies that worked...") },
                            modifier = Modifier
                                .weight(1f)
                                .height(90.dp)
                                .testTag("weekly_strategy_worked"),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedTextColor = TextPrimaryClean,
                                unfocusedTextColor = TextPrimaryClean,
                                focusedContainerColor = SpaceBackground,
                                unfocusedContainerColor = SpaceBackground,
                                focusedBorderColor = IndigoElectric,
                                unfocusedBorderColor = BorderLight
                            ),
                            shape = RoundedCornerShape(8.dp)
                        )

                        OutlinedTextField(
                            value = whatFailed,
                            onValueChange = { viewModel.weeklyWhatFailed.value = it },
                            placeholder = { Text("Struggles / failures...") },
                            modifier = Modifier
                                .weight(1f)
                                .height(90.dp)
                                .testTag("weekly_strategy_failed"),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedTextColor = TextPrimaryClean,
                                unfocusedTextColor = TextPrimaryClean,
                                focusedContainerColor = SpaceBackground,
                                unfocusedContainerColor = SpaceBackground,
                                focusedBorderColor = IndigoElectric,
                                unfocusedBorderColor = BorderLight
                            ),
                            shape = RoundedCornerShape(8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { viewModel.submitWeeklyReview {} },
                        colors = ButtonDefaults.buttonColors(containerColor = IndigoElectric),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .testTag("trigger_weekly_review_button")
                    ) {
                        Icon(Icons.Default.AutoAwesome, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("COMPUTE WEEKLY MENTOR REVIEW", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        // Advisory report feedback cards
        item {
            advisoryFeedback?.let { feedbackText ->
                Card(
                    colors = CardDefaults.cardColors(containerColor = SurfaceSlate),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp)
                        .border(1.dp, IndigoElectric, RoundedCornerShape(12.dp))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Psychology,
                                contentDescription = null,
                                tint = IndigoElectric,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "AI PILOT WEEKLY FEEDBACK",
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.ExtraBold,
                                color = IndigoElectric
                            )
                        }

                        Divider(color = BorderLight, modifier = Modifier.padding(vertical = 12.dp))

                        Text(
                            text = feedbackText,
                            fontSize = 13.sp,
                            color = TextPrimaryClean,
                            lineHeight = 18.sp
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .background(IndigoElectric.copy(alpha = 0.15f), RoundedCornerShape(6.dp))
                                .padding(10.dp)
                        ) {
                            Icon(Icons.Default.Info, contentDescription = null, tint = IndigoElectric, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "Milestones score & accountability indicators recalculated! Revised roadmap checks added automatically below.",
                                fontSize = 11.sp,
                                color = TextPrimaryClean,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
        }
    }

    // Interactive Overlay during Weekly process calculation
    if (isSubmitting) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xF20A0C10)),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(32.dp)
            ) {
                CircularProgressIndicator(
                    color = IndigoElectric,
                    strokeWidth = 5.dp,
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "CALIBRATING PILOT MATRIX",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Black,
                    color = IndigoElectric,
                    letterSpacing = 2.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = displayLoadingText,
                    color = TextPrimaryClean,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
