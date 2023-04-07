package com.niqr.settings.domain

interface SettingsRepository {
    suspend fun sighOut(): Boolean
}