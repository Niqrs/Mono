package com.niqr.auth.domain

import com.google.firebase.auth.AuthCredential

interface AuthRepository {
    val isAuthenticated: Boolean

    suspend fun authWithGoogle(authCredential: AuthCredential): Boolean
}