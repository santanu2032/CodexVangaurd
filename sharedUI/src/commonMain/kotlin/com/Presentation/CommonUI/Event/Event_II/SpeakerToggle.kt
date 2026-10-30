package com.Presentation.CommonUI.Event.Event_II

import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.AI.Output.SpeechOutputController


@Composable
fun SpeakerToggle(controller: SpeechOutputController, modifier: Modifier = Modifier) {
    val enabled by controller.enabled.collectAsState()
    val speaking by controller.isSpeaking.collectAsState()

    IconButton(
        onClick = { if (speaking) controller.stop() else controller.toggle() },
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = if (enabled) Color(0xFF6750A4) else Color(0xFF3A3A3C),
            contentColor = Color.White
        ),
        modifier = modifier.size(40.dp)
    ) {
        Text(text = if (speaking) "⏹" else if (enabled) "🔊" else "🔇", fontSize = 16.sp)
    }
}