package com.niqr.tasks.ui.screens.tasks.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.niqr.core.ui.theme.Black
import com.niqr.core.ui.theme.White
import com.niqr.core.ui.theme.day

@Composable
internal fun TasksTopAppBar(
    day: String,
    onSettingsClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(Black)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = day,
            modifier = Modifier
                .align(Alignment.Center),
            color = White,
            style = MaterialTheme.typography.day
        )

        IconButton(
            onClick = onSettingsClick,
            modifier = Modifier
                .align(Alignment.CenterEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = null,
                tint = White
            )
        }
    }
}