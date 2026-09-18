package com.Presentation.CommonUI.mainScreenUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.Presentation.CommonUI.mainScreenUI.LocalDomain.StatusBarStateHolder

@Composable
fun StatusBar(state: StatusBarStateHolder) {//TODO("pass obj for currentState")
val currentState by state.modeState.collectAsState()
    val hour=currentState.currentTimeGreeting
    Box(modifier = Modifier.fillMaxSize()) {


        Row(
            modifier = Modifier
                .fillMaxWidth(0.94f)
                .fillMaxHeight(0.15f)
                .align(BiasAlignment(horizontalBias = 0f, verticalBias = -0.96f))
                 .padding(horizontal = 16.dp, vertical = 16.dp), // Reduced from 50.dp to prevent layout crush
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "LET'S STUDY",
                        color = Color(0xFF635688),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Focus mode",
                        color = Color(0xFF28565A),
                        fontSize = 11.sp,
                        modifier = Modifier
                            .background(Color(0xFF28565A).copy(alpha = 0.2f), RoundedCornerShape(12.dp))
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "$hour, Maya",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color(0xFF262A36), RoundedCornerShape(20.dp))
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    Text("🔥", fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("12 day streak", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Medium)
                }


                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFF262A36), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🔔", fontSize = 14.sp)
                }

                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFF635688), CircleShape)
                )
            }
        }
    }
}