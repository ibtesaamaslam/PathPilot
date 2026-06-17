package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val PathPilotColorScheme = darkColorScheme(
    primary = IndigoElectric,
    onPrimary = TextPrimaryClean,
    secondary = SurfaceSlate,
    onSecondary = TextPrimaryClean,
    tertiary = EmeraldSleek,
    onTertiary = SpaceBackground,
    background = SpaceBackground,
    onBackground = TextPrimaryClean,
    surface = SurfaceSlate,
    onSurface = TextPrimaryClean,
    surfaceVariant = SurfaceCardOff,
    onSurfaceVariant = TextSecondaryMuted
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = true, // Force gorgeous dark mode for consistent Linear/Stripe/Duolingo premium feel
    dynamicColor: Boolean = false, // Use our handcrafted design-system colors explicitly
    content: @Composable () -> Unit,
) {
    val colorScheme = PathPilotColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
