package com.niqr.auth.ui.screens.authentication.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.niqr.auth.ui.R
import com.niqr.core.ui.theme.MonoTheme

@Composable
internal fun SignInWithGoogleButton(
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = onClick,
        border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary),
        contentPadding = PaddingValues(
            horizontal = 12.dp,
            vertical = 10.dp
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(28.dp),
                painter = painterResource(R.drawable.ic_google_logo_24dp),
                contentDescription = null
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.sign_in_with_google),
                    fontSize = 17.sp,
                    fontWeight = FontWeight(490)
                )
            }
        }
    }
}

@Preview
@Composable
private fun SignInWithGoogleButtonPreview() {
    MonoTheme {
        Box(
            modifier = Modifier
                .width(280.dp)
                .height(100.dp),
            contentAlignment = Alignment.Center
        ) {
            SignInWithGoogleButton(
                onClick = {}
            )
        }
    }
}