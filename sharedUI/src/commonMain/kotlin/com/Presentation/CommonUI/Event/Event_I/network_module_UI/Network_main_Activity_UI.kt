package com.Presentation.CommonUI.Event.Event_I.network_module_UI

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.NetworkUILinkRepository


@Composable
fun Network_UI(networkEvent: NetworkUILinkRepository,networkManager: NetworkManager){

    var isClicked by remember{mutableStateOf(false)}
    val boxColor = if (isClicked) Color.Gray else Color.White
    var text by remember { mutableStateOf("") }

    Box(modifier = Modifier

        .fillMaxSize()
        .background(color = Color.Black)

    ) {

        Box(modifier = Modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.2f)
            .background(color = Color.Transparent)//TODO("change it to mutable or remote calling")
            .align(alignment = BiasAlignment(horizontalBias = 0.1f, verticalBias = -0.96f))
            .padding(all = 20.dp),
            contentAlignment = Alignment.Center,


            ){
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

                                Text("Enter data")
                            }
                            innerTextField()
                        }
                    }
                )


                val purpleColor = Color(0xFF6750A4)



                Spacer(modifier = Modifier.width(6.dp))


            }
        }
        Box(modifier = Modifier
            .fillMaxHeight(0.08f)
            .fillMaxWidth(0.3f)
            .align(alignment = Alignment.Center)
            .background(color = boxColor)
            .clickable{
                isClicked=true
                networkEvent.Status_Report(isClicked)
                networkManager.requestNetworkActivity(text)
                val state = networkManager.sendRequest.value
                print("Test"+state)
            }
            ,
            contentAlignment = Alignment.Center

        ) {
            Text("Test run")
        }

    }
}