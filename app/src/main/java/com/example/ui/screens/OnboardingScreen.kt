package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*
import com.example.ui.viewmodel.PathPilotViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingScreen(
    viewModel: PathPilotViewModel,
    onCompleted: () -> Unit
) {
    val scrollState = rememberScrollState()
    val isLoading by viewModel.isLoading
    val errorString by viewModel.errorString

    var dynamicLoadingText by remember { mutableStateOf("Consulting AI advisor...") }

    // Dynamic rotating loading captions
    LaunchedEffect(isLoading) {
        if (isLoading) {
            val phrases = listOf(
                "Analyzing interests and talent vectors...",
                "Scanning optimal digital income categories...",
                "Formulating immediate 1-30 day wealth paths...",
                "Sizing medium & long-term SaaS/Agency options...",
                "Constructing sequence of 5 proof-based milestones...",
                "Polishing customized mentor profile..."
            )
            var index = 0
            while (isLoading) {
                dynamicLoadingText = phrases[index % phrases.size]
                delay(2800)
                index++
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SpaceBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            // Brand Header Area
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(
                        Brush.radialGradient(listOf(IndigoElectric, Color.Transparent)),
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Explore,
                    contentDescription = null,
                    tint = TextPrimaryClean,
                    modifier = Modifier.size(36.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "PATHPILOT v2.0",
                style = MaterialTheme.typography.titleMedium,
                color = IndigoElectric,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp
            )

            Text(
                text = "Discover Direction. Execute. Monetize.",
                style = MaterialTheme.typography.headlineSmall,
                color = TextPrimaryClean,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
            )

            Text(
                text = "PathPilot generated checkposts don't offer generic advice. We require authentic evidence to unlock progress and verify online payouts.",
                style = MaterialTheme.typography.bodyMedium,
                color = TextSecondaryMuted,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 12.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Quick Setup Anchors
            Card(
                colors = CardDefaults.cardColors(containerColor = SurfaceSlate),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "⚡ PRESET PROFILE SHORTCUTS",
                        style = MaterialTheme.typography.labelLarge,
                        color = AmberAesthetic,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Select an archetype below to instantly populate onboarding answers:",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondaryMuted,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        PresetChip(
                            title = "Python Dev",
                            icon = Icons.Default.Code,
                            onClick = {
                                viewModel.onboardingInterests.value = "Technology, Coding, Open source scripting, AI automations"
                                viewModel.onboardingSkills.value = "Python core, API keys setup, Basic database, Linux shell"
                                viewModel.onboardingAssets.value = "Sturdy laptop, Fiber internet, GitHub profile"
                                viewModel.onboardingConstraints.value = "University student, No starting money, 15 hours / week max"
                            }
                        )
                        PresetChip(
                            title = "Fitness Guide",
                            icon = Icons.Default.FitnessCenter,
                            onClick = {
                                viewModel.onboardingInterests.value = "Nutrition, Bodybuilding, Exercise planning, Group motivation"
                                viewModel.onboardingSkills.value = "Meal preparation, Video filming, High communication, Instagram posting"
                                viewModel.onboardingAssets.value = "Smartphone, Basic home gym weights, Ring light"
                                viewModel.onboardingConstraints.value = "Has full-time day work, No capital, 10 hours / week available"
                            }
                        )
                        PresetChip(
                            title = "Visual Assistant",
                            icon = Icons.Default.DashboardCustomize,
                            onClick = {
                                viewModel.onboardingInterests.value = "Graphic Design, Digital layouts, Social scheduling, Branding templates"
                                viewModel.onboardingSkills.value = "Canva manipulation, Basic copywriting, Pinterest scheduling"
                                viewModel.onboardingAssets.value = "Laptop, Active Pinterest board, Canva free account"
                                viewModel.onboardingConstraints.value = "Freelancing starter, No cash flow, Can dedicate 25 hours / week"
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Onboarding Form
            Text(
                text = "1. WHAT EXCITES YOU? (INTERESTS)",
                style = MaterialTheme.typography.titleSmall,
                color = TextPrimaryClean,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = viewModel.onboardingInterests.value,
                onValueChange = { viewModel.onboardingInterests.value = it },
                placeholder = { Text("e.g., Fitness, Tech coding, Video editing, Blogging") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .testTag("onboarding_interests_input"),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = TextPrimaryClean,
                    unfocusedTextColor = TextPrimaryClean,
                    focusedContainerColor = SurfaceSlate,
                    unfocusedContainerColor = SurfaceSlate,
                    focusedBorderColor = IndigoElectric,
                    unfocusedBorderColor = BorderLight
                ),
                shape = RoundedCornerShape(8.dp),
                maxLines = 2
            )

            Text(
                text = "2. WHAT CAN YOU DELIVER? (SKILLS)",
                style = MaterialTheme.typography.titleSmall,
                color = TextPrimaryClean,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
            )
            OutlinedTextField(
                value = viewModel.onboardingSkills.value,
                onValueChange = { viewModel.onboardingSkills.value = it },
                placeholder = { Text("e.g., Python, Graphic design, Social media templates") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .testTag("onboarding_skills_input"),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = TextPrimaryClean,
                    unfocusedTextColor = TextPrimaryClean,
                    focusedContainerColor = SurfaceSlate,
                    unfocusedContainerColor = SurfaceSlate,
                    focusedBorderColor = IndigoElectric,
                    unfocusedBorderColor = BorderLight
                ),
                shape = RoundedCornerShape(8.dp),
                maxLines = 2
            )

            Text(
                text = "3. WHAT ASSETS DO YOU CONTROL? (EQUIPMENT, ENGINES)",
                style = MaterialTheme.typography.titleSmall,
                color = TextPrimaryClean,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
            )
            OutlinedTextField(
                value = viewModel.onboardingAssets.value,
                onValueChange = { viewModel.onboardingAssets.value = it },
                placeholder = { Text("e.g., Laptop, Smartphone, High-speed internet, Camera") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .testTag("onboarding_assets_input"),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = TextPrimaryClean,
                    unfocusedTextColor = TextPrimaryClean,
                    focusedContainerColor = SurfaceSlate,
                    unfocusedContainerColor = SurfaceSlate,
                    focusedBorderColor = IndigoElectric,
                    unfocusedBorderColor = BorderLight
                ),
                shape = RoundedCornerShape(8.dp),
                maxLines = 2
            )

            Text(
                text = "4. ANY OBSTACLES OR LIMITATIONS? (CONSTRAINTS)",
                style = MaterialTheme.typography.titleSmall,
                color = TextPrimaryClean,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
            )
            OutlinedTextField(
                value = viewModel.onboardingConstraints.value,
                onValueChange = { viewModel.onboardingConstraints.value = it },
                placeholder = { Text("e.g., Student, Full-time work, Zero cash, 12 hrs/wk limit") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .testTag("onboarding_constraints_input"),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = TextPrimaryClean,
                    unfocusedTextColor = TextPrimaryClean,
                    focusedContainerColor = SurfaceSlate,
                    unfocusedContainerColor = SurfaceSlate,
                    focusedBorderColor = IndigoElectric,
                    unfocusedBorderColor = BorderLight
                ),
                shape = RoundedCornerShape(8.dp),
                maxLines = 2
            )

            errorString?.let {
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0x33F43F5E), RoundedCornerShape(8.dp))
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.Error, contentDescription = null, tint = CoralVibrant)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = it, color = TextPrimaryClean, fontSize = 14.sp)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    viewModel.completeOnboarding(onCompleted)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .testTag("onboarding_submit_button"),
                colors = ButtonDefaults.buttonColors(containerColor = IndigoElectric),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "GENERATE INCOME ROADMAP",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(imageVector = Icons.Default.TrendingUp, contentDescription = null, tint = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(40.dp))
        }

        // Beautiful Overlay Loading Screen
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xEA0A0C10)),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(32.dp)
                ) {
                    CircularProgressIndicator(
                        color = IndigoElectric,
                        strokeWidth = 5.dp,
                        modifier = Modifier.size(72.dp)
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = "PILOTING ROADMAP",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = IndigoElectric,
                        letterSpacing = 3.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = dynamicLoadingText,
                        style = MaterialTheme.typography.bodyLarge,
                        color = TextPrimaryClean,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Gemini is engineering an tailored freelancing process matching your constraints.",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondaryMuted,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 12.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun PresetChip(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(SurfaceCardOff, RoundedCornerShape(20.dp))
            .clickable { onClick() }
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = IndigoElectric, modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(6.dp))
        Text(text = title, color = TextPrimaryClean, fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}
