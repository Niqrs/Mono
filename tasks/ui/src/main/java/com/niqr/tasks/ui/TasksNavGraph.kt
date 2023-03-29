package com.niqr.tasks.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.niqr.tasks.ui.screens.tasks.TasksScreenRoutePattern
import com.niqr.tasks.ui.screens.tasks.tasksScreen

const val TasksGraphRoutePattern = "tasksGraph"

fun NavController.navigateToTasksGraph() {
    this.navigate(TasksGraphRoutePattern) {
        //Here should be something
    }
}

fun NavGraphBuilder.tasksGraph(
    onSignOut: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    navigation(
        startDestination = TasksScreenRoutePattern,
        route = TasksGraphRoutePattern
    ) {
        tasksScreen(
            onSignOut = onSignOut,
            onSettingsClick = onNavigateToSettings
        )
    }
}