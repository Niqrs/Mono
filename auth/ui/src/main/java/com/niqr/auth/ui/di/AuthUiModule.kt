package com.niqr.auth.ui.di

import com.niqr.auth.ui.handlers.AuthenticationHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal object AuthUiModule {

    @Provides
    @ViewModelScoped
    fun provideAuthenticationHandler() = AuthenticationHandler()
}