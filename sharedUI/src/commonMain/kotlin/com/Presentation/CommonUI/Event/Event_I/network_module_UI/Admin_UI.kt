package com.Presentation.CommonUI.Event.Event_I.network_module_UI

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.NetworkUILinkRepository


@Composable
fun Admin_UI(networkEvent: NetworkUILinkRepository, networkManager: NetworkManager){

    var isClicked by remember{mutableStateOf(false)}
    val boxColor = if (isClicked) Color.Gray else Color.White
    var text by remember { mutableStateOf("") }


    var drop: Boolean by remember { mutableStateOf(false) }
    val item=listOf<String>("urgent","normal")//TODO change to udf here later
    var selected by remember { mutableStateOf(item[0]) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF121212)) // Slightly softer dark background
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // 1. Text Field Area (Positioned at top)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 8.dp, shape = CircleShape)
                .background(color = Color(0xFF2C2C2C), shape = CircleShape)
                .padding(horizontal = 20.dp, vertical = 14.dp)
        ) {
            BasicTextField(
                value = text,
                onValueChange = { text = it },
                textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
                cursorBrush = SolidColor(Color.White),
                modifier = Modifier.weight(1f),
                decorationBox = { innerTextField ->
                    Box(contentAlignment = Alignment.CenterStart) {
                        if (text.isEmpty()) {
                            Text("Enter data", color = Color.Gray, fontSize = 16.sp) // Made hint visible
                        }
                        innerTextField()
                    }
                }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // 2. Button Area (Positioned center)
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(56.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(color = boxColor)
                .clickable {
                    // Logic unchanged
                    isClicked = true
                    networkEvent.Status_Report(isClicked)
                    networkManager.requestNetworkActivity(text, selected)
                    val state = networkManager.sendRequest.value
                    print("Test" + state)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Test run",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 3. Dropdown Area (Positioned below button)
        Box(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(50.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(color = Color(0xFF2C2C2C))
                .clickable { drop = true },
            contentAlignment = Alignment.Center
        ) {
            // Displaying the currently selected text (Missing in original UI)
            Text(
                text = selected.replaceFirstChar { it.uppercase() },
                color = Color.White,
                fontSize = 16.sp
            )

            DropdownMenu(
                modifier = Modifier.background(Color(0xFF2C2C2C)),
                expanded = drop,
                onDismissRequest = { drop = false }
            ) {
                item.forEach { dropdownItem ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = dropdownItem.replaceFirstChar { it.uppercase() },
                                color = Color.White
                            )
                        },
                        onClick = {
                            selected = dropdownItem
                            drop = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

