package com.Presentation.CommonUI.mainScreenUI.Library_

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
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
fun LibraryUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0F1014)) // Matches the deep EerieBlack background
            .padding(top = 48.dp, start = 24.dp, end = 24.dp)
    ) {
        // --- HEADER ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Library", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)

            // Dummy Filter/Sort Button
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFF191C24), RoundedCornerShape(12.dp))
                    .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("≡", color = Color.White, fontSize = 20.sp)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- DUMMY SEARCH BAR ---
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color(0xFF191C24), RoundedCornerShape(16.dp))
                .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(16.dp))
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("🔍", fontSize = 16.sp)
            Spacer(modifier = Modifier.width(12.dp))
            Text("Search notes, books, or topics...", color = Color(0xFF8B92A5), fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- CONTINUE READING SECTION ---
        Text("Continue Studying", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

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
                .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(24.dp))
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Book Cover Placeholder
                Box(
                    modifier = Modifier
                        .size(64.dp, 80.dp)
                        .background(Color(0xFF635688).copy(alpha = 0.2f), RoundedCornerShape(8.dp))
                        .border(1.dp, Color(0xFF635688).copy(alpha = 0.5f), RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("📘", fontSize = 24.sp)
                }

                Spacer(modifier = Modifier.width(16.dp))

                // Details and Progress
                Column(modifier = Modifier.weight(1f)) {
                    Text("Quantum Mechanics", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text("Chapter 3: Wave Functions", color = Color(0xFF8B92A5), fontSize = 12.sp)

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        LinearProgressIndicator(
                            progress = { 0.65f },
                            modifier = Modifier
                                .weight(1f)
                                .height(6.dp)
                                .clip(RoundedCornerShape(3.dp)),
                            color = Color(0xFF635688),
                            trackColor = Color(0xFF262A36)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text("65%", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- COLLECTIONS SECTION ---
        Text("My Collections", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Collection Card 1
            Box(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1.2f)
                    .background(Color(0xFF191C24), RoundedCornerShape(20.dp))
                    .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(20.dp))
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .background(Color(0xFF28565A).copy(alpha = 0.2f), RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("📐", fontSize = 16.sp)
                    }
                    Column {
                        Text("Mathematics", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                        Text("12 Resources", color = Color(0xFF8B92A5), fontSize = 12.sp)
                    }
                }
            }

            // Collection Card 2
            Box(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1.2f)
                    .background(Color(0xFF191C24), RoundedCornerShape(20.dp))
                    .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(20.dp))
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .background(Color(0xFF635688).copy(alpha = 0.2f), RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🔬", fontSize = 16.sp)
                    }
                    Column {
                        Text("Physics", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                        Text("8 Resources", color = Color(0xFF8B92A5), fontSize = 12.sp)
                    }
                }
            }
        }

        // --- BETA TESTER DISCLAIMER ---
        // This spacer dynamically pushes the disclaimer to the very bottom
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "🚧 Note for Beta Testers: This library screen is a placeholder UI and is currently under active development.",
            color = Color(0xFF8B92A5).copy(alpha = 0.7f),
            fontSize = 12.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 120.dp) // Keeps it well above the navigation bar
        )
    }
}