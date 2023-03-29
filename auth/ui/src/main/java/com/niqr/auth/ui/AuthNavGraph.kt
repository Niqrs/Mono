package com.niqr.auth.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.niqr.auth.ui.screens.authentication.AuthenticationScreenRoutePattern
import com.niqr.auth.ui.screens.authentication.authenticationScreen

const val AuthGraphRoutePattern = "auth"

fun NavController.navigateToAuthGraph() {
    this.navigate(AuthGraphRoutePattern) {
        popUpTo(0)
        launchSingleTop = true
    }
}

fun NavGraphBuilder.authGraph(
    onSuccessAuth: () -> Unit
) {
    navigation(
        startDestination = AuthenticationScreenRoutePattern,
        route = AuthGraphRoutePattern
    ) {
        authenticationScreen(onSuccessAuth)
    }
}