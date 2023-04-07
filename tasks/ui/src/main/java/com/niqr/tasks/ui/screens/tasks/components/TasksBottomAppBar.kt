package com.niqr.tasks.ui.screens.tasks.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.niqr.core.ui.theme.Black
import com.niqr.core.ui.theme.Black1
import com.niqr.core.ui.theme.White

@Composable
internal fun TasksBottomAppBar(
    onLeftClick: () -> Unit,
    onRightClick: () -> Unit,
    onCreateTaskClick: () -> Unit
) {
    BottomAppBar(
        containerColor = Black,
        tonalElevation = 0.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(
                onClick = onLeftClick
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                )
            }

            SmallFloatingActionButton(
                onClick = onCreateTaskClick,
                containerColor = Black1
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = White
                )
            }

            IconButton(
                onClick = onRightClick
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                )
            }
        }
    }
}