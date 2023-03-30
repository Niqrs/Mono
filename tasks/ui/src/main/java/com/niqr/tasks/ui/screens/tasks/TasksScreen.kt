package com.niqr.tasks.ui.screens.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.niqr.tasks.ui.screens.tasks.model.TasksAction
import com.niqr.tasks.ui.screens.tasks.model.TasksEvent
import com.niqr.tasks.ui.screens.tasks.model.TasksUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@Composable
internal fun TasksScreen(
    uiState: StateFlow<TasksUiState>,
    uiEvent: Flow<TasksEvent>,
    onAction: (TasksAction) -> Unit,
    onSignOut: () -> Unit,
    onSettingsClick: () -> Unit
) {
    LaunchedEffect(Unit) {
        uiEvent.collect {
            when(it) {
                TasksEvent.SignOut -> onSignOut()
            }
        }
    }

    Column {
        Text("Name: ----")
        Text("Tasks Screen!")
        Button(
            onClick = {
                onAction(TasksAction.OnSighOutClick)
            }
        ) {
            Text("Sign-Out")
        }
        Button(onSettingsClick) {
            Text("Settings")
        }
    }
}