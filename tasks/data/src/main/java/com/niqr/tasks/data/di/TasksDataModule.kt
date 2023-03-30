package com.niqr.tasks.data.di

import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.niqr.tasks.data.TasksRepositoryImpl
import com.niqr.tasks.domain.TasksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object TasksDataModule {

    @Provides
    fun provideTasksRepository(
        db: FirebaseFirestore,
        auth: FirebaseAuth,
        googleClient: GoogleSignInClient
    ): TasksRepository = TasksRepositoryImpl(auth, db, googleClient)
}