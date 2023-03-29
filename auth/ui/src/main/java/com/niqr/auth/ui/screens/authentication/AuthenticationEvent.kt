package com.niqr.auth.ui.screens.authentication

internal sealed class AuthenticationEvent {
    object OnAuthResult: AuthenticationEvent()
}