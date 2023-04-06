package com.niqr.tasks.ui.screens.tasks.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.niqr.tasks.ui.screens.tasks.model.TasksEvent
import kotlinx.coroutines.flow.Flow

@Composable
internal fun TasksUiEventHandler(
    uiEvent: Flow<TasksEvent>,
    onSignOut: () -> Unit
) {
    LaunchedEffect(Unit) {
        uiEvent.collect {
            when(it) {
                TasksEvent.SignOut -> onSignOut()
            }
        }
    }
}