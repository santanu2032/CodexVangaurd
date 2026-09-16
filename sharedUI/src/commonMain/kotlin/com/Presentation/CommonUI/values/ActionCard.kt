package com.Presentation.CommonUI.values

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class ActionCardModel(
    val title: String,
    val description: String,
    val themeColor: Color,
    val topLabel: String,
    val actionText: String,
    val bottomLeftText: String,
    val progress: Float? = null
)

@Composable
fun StudyActionCard(model: ActionCardModel) {

    Card(
        modifier = Modifier.fillMaxSize(), // Now takes the size dictated by PrototypeBox
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF191C24))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawBehind {
                    drawCircle(
                        color = model.themeColor.copy(alpha = 0.15f),
                        radius = size.width * 0.45f,
                        center = Offset(size.width, 0f)
                    )
                }
                .padding(24.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(model.themeColor.copy(alpha = 0.2f), RoundedCornerShape(12.dp))
                    )
                    Text(
                        text = model.topLabel,
                        color = model.themeColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .background(model.themeColor.copy(alpha = 0.15f), RoundedCornerShape(16.dp))
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = model.title, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = model.description, color = Color(0xFF8B92A5), fontSize = 14.sp, lineHeight = 20.sp)

                Spacer(modifier = Modifier.weight(1f))

                if (model.progress != null) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Weekly goal", color = Color(0xFF8B92A5), fontSize = 12.sp)
                        Text("${(model.progress * 100).toInt()}%", color = model.themeColor, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    LinearProgressIndicator(
                        progress = { model.progress },
                        modifier = Modifier.fillMaxWidth().height(6.dp).clip(RoundedCornerShape(3.dp)),
                        color = model.themeColor,
                        trackColor = Color(0xFF262A36)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = model.bottomLeftText, color = Color(0xFF8B92A5), fontSize = 12.sp)
                    Text(text = "${model.actionText} ↗", color = model.themeColor, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}