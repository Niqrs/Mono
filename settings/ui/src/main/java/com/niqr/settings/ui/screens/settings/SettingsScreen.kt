package com.niqr.settings.ui.screens.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
internal fun SettingsScreen(
    onNavigateUp: () -> Unit
) {
    Column {
        Text("Settings Screen!")
        Button(onNavigateUp) {
            Text("Go Back")
        }
    }
}