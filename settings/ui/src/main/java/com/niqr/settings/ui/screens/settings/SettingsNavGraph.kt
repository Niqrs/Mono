package com.niqr.settings.ui.screens.settings

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val SettingsScreenRoutePattern = "settings"

internal fun NavController.navigateToSettings() {
    this.navigate(SettingsScreenRoutePattern)
}

internal fun NavGraphBuilder.settingsScreen(
    onNavigateUp: () -> Unit
) {
    composable(SettingsScreenRoutePattern) {
        SettingsScreen(onNavigateUp)
    }
}