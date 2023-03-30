package com.niqr.tasks.data

import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.niqr.tasks.domain.TasksRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class TasksRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth, //TODO: auth should not be here
    private val db: FirebaseFirestore,
    private val googleClient: GoogleSignInClient
): TasksRepository {
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