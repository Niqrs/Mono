package com.niqr.auth.ui.screens.authentication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.niqr.auth.ui.R
import com.niqr.core.ui.theme.Black
import com.niqr.core.ui.theme.MonoTheme
import com.niqr.core.ui.theme.White

@Composable
internal fun AuthenticationHead() {
    Box(
        modifier = Modifier
            .background(Black)
            .padding(top = 18.dp, bottom = 22.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(64.dp),
            painter = painterResource(R.drawable.ic_logo_letter),
            contentDescription = null,
            tint = White
        )
    }
}

@Preview
@Composable
private fun MonoHeadPreview() {
    MonoTheme {
        Box(
            modifier = Modifier
                .background(White)
                .size(200.dp)
        ) {
            AuthenticationHead()
        }
    }
}