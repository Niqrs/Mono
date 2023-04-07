package com.niqr.tasks.ui.screens.tasks.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

internal fun LocalDate.toStringDate(): String {
    val today = LocalDate.now()
    return when(this) {
        today -> "TODAY"//TODO: String res
        today.minusDays(1) -> "YESTERDAY"
        today.plusDays(1) -> "TOMORROW"
        else -> this.format(DateTimeFormatter.ofPattern("d MMMM"))
    }
}