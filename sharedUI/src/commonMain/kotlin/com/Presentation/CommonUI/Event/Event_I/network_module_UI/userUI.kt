package com.Presentation.CommonUI.Event.Event_I.network_module_UI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.domain.firebase_db.RemoteNotesDataSource


@Composable
fun userUI(dataSource: RemoteNotesDataSource){
    val notes by remember(dataSource) {
        dataSource.observeNotesFromCloud()
    }.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(notes) { note ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                println("showing data now")
                Text(text = "Doc ID: ${note.user_id}", color = Color.White)
                Text(text = "ID: ${note.id}", color = Color.White)
                Text(text = "Subject: ${note.subject}", color = Color.White)
                Text(text = "URL / File: ${note.downloadUrl}", color = Color.White)
                Text(text = "Time: ${note.uploadedAt}", color = Color.White)
            }
            HorizontalDivider()
        }
    }
}