package com.niqr.auth.ui.screens.authentication

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal const val AuthenticationScreenRoutePattern = "authentication"

internal fun NavController.navigateToAuthentication() {
    this.navigate((AuthenticationScreenRoutePattern)) {
        popUpTo(0)
        launchSingleTop = true
    }
}

internal fun NavGraphBuilder.authenticationScreen(
    onSuccessAuth: () -> Unit
) {
    composable(AuthenticationScreenRoutePattern) {
//        val viewModel: AuthenticationViewModel = hiltViewModel()
        AuthenticationScreen(
//            uiState = viewModel.uiState,
//            uiEvent = viewModel.uiEvent,
//            onAction = viewModel::onAction,
            onSuccess = onSuccessAuth
        )
    }
}