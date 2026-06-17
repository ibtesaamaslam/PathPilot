package com.example.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun ProofSubmissionScreen(
    viewModel: PathPilotViewModel,
    onBack: () -> Unit
) {
    val task by viewModel.activeSubmittingTask
    val evidenceText by viewModel.submittedEvidenceText
    val evidenceType by viewModel.submittedEvidenceType
    val isVerifying by viewModel.isVerifyingEvidence
    val feedback by viewModel.verificationFeedback

    val scrollState = rememberScrollState()
    var displayLoadingText by remember { mutableStateOf("Inspecting submitted asset...") }

    // Dynamic verification phrases
    LaunchedEffect(isVerifying) {
        if (isVerifying) {
            val steps = listOf(
                "Establishing secure connection to proof resource...",
                "Running structural integrity validations...",
                "Scanning submitted URL/Text for relevance...",
                "AI grading execution quality and completeness...",
                "Calculating outcome milestones and reward scoring...",
                "Writing mentor feedback response..."
            )
            var index = 0
            while (isVerifying) {
                displayLoadingText = steps[index % steps.size]
                delay(2200)
                index++
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("EVIDENCE SUBMISSION", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium, color = TextPrimaryClean) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = TextPrimaryClean)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = SpaceBackground)
            )
        },
        containerColor = SpaceBackground
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(SpaceBackground)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (task == null) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(SurfaceSlate, RoundedCornerShape(12.dp))
                            .padding(24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "No active task selected. Please return to the Dashboard and click a task card to submit proof.",
                            color = TextSecondaryMuted,
                            textAlign = TextAlign.Center
                        )
                    }
                } else {
                    val activeTask = task!!

                    // Current Task Header Card
                    Card(
                        colors = CardDefaults.cardColors(containerColor = SurfaceSlate),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 20.dp)
                            .border(1.dp, BorderLight, RoundedCornerShape(14.dp))
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .background(IndigoElectric.copy(alpha = 0.2f), RoundedCornerShape(6.dp))
                                        .padding(horizontal = 8.dp, vertical = 4.dp)
                                ) {
                                    Text(
                                        text = activeTask.daysText.uppercase(),
                                        fontSize = 10.sp,
                                        color = IndigoElectric,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "MILESTONE REQUIREMENT",
                                    fontSize = 10.sp,
                                    color = TextSecondaryMuted,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Text(
                                text = activeTask.title,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.ExtraBold,
                                color = TextPrimaryClean,
                                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                            )

                            Text(
                                text = activeTask.description,
                                fontSize = 13.sp,
                                color = TextSecondaryMuted,
                                lineHeight = 18.sp
                            )

                            Divider(color = BorderLight, modifier = Modifier.padding(vertical = 12.dp))

                            // Crucial instructions about proof
                            Row(verticalAlignment = Alignment.Top) {
                                Icon(
                                    imageVector = Icons.Default.Info,
                                    contentDescription = null,
                                    tint = AmberAesthetic,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(
                                        text = "REQUIRED VERIFICATION EVIDENCE:",
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = AmberAesthetic
                                    )
                                    Text(
                                        text = activeTask.proofRequired,
                                        fontSize = 12.sp,
                                        color = TextPrimaryClean,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                        }
                    }

                    // Submission Form Elements
                    Text(
                        text = "CHOOSE PROOF EVIDENCE TYPE",
                        fontSize = 11.sp,
                        color = TextSecondaryMuted,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        EvidenceTypeButton(
                            label = "Public URL Link",
                            icon = Icons.Default.Link,
                            isSelected = evidenceType == "URL",
                            onSelect = { viewModel.submittedEvidenceType.value = "URL" },
                            modifier = Modifier.weight(1f)
                        )
                        EvidenceTypeButton(
                            label = "Text/Portfolio",
                            icon = Icons.Default.Description,
                            isSelected = evidenceType == "Text portfolio",
                            onSelect = { viewModel.submittedEvidenceType.value = "Text portfolio" },
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Text(
                        text = if (evidenceType == "URL") "VERIFIED LINK ADDRESS" else "NARRATE SUBMISSION EVIDENCE",
                        fontSize = 11.sp,
                        color = TextSecondaryMuted,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = evidenceText,
                        onValueChange = { viewModel.submittedEvidenceText.value = it },
                        placeholder = {
                            if (evidenceType == "URL") {
                                Text("e.g., https://github.com/myusername/project-repo")
                            } else {
                                Text("Write a thorough overview describing what you accomplished, step-by-step outcomes, and resources built or links generated...")
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(if (evidenceType == "URL") 72.dp else 180.dp)
                            .padding(vertical = 8.dp)
                            .testTag("proof_input_field"),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = TextPrimaryClean,
                            unfocusedTextColor = TextPrimaryClean,
                            focusedContainerColor = SurfaceSlate,
                            unfocusedContainerColor = SurfaceSlate,
                            focusedBorderColor = IndigoElectric,
                            unfocusedBorderColor = BorderLight
                        ),
                        shape = RoundedCornerShape(10.dp),
                        singleLine = evidenceType == "URL"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = { viewModel.submitProof {} },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                            .testTag("trigger_submit_proof_button"),
                        colors = ButtonDefaults.buttonColors(containerColor = IndigoElectric),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("REQUEST AI PROOF VERIFICATION", fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(Icons.Default.Send, contentDescription = null, modifier = Modifier.size(16.dp))
                        }
                    }

                    // AI grading result presentation block
                    feedback?.let { feedbackText ->
                        Spacer(modifier = Modifier.height(24.dp))

                        val approvalColor = if (activeTask.approvalStatus == "APPROVED") EmeraldSleek else CoralVibrant
                        val bgTint = if (activeTask.approvalStatus == "APPROVED") Color(0x2210B981) else Color(0x22F43F5E)

                        Card(
                            colors = CardDefaults.cardColors(containerColor = bgTint.compositeOver(SurfaceSlate)),
                            shape = RoundedCornerShape(14.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(1.dp, approvalColor, RoundedCornerShape(14.dp))
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = if (activeTask.approvalStatus == "APPROVED") Icons.Default.CheckCircle else Icons.Default.Cancel,
                                        contentDescription = null,
                                        tint = approvalColor,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = if (activeTask.approvalStatus == "APPROVED") "PROOF COMPLIANT & APPROVED!" else "SUBMISSION DECLINED / NEEDS FIX",
                                        fontWeight = FontWeight.ExtraBold,
                                        fontSize = 14.sp,
                                        color = approvalColor
                                    )
                                }

                                if (activeTask.approvalStatus == "APPROVED" && activeTask.incomeGenerated > 0.0) {
                                    Spacer(modifier = Modifier.height(12.dp))
                                    Text(
                                        text = "FIRST ONLINE REVENUE UNLOCKED: +$${String.format("%.2f", activeTask.incomeGenerated)}",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.ExtraBold,
                                        color = EmeraldSleek
                                    )
                                }

                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "AI Mentor feedback review:",
                                    fontSize = 10.sp,
                                    color = TextSecondaryMuted,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = feedbackText,
                                    fontSize = 13.sp,
                                    color = TextPrimaryClean,
                                    lineHeight = 18.sp,
                                    modifier = Modifier.padding(top = 2.dp)
                                )

                                if (activeTask.approvalStatus == "APPROVED") {
                                    Spacer(modifier = Modifier.height(12.dp))
                                    Text(
                                        text = "✨ PILOT PERFORMANCE BOOSTS APPLIED TO DASHBOARD",
                                        fontSize = 9.sp,
                                        color = AmberAesthetic,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // High aesthetic overlay loading during AI validation
            if (isVerifying) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xE60A0C10)),
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
                            text = "AI VERIFIER RUNNING",
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
    }
}

@Composable
fun EvidenceTypeButton(
    label: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    isSelected: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier
) {
    val bgColor = if (isSelected) IndigoElectric.copy(alpha = 0.15f) else SurfaceSlate
    val borderCol = if (isSelected) IndigoElectric else BorderLight

    Row(
        modifier = modifier
            .background(bgColor, RoundedCornerShape(8.dp))
            .border(1.dp, borderCol, RoundedCornerShape(8.dp))
            .clickable { onSelect() }
            .padding(12.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = if (isSelected) IndigoElectric else TextSecondaryMuted, modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label, color = if (isSelected) TextPrimaryClean else TextSecondaryMuted, fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}

// Extension to simulate color overlay composite in Compose without Android dependency
private fun Color.compositeOver(background: Color): Color {
    val a = this.alpha
    val r = this.red * a + background.red * (1f - a)
    val g = this.green * a + background.green * (1f - a)
    val b = this.blue * a + background.blue * (1f - a)
    return Color(red = r, green = g, blue = b, alpha = 1f)
}
