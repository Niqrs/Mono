package com.niqr.tasks.ui.screens.tasks

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niqr.settings.domain.SettingsRepository
import com.niqr.tasks.domain.TasksRepository
import com.niqr.tasks.domain.model.Task
import com.niqr.tasks.ui.screens.tasks.model.TasksAction
import com.niqr.tasks.ui.screens.tasks.model.TasksEvent
import com.niqr.tasks.ui.screens.tasks.model.TasksUiState
import com.niqr.tasks.ui.screens.tasks.utils.toStringDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
internal class TasksViewModel @Inject constructor(
    private val repo: TasksRepository,
    private val settings: SettingsRepository
): ViewModel() {
    private var day: LocalDate = LocalDate.now()

    var uiState by mutableStateOf(TasksUiState())
        private set

    init {
        viewModelScope.launch {
            repo.updateDay(day)
            repo.dayFlow.collect {
                day = it.date
                uiState = uiState.copy(
                    day = it.date.toStringDate(),
                    tasks = it.tasks.map { Task(it.key, it.value) }
                )
            }
        }
    }

    private val _uiEvent = Channel<TasksEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAction(action: TasksAction) {
        when(action) {
            TasksAction.OnSighOutClick -> onSighOutClick()
            TasksAction.OnNextDayClick -> onNextDayClick()
            TasksAction.OnPreviousDayClick -> onPreviousDayClick()
            TasksAction.OnCreateTaskClick -> onCreateTaskClick()
            is TasksAction.OnAddTaskClick -> onAddTaskClick(action.task)
            is TasksAction.OnUpdateTaskValueClick -> onUpdateTaskValueClick(action.task)
            is TasksAction.OnUpdateTaskClick -> onUpdateTaskClick(action.prevTask, action.newTask)
            is TasksAction.OnEditTaskClick -> onEditTaskClick(action.task)
            TasksAction.OnDismissEditTask -> onDismissEditTask()
            TasksAction.OnSettingsClick -> onSettingsClick()
            TasksAction.OnDismissSettingsMenu -> onDismissSettingsMenu()
        }
    }

    private fun onDismissSettingsMenu() {
        uiState = uiState.copy(
            isSettingsMenuVisible = false
        )
    }

    private fun onSettingsClick() {
        uiState = uiState.copy(
            isSettingsMenuVisible = true
        )
    }

    private fun onSighOutClick() {
        viewModelScope.launch {
            val isSuccess = settings.signOut()
            if (isSuccess)
                _uiEvent.send(TasksEvent.SignOut)

            uiState = uiState.copy(
                isSettingsMenuVisible = false
            )
        }
    }

    private fun onNextDayClick() {
        repo.updateDay(day.plusDays(1))
    }

    private fun onPreviousDayClick() {
        repo.updateDay(day.minusDays(1))
    }

    private fun onCreateTaskClick() {
        uiState = uiState.copy(
            editTask = Task()
        )
    }

    private fun onAddTaskClick(task: String) {
        repo.addTask(day, task)
    }

    private fun onUpdateTaskValueClick(task: Task) {
        repo.updateTaskValue(task)
    }

    private fun onUpdateTaskClick(prevTask: Task, newTask: Task) {
        if (newTask.name.isBlank())
            return

        uiState = uiState.copy(editTask = null)
        if (prevTask.name.isBlank())
            repo.addTask(day, newTask.name)
        else
            repo.updateTask(prevTask, newTask)
    }

    private fun onEditTaskClick(task: Task) {
        uiState = uiState.copy(
            editTask = task
        )
    }

    private fun onDismissEditTask() {
        uiState = uiState.copy(
            editTask = null
        )
    }
}