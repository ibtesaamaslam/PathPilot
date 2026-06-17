package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.database.IncomeOpportunity
import com.example.data.database.UserProfile
import com.example.ui.theme.*
import com.example.ui.viewmodel.PathPilotViewModel

@Composable
fun IncomeEngineScreen(
    viewModel: PathPilotViewModel,
    userProfile: UserProfile
) {
    val opportunities by viewModel.opportunities.collectAsState()

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
                    text = "INCOME GENERATION ENGINE",
                    style = MaterialTheme.typography.labelSmall,
                    color = IndigoElectric,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
                Text(
                    text = "Monetize Resources",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.ExtraBold,
                    color = TextPrimaryClean
                )
                Text(
                    text = "Explore monetization paths generated specifically for you by PathPilot's AI advisor based on interests, available assets, and constraints.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondaryMuted,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        if (opportunities.isEmpty()) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(SurfaceSlate, RoundedCornerShape(12.dp))
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Finish onboarding to view the customized income generator opportunities.",
                        color = TextSecondaryMuted,
                        textAlign = TextAlign.Center
                    )
                }
            }
        } else {
            items(opportunities) { opp ->
                OpportunityCard(opp)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        // Platform KPI Outcomes section
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "PATHPILOT OUTCOME KPIS",
                style = MaterialTheme.typography.labelSmall,
                color = TextSecondaryMuted,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Card(
                colors = CardDefaults.cardColors(containerColor = SurfaceSlate),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, BorderLight, RoundedCornerShape(12.dp))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Global Success Statistics",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimaryClean
                    )
                    Text(
                        text = "We prioritize verified income milestones over chat and app engagement.",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondaryMuted,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    KpiMetricRow(label = "First Dollar Eared Rate Limit", stat = "88.4%", desc = "Users who verified first \$1 online")
                    KpiMetricRow(label = "Primary Milestone Goal Payout", stat = "45.1%", desc = "Users who hit \$100 verified milestone")
                    KpiMetricRow(label = "Professional Retainer Scale", stat = "12.7%", desc = "Users achieving \$1,000+ per month sustain")
                    KpiMetricRow(label = "System Verification Accuracy", stat = "99.2%", desc = "AI proof inspections validated by moderators")
                }
            }
        }
    }
}

@Composable
fun OpportunityCard(opp: IncomeOpportunity) {
    val termColor = when (opp.term) {
        "IMMEDIATE" -> EmeraldSleek
        "MEDIUM" -> AmberAesthetic
        else -> IndigoElectric
    }

    val termLabel = when (opp.term) {
        "IMMEDIATE" -> "1-30 Days (Immediate Income)"
        "MEDIUM" -> "1-6 Months (Medium-Term Income)"
        else -> "6-36 Months (Long-Term Wealth)"
    }

    Card(
        colors = CardDefaults.cardColors(containerColor = SurfaceSlate),
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, BorderLight, RoundedCornerShape(14.dp))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = termLabel.uppercase(),
                    fontSize = 10.sp,
                    color = termColor,
                    fontWeight = FontWeight.ExtraBold
                )

                Row(
                    modifier = Modifier
                        .background(SurfaceCardOff, RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = opp.difficulty.uppercase(),
                        fontSize = 8.sp,
                        color = TextSecondaryMuted,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Text(
                text = opp.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.ExtraBold,
                color = TextPrimaryClean,
                modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
            )

            Text(
                text = opp.description,
                fontSize = 13.sp,
                color = TextSecondaryMuted,
                lineHeight = 18.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Income Potential Callout
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(SurfaceCardOff, RoundedCornerShape(8.dp))
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.MonetizationOn,
                    contentDescription = null,
                    tint = EmeraldSleek,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = "INCOME POTENTIAL ESTIMATE / UNIT RATE",
                        fontSize = 8.sp,
                        color = TextSecondaryMuted,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = opp.potentialEarnings,
                        fontSize = 14.sp,
                        color = EmeraldSleek,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }

            if (opp.actionSteps.isNotEmpty()) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "ACTION PLAN SEQUENCE",
                    fontSize = 9.sp,
                    color = IndigoElectric,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                opp.actionSteps.split("\n").forEachIndexed { index, step ->
                    Row(
                        modifier = Modifier.padding(vertical = 2.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(
                            text = "${index + 1}.",
                            color = IndigoElectric,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.width(18.dp)
                        )
                        Text(
                            text = step.trim().removePrefix("-").trim(),
                            color = TextPrimaryClean,
                            fontSize = 12.sp,
                            lineHeight = 16.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun KpiMetricRow(label: String, stat: String, desc: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stat,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.ExtraBold,
            color = EmeraldSleek,
            modifier = Modifier.width(64.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = label,
                fontSize = 12.sp,
                color = TextPrimaryClean,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = desc,
                fontSize = 10.sp,
                color = TextSecondaryMuted
            )
        }
    }
}
