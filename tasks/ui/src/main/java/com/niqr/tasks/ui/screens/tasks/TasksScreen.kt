package com.niqr.tasks.ui.screens.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TasksScreen(
    onSignOut: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Column {
        Text("Tasks Screen!")
        Button(onSignOut) {
            Text("Sign-Out")
        }
        Button(onSettingsClick) {
            Text("Settings")
        }
    }
}