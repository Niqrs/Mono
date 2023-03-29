package com.niqr.auth.domain

import com.google.firebase.auth.GoogleAuthCredential

interface AuthRepository {
    val isAuthenticated: Boolean

    suspend fun authWithGoogle(authCredential: GoogleAuthCredential): Boolean
}