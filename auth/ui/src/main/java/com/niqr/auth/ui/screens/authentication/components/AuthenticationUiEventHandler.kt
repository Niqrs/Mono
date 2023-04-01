package com.niqr.auth.ui.screens.authentication.components

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.niqr.auth.ui.screens.authentication.model.AuthenticationAction
import com.niqr.auth.ui.screens.authentication.model.AuthenticationEvent
import kotlinx.coroutines.flow.Flow

@Composable
internal fun AuthenticationUiEventHandler(
    uiEvent: Flow<AuthenticationEvent>,
    onAction: (AuthenticationAction) -> Unit,
    onSuccess: () -> Unit
    ) {
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        onAction(AuthenticationAction.OnAuthResult(it))
    }

    LaunchedEffect(Unit) {
        uiEvent.collect {
            when(it) {
                is AuthenticationEvent.LaunchAuth -> {
                    launcher.launch(it.intent)
                }
                AuthenticationEvent.OnAuthSuccess -> onSuccess()
            }
        }
    }
}