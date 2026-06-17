package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.filled.Update
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.screens.*
import com.example.ui.theme.*
import com.example.ui.viewmodel.PathPilotViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    val viewModel: PathPilotViewModel = viewModel()
    val userProfileState by viewModel.userProfile.collectAsState()

    val userProfile = userProfileState

    if (userProfile == null) {
        // Aesthetic black screen until database completes loading profile
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(SpaceBackground),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = IndigoElectric)
        }
    } else if (!userProfile.onboardingCompleted) {
        OnboardingScreen(
            viewModel = viewModel,
            onCompleted = {}
        )
    } else {
        var currentTab by remember { mutableStateOf("dashboard") }

        Scaffold(
            bottomBar = {
                if (currentTab != "submit_proof") {
                    NavigationBar(
                        containerColor = SurfaceSlate,
                        tonalElevation = 8.dp,
                        modifier = Modifier.testTag("app_bottom_nav_bar")
                    ) {
                        NavigationBarItem(
                            selected = currentTab == "dashboard",
                            onClick = { currentTab = "dashboard" },
                            icon = { Icon(Icons.Default.Dashboard, contentDescription = "Dashboard") },
                            label = { Text("Dashboard") },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = TextPrimaryClean,
                                selectedTextColor = TextPrimaryClean,
                                indicatorColor = IndigoElectric,
                                unselectedIconColor = TextSecondaryMuted,
                                unselectedTextColor = TextSecondaryMuted
                            )
                        )
                        NavigationBarItem(
                            selected = currentTab == "income",
                            onClick = { currentTab = "income" },
                            icon = { Icon(Icons.Default.TrendingUp, contentDescription = "Income Engine") },
                            label = { Text("Income") },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = TextPrimaryClean,
                                selectedTextColor = TextPrimaryClean,
                                indicatorColor = IndigoElectric,
                                unselectedIconColor = TextSecondaryMuted,
                                unselectedTextColor = TextSecondaryMuted
                            )
                        )
                        NavigationBarItem(
                            selected = currentTab == "reviews",
                            onClick = { currentTab = "reviews" },
                            icon = { Icon(Icons.Default.Update, contentDescription = "Weekly Review") },
                            label = { Text("Review") },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = TextPrimaryClean,
                                selectedTextColor = TextPrimaryClean,
                                indicatorColor = IndigoElectric,
                                unselectedIconColor = TextSecondaryMuted,
                                unselectedTextColor = TextSecondaryMuted
                            )
                        )
                    }
                }
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                when (currentTab) {
                    "dashboard" -> DashboardScreen(
                        viewModel = viewModel,
                        userProfile = userProfile,
                        onNavigateToSubmit = {
                            currentTab = "submit_proof"
                        }
                    )
                    "income" -> IncomeEngineScreen(
                        viewModel = viewModel,
                        userProfile = userProfile
                    )
                    "reviews" -> WeeklyReviewScreen(
                        viewModel = viewModel
                    )
                    "submit_proof" -> ProofSubmissionScreen(
                        viewModel = viewModel,
                        onBack = {
                            currentTab = "dashboard"
                        }
                    )
                }
            }
        }
    }
}
