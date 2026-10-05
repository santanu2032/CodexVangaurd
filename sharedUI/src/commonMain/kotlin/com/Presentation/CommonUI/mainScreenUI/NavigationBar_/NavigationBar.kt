package com.Presentation.CommonUI.mainScreenUI.NavigationBar_

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Composable
fun NavigationBar(obj: NavigationBarUIStateHolderContract) {

    val color1 by obj.c1State.collectAsState()
    val color2 by obj.c2State.collectAsState()
    val color3 by obj.c3State.collectAsState()
    val n1_ by obj.n1State.collectAsState()
    val n2_ by obj.n2State.collectAsState()
    val n3_ by obj.n3State.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier
                .zIndex(1f)
                .padding(horizontal = 24.dp, vertical = 24.dp)
                .fillMaxWidth()
                .height(76.dp)
                .background(color = Color(0xFF191C24), shape = RoundedCornerShape(24.dp))
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Dashboard
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(n1_.n1, RoundedCornerShape(16.dp))
                    .clickable{
                        obj.setStateToHome()
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text("⊞", color = Color.White, fontSize = 16.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text("Dashboard", color = color1.c1, fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }

            // Study Plan
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(n2_.n2, RoundedCornerShape(16.dp))
                    .clickable{
                        obj.setStateCalender()
                    },

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text("📅", color = Color(0xFF8B92A5), fontSize = 16.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text("Study plan", color = color3.c3, fontSize = 12.sp)
            }

            // Library
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(n3_.n3, RoundedCornerShape(16.dp))
                    .clickable{
                        obj.setStateLibrary()
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text("📚", color = Color(0xFF8B92A5), fontSize = 16.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Text("Library", color = color2.c2, fontSize = 12.sp)
            }
        }
    }
}