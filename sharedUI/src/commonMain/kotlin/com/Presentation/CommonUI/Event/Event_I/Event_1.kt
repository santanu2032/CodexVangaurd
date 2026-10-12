package com.Presentation.CommonUI.Event.Event_I

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.Presentation.CommonUI.Event.Event_I.network_module_UI.NetworkManager
import com.domain.NetworkUILinkRepository
import com.Presentation.CommonUI.Event.Event_I.network_module_UI.Admin_UI
import com.Presentation.CommonUI.Event.Event_I.network_module_UI.user.userUI
import com.domain.LoginLogic.isShowLoginScreenOnStart
import com.domain.TimeConfiguration
import com.domain.firebase_db.RemoteNotesDataSource


@Composable
fun Event_1(network: NetworkUILinkRepository,networkManager: NetworkManager,obj: isShowLoginScreenOnStart,obj2: RemoteNotesDataSource,obj3: TimeConfiguration){
    val isAdminAccessGranted by obj.isAdmin.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        if (isAdminAccessGranted) {//TODO fix admin login with state driven ui patter
        Admin_UI(networkEvent = network, networkManager)
    } else {
        userUI(obj2,obj3)
    }
    }
}