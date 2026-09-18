package com.Presentation.CommonUI

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.Presentation.CommonUI.Event.Event_I.Event_1
import com.Presentation.CommonUI.Event.Event_I.network_module_UI.NetworkManager
import com.domain.NetworkUILinkRepository
import com.Presentation.CommonUI.Event.Event_II.Event_2
import com.Presentation.CommonUI.mainScreenUI.DrawMainScreenBackground
import com.Presentation.CommonUI.mainScreenUI.localManager
import com.Presentation.CommonUI.mainScreenUI.LocalDomain.LocalManager
import com.Presentation.CommonUI.mainScreenUI.LocalDomain.StatusBarStateHolder


@Composable
fun MainScreen(eventLink: localManager, localManager: LocalManager,networkEvent: NetworkUILinkRepository,networkManager: NetworkManager,state: StatusBarStateHolder){

    val currentState_prototypeBox_II by localManager.uiState_2.collectAsState()
    val currentState_prototypeBox_I by localManager.uiState_1.collectAsState()

    Box(modifier = Modifier.fillMaxSize()){

       /**
        * State Driven UI Rendering
        * */
        if (currentState_prototypeBox_II.isClicked_2) {
            Event_2()
        }
        else if(currentState_prototypeBox_I.isClicked_1){
            Event_1(networkEvent,networkManager)
        }
        else{
            DrawMainScreenBackground(eventLink,localManager,state)
        }
    }
}

