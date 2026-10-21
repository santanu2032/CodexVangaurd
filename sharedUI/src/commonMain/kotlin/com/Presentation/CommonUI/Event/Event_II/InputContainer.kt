package com.Presentation.CommonUI.Event.Event_II

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputContainer(
    modifier: Modifier = Modifier,
    onMicClick: () -> Unit = {},
    onSendClick: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }
    val isSendEnabled = text.isNotBlank()
    val purpleColor = Color(0xFF6750A4)
    val disabledColor = Color(0xFF3A3A3C)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 6.dp, shape = CircleShape)
                .background(color = Color(0xFF242426), shape = CircleShape)
                .border(width = 1.dp, color = Color(0xFF3A3A3C), shape = CircleShape)
                .padding(horizontal = 8.dp, vertical = 6.dp)
        ) {
            BasicTextField(
                value = text,
                onValueChange = { text = it },
                singleLine = true,
                textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
                cursorBrush = SolidColor(purpleColor),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                keyboardActions = KeyboardActions(
                    onSend = {
                        if (isSendEnabled) {
                            onSendClick(text.trim())
                            text = ""
                        }
                    }
                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (text.isEmpty()) {
                            Text(
                                text = "Type a command...",
                                color = Color(0xFF8E8E93),
                                fontSize = 16.sp
                            )
                        }
                        innerTextField()
                    }
                }
            )

            IconButton(
                onClick = onMicClick,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color(0xFF3A3A3C),
                    contentColor = Color.White
                ),
                modifier = Modifier.size(40.dp)
            ) {
                Text(text = "🎤", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.width(6.dp))

            IconButton(
                onClick = {
                    if (isSendEnabled) {
                        onSendClick(text.trim())
                        text = ""
                    }
                },
                enabled = isSendEnabled,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = purpleColor,
                    contentColor = Color.White,
                    disabledContainerColor = disabledColor,
                    disabledContentColor = Color.Gray
                ),
                modifier = Modifier.size(40.dp)
            ) {
                Text(
                    text = "➤",
                    color = if (isSendEnabled) Color.White else Color(0xFF6E6E73),
                    fontSize = 16.sp
                )
            }
        }
    }
}