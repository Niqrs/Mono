package com.niqr.auth.ui.screens.authentication.model

import androidx.activity.result.ActivityResult

internal sealed class AuthenticationAction {
    object OnAuthClick: AuthenticationAction()
    data class OnAuthResult(val result: ActivityResult): AuthenticationAction()
}