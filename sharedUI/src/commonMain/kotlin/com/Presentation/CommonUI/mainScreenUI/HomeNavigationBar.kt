package com.Presentation.CommonUI.mainScreenUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex


@Composable
fun NavigationBar(){
    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.06f)
                .align(Alignment.BottomCenter)
                .zIndex(1f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.333f)
                    .fillMaxHeight()
                    .background(Color.White)
                    .padding(10.dp)
                    .align (Alignment.BottomStart)
            ) {
                Row(
                    modifier = Modifier
                        .background(Color(0xFF635688).copy(alpha = 0.3f), RoundedCornerShape(16.dp))
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){

                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.333f)
                    .fillMaxHeight()
                    .background(Color.White)
                    .padding(10.dp)
                    .align(Alignment.BottomCenter)
            ) { }

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.333f)
                    .fillMaxHeight()
                    .background(Color.White)
                    .padding(10.dp)
                    .align(Alignment.BottomEnd)
            ) { }
        }

    }
}
