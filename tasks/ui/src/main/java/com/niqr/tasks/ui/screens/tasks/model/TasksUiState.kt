package com.niqr.tasks.ui.screens.tasks.model

import com.niqr.tasks.domain.model.Task

data class TasksUiState(
    val day: String = "",
    val tasks: List<Task> = emptyList(),
    val editTask: Task? = null,
    val isSettingsMenuVisible: Boolean = false
)
