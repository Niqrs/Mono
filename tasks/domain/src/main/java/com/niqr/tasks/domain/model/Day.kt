package com.niqr.tasks.domain.model

import java.time.LocalDate

data class Day(
    val date: LocalDate = LocalDate.now(),
    val tasks: Map<String, Boolean> = emptyMap()
)
