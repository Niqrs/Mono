package com.niqr.auth.ui.handlers

import androidx.activity.result.ActivityResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await

internal class AuthenticationHandler {
   suspend operator fun invoke(result: ActivityResult): AuthCredential? = try {
      val data = result.data
      val account: GoogleSignInAccount = GoogleSignIn.getSignedInAccountFromIntent(data).await()
      val credential = GoogleAuthProvider.getCredential(account.idToken, null)
      credential
   } catch (e: Exception) {
      null
   }
}