package com.Presentation.CommonUI.Event.Event_II
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Composable
fun InputContainer(
    modifier: Modifier = Modifier,
    onMicClick: () -> Unit = {},
    onSendClick: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }


    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 4.dp, shape = CircleShape)
                .background(color = Color(0xFF2C2C2C), shape = CircleShape)
                .padding(horizontal = 8.dp, vertical = 6.dp)
        ) {

            // Unstyled text field area
            BasicTextField(
                value = text,
                onValueChange = { text = it },
                textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
                cursorBrush = SolidColor(Color.White),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                decorationBox = { innerTextField ->
                    Box(contentAlignment = Alignment.CenterStart) {
                        if (text.isEmpty()) {
                            // Optional placeholder logic can go here
                        }
                        innerTextField()
                    }
                }
            )


            val purpleColor = Color(0xFF6750A4)

            IconButton(
                onClick = onMicClick,
                colors = IconButtonDefaults.iconButtonColors(containerColor = purpleColor),
                modifier = Modifier.size(40.dp)
            ) {
                // TODO: Add Mic Icon
            }

            Spacer(modifier = Modifier.width(6.dp))

            IconButton(
                onClick = {
                    if (text.isNotBlank()) {
                        onSendClick(text)
                        text = ""
                    }
                },
                colors = IconButtonDefaults.iconButtonColors(containerColor = purpleColor),
                modifier = Modifier.size(40.dp)
            ) {
                // TODO: Add Send Icon
            }
        }
    }
}
