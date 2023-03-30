package com.niqr.tasks.ui.screens.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.niqr.tasks.domain.TasksRepository
import com.niqr.tasks.ui.screens.tasks.model.TasksAction
import com.niqr.tasks.ui.screens.tasks.model.TasksEvent
import com.niqr.tasks.ui.screens.tasks.model.TasksUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class TasksViewModel @Inject constructor(
    val repo: TasksRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(TasksUiState())
    val uiState = _uiState.asStateFlow()

    private val _uiEvent = Channel<TasksEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onAction(action: TasksAction) {
        when(action) {
            TasksAction.OnSighOutClick -> onSighOutClick()
        }
    }

    private fun onSighOutClick() {
        viewModelScope.launch {
            val isSuccess = repo.signOut()
            if (isSuccess)
                _uiEvent.send(TasksEvent.SignOut)

            _uiState.update {
                it.copy(
                    // itLoading = false
                    // isError = !isSuccess
                )
            }
        }
    }
}