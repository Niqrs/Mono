package com.niqr.tasks.data.utils

import com.google.firebase.Timestamp
import java.time.LocalDate
import java.time.ZoneOffset

internal fun LocalDate.toTimestamp(): Timestamp {
    return Timestamp(this.atTime(0, 0).toInstant(ZoneOffset.UTC).epochSecond, 0)
}