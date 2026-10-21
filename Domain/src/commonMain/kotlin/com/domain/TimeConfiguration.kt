package com.domain

import kotlinx.coroutines.flow.StateFlow


interface TimeConfiguration {
    fun TimeConfiguration_(timestampMs: Long): String
}