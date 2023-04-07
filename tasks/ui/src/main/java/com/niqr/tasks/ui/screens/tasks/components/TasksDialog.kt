package com.niqr.tasks.ui.screens.tasks.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
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
    onSaveClick: (task: Task) -> Unit,
    onDeleteClick: (task: Task) -> Unit
) {
    var editTask by remember {
        val text = task?.name ?: ""
        mutableStateOf(TextFieldValue(text, TextRange(text.length)))
    }
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(task) {
        val text = task?.name ?: ""
        editTask = TextFieldValue(text, TextRange(text.length))
    }

    if (task != null) {
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }

        AlertDialog(
            onDismissRequest = onDismiss,
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.large,
                color = MaterialTheme.colorScheme.surfaceVariant
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AnimatedCounter(count = 50 - editTask.text.length)
                    Spacer(Modifier.height(8.dp))

                    BasicTextField(
                        value = editTask,
                        onValueChange = { if (it.text.length <= 50) editTask = it },
                        modifier = Modifier
                            .focusRequester(focusRequester)
                            .padding(vertical = 12.dp)
                            .fillMaxWidth(),
                        textStyle = MaterialTheme.typography.task,
                        maxLines = 5,
                        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        if (task.name.isBlank())
                            Spacer(Modifier.width(1.dp))
                        else
                            TextButton(
                                onClick = { onDeleteClick(task) }
                            ) {
                                Text(
                                    text = stringResource(R.string.delete),
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.secondary
                                )
                            }

                        Row {
                            TextButton(onDismiss) {
                                Text(
                                    text = stringResource(R.string.cancel),
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.secondary
                                )
                            }

                            TextButton(
                                onClick = { onSaveClick(Task(editTask.text, task.isDone)) }
                            ) {
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
}