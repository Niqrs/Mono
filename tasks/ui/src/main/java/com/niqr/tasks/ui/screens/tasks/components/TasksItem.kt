package com.niqr.tasks.ui.screens.tasks.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.niqr.core.ui.theme.task
import com.niqr.tasks.domain.model.Task

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun TasksItem(
    task: Task,
    onClick: (task: Task) -> Unit,
    onLongClick: (task: Task) -> Unit
) {
    Text(
        text = "${task.name}: ${task.isDone}",
        modifier = Modifier
            .combinedClickable(
                onClick = { onClick(task.copy(isDone = !task.isDone)) },
                onLongClick = { onLongClick(task) }
            )
            .basicMarquee()
            .padding(vertical = 10.dp),
        style = MaterialTheme.typography.task
    )
}