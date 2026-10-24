package com.Presentation.CommonUI.Event.Event_II

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.domain.AI.Output.SpeechOutputController
import com.domain.AI.UserInput.IntentManager
import com.domain.AI.UserInput.IntentResult
import com.domain.AI.UserInput.UserInputContract
import kotlinx.coroutines.launch
import java.util.UUID

@Composable
fun Event_2( obj3: UserInputContract,intentManager: IntentManager, speech: SpeechOutputController) {
    val scope = rememberCoroutineScope()
    var messages by remember {
        mutableStateOf(
            listOf(
                ChatMessage(
                    id = UUID.randomUUID().toString(),
                    text = "System initialized. How can I help?",
                    isUser = false
                )
            )
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Output(chatMessages = messages)

        SpeakerToggle(
            controller = speech,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .statusBarsPadding()
                .padding(12.dp)
        )
        InputContainer(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
                ,
            onSendClick = { userText ->
                messages = messages + ChatMessage(UUID.randomUUID().toString(), userText, isUser = true)

                scope.launch {
                    when (val result = intentManager.handle(userText)) {
                        is IntentResult.Success -> {
                            messages = messages + ChatMessage(UUID.randomUUID().toString(), result.reply, isUser = false)
                            speech.speakReply(result.reply)
                        }
                        is IntentResult.Failure -> {
                            messages = messages + ChatMessage(UUID.randomUUID().toString(), "⚠️ ${result.reason}", isUser = false)
                        }
                    }
                }
            },
            obj3 = obj3
        )
    }
}