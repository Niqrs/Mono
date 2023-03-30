package com.niqr.auth.ui.screens.authentication.model

import android.content.Intent

internal sealed class AuthenticationEvent {
    data class LaunchAuth(val intent: Intent): AuthenticationEvent()
    object OnAuthSuccess: AuthenticationEvent()
}