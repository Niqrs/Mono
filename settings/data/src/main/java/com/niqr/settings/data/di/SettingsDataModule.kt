package com.niqr.settings.data.di

import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.niqr.settings.data.SettingsRepositoryImpl
import com.niqr.settings.domain.SettingsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SettingsDataModule {

    @Provides
    fun provideSettingsRepository(
        googleClient: GoogleSignInClient,
        auth: FirebaseAuth
    ): SettingsRepository = SettingsRepositoryImpl(googleClient, auth)
}