package com.niqr.tasks.domain

import com.niqr.tasks.domain.model.Day
import com.niqr.tasks.domain.model.Task
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface TasksRepository {
    val dayFlow: Flow<Day>
    fun updateDay(date: LocalDate)
    fun addTask(date: LocalDate, task: String)
    fun updateTaskValue(task: Task)
    fun updateTask(prevTask: Task, newTask: Task)
    fun deleteTask(task: String)
    suspend fun signOut(): Boolean
}