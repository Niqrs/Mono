package com.niqr.auth.ui.screens.authentication.components

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.niqr.auth.ui.R

@Composable
fun AuthenticationHeader() {
    Icon(
        painter = painterResource(R.drawable.ic_authentication_header),
        contentDescription = null
    )
}