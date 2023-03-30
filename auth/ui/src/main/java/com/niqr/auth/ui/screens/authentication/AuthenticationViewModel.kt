package com.niqr.auth.ui.screens.authentication

import androidx.activity.result.ActivityResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.niqr.auth.domain.AuthRepository
import com.niqr.auth.ui.handlers.AuthenticationHandler
import com.niqr.auth.ui.screens.authentication.model.AuthenticationAction
import com.niqr.auth.ui.screens.authentication.model.AuthenticationEvent
import com.niqr.auth.ui.screens.authentication.model.AuthenticationUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class AuthenticationViewModel @Inject constructor(
    private val authRepo: AuthRepository,
    private val googleAuthClient: GoogleSignInClient,
    private val handler: AuthenticationHandler
) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthenticationUiState())
    val uiState = _uiState.asStateFlow()

    private val _uiEvent = Channel<AuthenticationEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAction(action: AuthenticationAction) {
        when(action) {
            AuthenticationAction.OnAuthClick -> onAuthClick()
            is AuthenticationAction.OnAuthResult -> onAuthSuccess(action.result)
        }
    }

    private fun onAuthClick() {
        viewModelScope.launch {
            _uiEvent.send(
                AuthenticationEvent.LaunchAuth(
                    intent = googleAuthClient.signInIntent
                )
            )
        }
    }

    private fun onAuthSuccess(result: ActivityResult) {
        viewModelScope.launch {
            val credential = handler(result)
            if (credential != null && authRepo.authWithGoogle(credential))
                _uiEvent.send(AuthenticationEvent.OnAuthSuccess)

            _uiState.update {
                it.copy(
                    isLoading = false,
//                  isError = credential == null
                )
            }
        }
    }
}