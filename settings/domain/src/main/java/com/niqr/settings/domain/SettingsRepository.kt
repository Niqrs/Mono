package com.niqr.settings.domain

interface SettingsRepository {
    suspend fun signOut(): Boolean
}