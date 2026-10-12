package com.Presentation.CommonUI.mainScreenUI.calendar_

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalendarUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F1014)) // Matches your deep EerieBlack background
            .padding(top = 48.dp, start = 24.dp, end = 24.dp)
    ) {
        // --- CALENDAR HEADER ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("October 2026", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Text("❮", color = Color(0xFF8B92A5), fontSize = 18.sp)
                Text("❯", color = Color.White, fontSize = 18.sp)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- CALENDAR GRID CARD ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 20.dp,
                    shape = RoundedCornerShape(24.dp),
                    ambientColor = Color.Black,
                    spotColor = Color.Black
                )
                .background(Color(0xFF191C24), RoundedCornerShape(24.dp))
                .border(
                    width = 1.dp,
                    color = Color.White.copy(alpha = 0.05f),
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(20.dp)
        ) {
            Column {
                // Days of the week row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    listOf("Mo", "Tu", "We", "Th", "Fr", "Sa", "Su").forEach { day ->
                        Text(
                            text = day,
                            color = Color(0xFF8B92A5),
                            modifier = Modifier.weight(1f),
                            textAlign = TextAlign.Center,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Dummy Dates Grid
                val startOffset = 3 // Assume month starts on Thursday
                var currentDay = 1 - startOffset

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    for (week in 0..4) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            for (dayOfWeek in 0..6) {
                                val isCurrentMonth = currentDay in 1..31
                                val isToday = currentDay == 15 // Arbitrary highlighted "today"
                                val hasEvent = currentDay == 12 || currentDay == 22 || currentDay == 28

                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .aspectRatio(1f)
                                        .padding(4.dp)
                                        .clip(CircleShape)
                                        .background(if (isToday) Color(0xFF635688) else Color.Transparent),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                        if (isCurrentMonth) {
                                            Text(
                                                text = currentDay.toString(),
                                                color = if (isToday) Color.White else Color(0xFFE0E0E0),
                                                fontSize = 14.sp,
                                                fontWeight = if (isToday) FontWeight.Bold else FontWeight.Normal
                                            )
                                            // Small dot indicator for days with events
                                            if (hasEvent && !isToday) {
                                                Box(
                                                    modifier = Modifier
                                                        .padding(top = 2.dp)
                                                        .size(4.dp)
                                                        .background(Color(0xFFFFC107), CircleShape)
                                                )
                                            }
                                        }
                                    }
                                }
                                currentDay++
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- UPCOMING EVENTS LIST ---
        Text("Upcoming Study Sessions", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        // Dummy Event Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 12.dp,
                    shape = RoundedCornerShape(20.dp),
                    ambientColor = Color.Black,
                    spotColor = Color.Black
                )
                .background(Color(0xFF191C24), RoundedCornerShape(20.dp))
                .border(
                    width = 1.dp,
                    color = Color.White.copy(alpha = 0.05f),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Time indicator
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Text("10:00", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                    Text("AM", color = Color(0xFF8B92A5), fontSize = 12.sp)
                }

                // Vertical purple divider
                Box(modifier = Modifier
                    .height(40.dp)
                    .width(3.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFF635688))
                )

                Spacer(modifier = Modifier.width(16.dp))

                // Event Details
                Column {
                    Text("Advanced Mathematics", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Chapter 4 & 5 Review", color = Color(0xFF8B92A5), fontSize = 12.sp)
                }
            }
        }

        // --- BETA TESTER DISCLAIMER ---
        // This spacer pushes the text to the very bottom of the screen
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "🚧 Note for Beta Testers: This calendar is a placeholder UI and is currently under active development.",
            color = Color(0xFF8B92A5).copy(alpha = 0.7f),
            fontSize = 12.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 120.dp) // Extra padding to keep it above the navigation bar
        )
    }
}