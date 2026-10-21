package com.Presentation.CommonUI.Event.Event_I.network_module_UI.user

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.domain.TimeConfiguration
import com.domain.firebase_db.RemoteNotesDataSource

@Composable
fun OutputBox(dataSource: RemoteNotesDataSource, obj: TimeConfiguration) {
    val notes by remember(dataSource) {
        dataSource.observeNotesFromCloud()
    }.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(notes) { note ->
            val timeStr: String = obj.TimeConfiguration_(note.uploadedAt)

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1C23))
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "ID: ${note.id}", color = Color(0xFF8B92A5), fontSize = 12.sp)
                        Text(text = timeStr, color = Color(0xFF8B92A5), fontSize = 12.sp)
                    }

                    Spacer(modifier = Modifier.height(8.dp))


                    Text(
                        text = note.subject.uppercase(),
                        color = if (note.subject.lowercase() == "urgent") Color(0xFFFF5252) else Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(text = note.downloadUrl, color = Color(0xFF4CAF50), fontSize = 14.sp)

                    Spacer(modifier = Modifier.height(8.dp))


                    Text(text = "UID: ${note.user_id}", color = Color(0xFFFFC107).copy(alpha = 0.7f), fontSize = 10.sp)
                }
            }
        }
    }
}