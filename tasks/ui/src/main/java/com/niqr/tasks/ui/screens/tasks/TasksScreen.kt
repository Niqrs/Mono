package com.niqr.tasks.ui.screens.tasks

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.niqr.tasks.domain.model.Task
import com.niqr.tasks.ui.screens.tasks.components.*
import com.niqr.tasks.ui.screens.tasks.model.TasksAction
import com.niqr.tasks.ui.screens.tasks.model.TasksEvent
import com.niqr.tasks.ui.screens.tasks.model.TasksUiState
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TasksScreen(
    uiState: TasksUiState,
    uiEvent: Flow<TasksEvent>,
    onAction: (TasksAction) -> Unit,
    onSignOut: () -> Unit,
    onSettingsClick: () -> Unit
) {
    TasksUiEventHandler(
        uiEvent = uiEvent,
        onSignOut = onSignOut
    )

    TasksDialog(
        task = uiState.editTask,
        onDismiss = { onAction(TasksAction.OnDismissEditTask) },
        onSaveClick = { onAction(TasksAction.OnUpdateTaskClick(uiState.editTask ?: Task(), it)) },
        onDeleteClick = { onAction(TasksAction.OnDeleteTaskClick(it)) }
    )

    SettingsMenu(
        expanded = uiState.isSettingsMenuVisible,
        onDismissRequest = { onAction(TasksAction.OnDismissSettingsMenu) },
        onSignOutClick = { onAction(TasksAction.OnSighOutClick) }
    )

    Scaffold(
        topBar = {
            TasksTopAppBar(
                day = uiState.day,
                onSettingsClick = { onAction(TasksAction.OnSettingsClick) }
            )
        },
        bottomBar = {
            TasksBottomAppBar(
                onLeftClick = { onAction(TasksAction.OnPreviousDayClick) },
                onRightClick = { onAction(TasksAction.OnNextDayClick) },
                onCreateTaskClick = { onAction(TasksAction.OnCreateTaskClick) }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(22.dp))
            }

            items(uiState.tasks) {
                TasksItem(
                    task = it,
                    onClick = { task -> onAction(TasksAction.OnUpdateTaskValueClick(task)) },
                    onLongClick = { task -> onAction(TasksAction.OnEditTaskClick(task)) }
                )
            }

            item {
                Spacer(modifier = Modifier.height(36.dp))
            }
        }
    }
}