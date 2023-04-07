package com.niqr.tasks.ui.screens.tasks.model

import com.niqr.tasks.domain.model.Task

internal sealed class TasksAction {
    object OnSighOutClick: TasksAction()
    object OnPreviousDayClick: TasksAction()
    object OnNextDayClick: TasksAction()
    object OnCreateTaskClick: TasksAction()
    data class OnAddTaskClick(val task: String): TasksAction()
    data class OnUpdateTaskValueClick(val task: Task): TasksAction()
    data class OnUpdateTaskClick(val prevTask: Task, val newTask: Task): TasksAction()
    data class OnEditTaskClick(val task: Task): TasksAction()
    object OnDismissEditTask: TasksAction()
    object OnSettingsClick: TasksAction()
    object OnDismissSettingsMenu: TasksAction()
}