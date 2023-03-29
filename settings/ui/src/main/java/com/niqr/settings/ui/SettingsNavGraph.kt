package com.niqr.settings.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.niqr.settings.ui.screens.settings.SettingsScreen
import com.niqr.settings.ui.screens.settings.SettingsScreenRoutePattern
import com.niqr.settings.ui.screens.settings.settingsScreen

const val SettingsGraphRoutePattern = "settingsGraph"

fun NavController.navigateToSettingsGraph() {
    this.navigate(SettingsGraphRoutePattern)
}

fun NavGraphBuilder.settingsGraph(
    navController: NavController
) {
    navigation(
        startDestination = SettingsScreenRoutePattern,
        route = SettingsGraphRoutePattern
    ) {
        settingsScreen(
            onNavigateUp = navController::navigateUp
        )
    }
}