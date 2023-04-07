package com.niqr.settings.data

import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.niqr.settings.domain.SettingsRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val googleClient: GoogleSignInClient,
    private val auth: FirebaseAuth
): SettingsRepository {
    override suspend fun signOut(): Boolean {
        return try {
            googleClient.signOut().await()
            auth.signOut()
            true
        } catch (e: Exception) {
            false
        }
    }
}