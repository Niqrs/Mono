package com.niqr.auth.ui.screens.authentication

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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

    Column {
        Text("AuthenticationScreen")
        Button(
            onClick = {
                Log.d("TAG", "11232321")
                onAction(AuthenticationAction.OnAuthClick)
            }
        ) {
            Text("SignIn")
        }
    }
}