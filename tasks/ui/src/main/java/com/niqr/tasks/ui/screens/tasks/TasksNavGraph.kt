package com.niqr.tasks.ui.screens.tasks

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val TasksScreenRoutePattern = "tasks"

internal fun NavController.navigateToTasks() {
    this.navigate(TasksScreenRoutePattern)
}

internal fun NavGraphBuilder.tasksScreen(
    onSignOut: () -> Unit,
    onSettingsClick: () -> Unit
) {
    composable(TasksScreenRoutePattern) {
//        val viewModel: TasksViewModel = hiltViewModel()
        TasksScreen(
            onSignOut = onSignOut,
            onSettingsClick = onSettingsClick
        )
    }
}