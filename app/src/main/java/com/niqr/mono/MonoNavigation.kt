package com.niqr.mono

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.niqr.auth.ui.AuthGraphRoutePattern
import com.niqr.auth.ui.authGraph
import com.niqr.auth.ui.navigateToAuthGraph
import com.niqr.settings.ui.navigateToSettingsGraph
import com.niqr.settings.ui.settingsGraph
import com.niqr.tasks.ui.TasksGraphRoutePattern
import com.niqr.tasks.ui.navigateToTasksGraph
import com.niqr.tasks.ui.tasksGraph

@Composable
fun MonoNavigation() {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NavHost(
            navController = navController,
            startDestination = startDestination(authenticated = Firebase.auth.currentUser != null)
        ) {
            authGraph(
                onSuccessAuth = navController::navigateToTasksGraph
            )
            tasksGraph(
                onSignOut = navController::navigateToAuthGraph,
                onNavigateToSettings = navController::navigateToSettingsGraph
            )
            settingsGraph(
                navController = navController
            )
        }
    }
}

private fun startDestination(
    authenticated: Boolean
) = if (authenticated) TasksGraphRoutePattern
else AuthGraphRoutePattern