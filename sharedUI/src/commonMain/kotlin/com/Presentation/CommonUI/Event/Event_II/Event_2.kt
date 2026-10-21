package com.Presentation.CommonUI.Event.Event_II

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.util.UUID

@Composable
fun Event_2() {
    var messages by remember {
        mutableStateOf(
            listOf(
                ChatMessage(id = UUID.randomUUID().toString(), text = "System initialized. How can I help?", isUser = false)
            )
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Output(
            chatMessages = messages
        )

        InputContainer(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .systemBarsPadding(),
            onMicClick = {
                messages = messages + ChatMessage(
                    id = UUID.randomUUID().toString(),
                    text = "🎤 [Audio input recorded]",
                    isUser = true
                )
            },
            onSendClick = { userText ->
                val userMsg = ChatMessage(id = UUID.randomUUID().toString(), text = userText, isUser = true)
                val systemReply = ChatMessage(id = UUID.randomUUID().toString(), text = "Echo: $userText", isUser = false)

                messages = messages + userMsg + systemReply
            }
        )
    }
}