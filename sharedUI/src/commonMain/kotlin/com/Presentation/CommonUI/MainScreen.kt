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
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.HomeScreenUI
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.localManager
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain.UIStateHolder
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain.StatusBarStateHolder
import com.Presentation.CommonUI.mainScreenUI.Library_.LibraryUI
import com.Presentation.CommonUI.mainScreenUI.NavigationBar_.AppScreenState
import com.Presentation.CommonUI.mainScreenUI.NavigationBar_.NavigationBar
import com.Presentation.CommonUI.mainScreenUI.NavigationBar_.NavigationBarUIStateHolder
import com.Presentation.CommonUI.mainScreenUI.NavigationBar_.NavigationBarUIStateHolderContract
import com.Presentation.CommonUI.mainScreenUI.calendar_.CalendarUI
import com.domain.LoginLogic.isShowLoginScreenOnStart
import com.domain.firebase_db.RemoteNotesDataSource


@Composable
fun MainScreen(eventLink: localManager,
               UIStateHolder: UIStateHolder,
               networkEvent: NetworkUILinkRepository,
               networkManager: NetworkManager,
               state: StatusBarStateHolder,
               str: isShowLoginScreenOnStart,
               obj2: RemoteNotesDataSource,
               navState: NavigationBarUIStateHolder,
               obj: NavigationBarUIStateHolderContract
){

    val currentState_prototypeBox_II by UIStateHolder.uiState_2.collectAsState()
    val currentState_prototypeBox_I by UIStateHolder.uiState_1.collectAsState()
    val naveState_ by navState.NavigationBarUIState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()){

        if (naveState_.currentScreen== AppScreenState.HOME){
            HomeScreenUI(eventLink,UIStateHolder,state)
            if (currentState_prototypeBox_II.isClicked_2) {
                Event_2()
            }
            else if(currentState_prototypeBox_I.isClicked_1){
                Event_1(networkEvent,networkManager,str,obj2)
            }
        }
        else if (naveState_.currentScreen== AppScreenState.CALENDER){
            CalendarUI()
        }
        else if (naveState_.currentScreen== AppScreenState.LIBRARY){
            LibraryUI()
        }


        NavigationBar(obj=obj)
    }
}

