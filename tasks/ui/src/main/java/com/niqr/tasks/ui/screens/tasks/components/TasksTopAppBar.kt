package com.niqr.tasks.ui.screens.tasks.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.niqr.core.ui.theme.Black
import com.niqr.core.ui.theme.White
import com.niqr.core.ui.theme.day

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TasksTopAppBar(
    day: String,
    onSettingsClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = day,
                color = White,
                style = MaterialTheme.typography.day
            )
        },
        actions = {
            IconButton(
                modifier = Modifier
                    .padding(end = 8.dp),
                onClick = onSettingsClick
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Black,
            titleContentColor = White,
            actionIconContentColor = White
        )
    )
}