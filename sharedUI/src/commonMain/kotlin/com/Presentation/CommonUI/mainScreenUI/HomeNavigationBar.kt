package com.Presentation.CommonUI.mainScreenUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex


@Composable
fun NavigationBar(){
    Box(modifier = Modifier.fillMaxSize()) {


        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .zIndex(1f)
                .padding(horizontal = 24.dp, vertical = 24.dp)
                .fillMaxWidth()
                .height(76.dp)
                .background(color = Color(0xFF191C24), shape = RoundedCornerShape(24.dp))
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFF635688).copy(alpha = 0.3f), RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("⊞", color = Color.White, fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Dashboard", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
                }
            }


            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("📅", color = Color(0xFF8B92A5), fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Study plan", color = Color(0xFF8B92A5), fontSize = 12.sp)
                }
            }


            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("📚", color = Color(0xFF8B92A5), fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Library", color = Color(0xFF8B92A5), fontSize = 12.sp)
                }
            }
        }
    }
}