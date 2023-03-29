package com.niqr.auth.ui.screens.authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
internal fun AuthenticationScreen(
    onSuccess: () -> Unit
) {
    Column {
        Text("AuthenticationScreen")
        Button(onSuccess) {
            Text("SignIn")
        }
    }
}