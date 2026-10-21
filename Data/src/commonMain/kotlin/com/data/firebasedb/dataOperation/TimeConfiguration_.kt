package com.data.firebasedb.dataOperation

import com.domain.TimeConfiguration

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale



class TC : TimeConfiguration {

    override fun TimeConfiguration_(timestampMs: Long): String {

        val date = Date(timestampMs)
        val formatter = SimpleDateFormat("MMMM d, yyyy 'at' h:mm:ss a", Locale.getDefault())
        return formatter.format(date)
    }
}