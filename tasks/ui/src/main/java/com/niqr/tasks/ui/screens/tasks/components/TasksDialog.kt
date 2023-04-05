package com.niqr.tasks.ui.screens.tasks.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.niqr.core.ui.components.AnimatedCounter
import com.niqr.core.ui.theme.task
import com.niqr.tasks.domain.model.Task
import com.niqr.tasks.ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksDialog(
    task: Task?,
    onDismiss: () -> Unit,
    onSaveClick: () -> Unit
) {
    var editTask by remember { mutableStateOf(task?.name ?: "") }
    LaunchedEffect(task) {
        editTask = task?.name ?: ""
    }

    if (task != null) {
        AlertDialog(
            onDismissRequest = onDismiss,
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.large
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AnimatedCounter(count = 50 - editTask.length)
                    Spacer(Modifier.height(8.dp))

                    BasicTextField(
                        value = editTask,
                        onValueChange = { if (it.length <= 50) editTask = it },
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                            .fillMaxWidth(),
                        textStyle = MaterialTheme.typography.task,
                        maxLines = 5,
                        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onDismiss) {
                            Text(
                                text = stringResource(R.string.cancel),
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.secondary
                            )
                        }

                        TextButton(onSaveClick) {
                            Text(
                                text = stringResource(R.string.save),
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.secondary
                            )
                        }
                    }
                }
            }
        }
    }
}