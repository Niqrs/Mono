package com.niqr.auth.ui.screens.authentication

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.niqr.auth.ui.screens.authentication.components.*
import com.niqr.auth.ui.screens.authentication.model.AuthenticationAction
import com.niqr.auth.ui.screens.authentication.model.AuthenticationEvent
import com.niqr.auth.ui.screens.authentication.model.AuthenticationUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Composable
internal fun AuthenticationScreen(
    uiState: StateFlow<AuthenticationUiState>,
    uiEvent: Flow<AuthenticationEvent>,
    onAction: (AuthenticationAction) -> Unit,
    onSuccess: () -> Unit
) {
    AuthenticationUiEventHandler(
        uiEvent = uiEvent,
        onAction = onAction,
        onSuccess = onSuccess
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        AuthenticationHead()

        Box(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AuthenticationHeader()

                Spacer(Modifier.height(24.dp))

                SignInWithGoogleButton(
                    onClick = {
                        onAction(AuthenticationAction.OnAuthClick)
                    }
                )
            }

            AuthenticationPolicy()
        }
    }
}