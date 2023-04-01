package com.niqr.auth.ui.screens.authentication.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.niqr.core.ui.theme.hint

@Composable
fun BoxScope.AuthenticationPolicy() {
    Text(
        text = buildAnnotatedString { //TODO: string resources
            append("By signing up, you agree to out ")

            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("Terms of Service")
            }

            append(" and acknowledge that out ")

            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append("Privacy Policy")
            }

            append(" applies to you.")
        },
        modifier = Modifier
            .padding(bottom = 36.dp)
            .align(Alignment.BottomCenter),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.hint
    )
}