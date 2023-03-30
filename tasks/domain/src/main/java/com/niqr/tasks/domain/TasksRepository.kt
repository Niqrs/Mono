package com.niqr.tasks.domain

interface TasksRepository {
    suspend fun signOut(): Boolean
}