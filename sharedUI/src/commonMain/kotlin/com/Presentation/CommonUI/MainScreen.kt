package com.Presentation.CommonUI

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.domain.android.BackHandler
import com.Presentation.CommonUI.Event.Event_I.Event_1
import com.Presentation.CommonUI.Event.Event_I.network_module_UI.NetworkManager
import com.domain.NetworkUILinkRepository
import com.Presentation.CommonUI.Event.Event_II.Event_2
import com.Presentation.CommonUI.Event.Event_III.Event_3
import com.Presentation.CommonUI.Event.Event_IV.Event_4
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.HomeScreenUI
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain.HomeScreenInternalState
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.localManager
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain.UIStateHolder
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain.StatusBarStateHolder
import com.Presentation.CommonUI.mainScreenUI.Library_.LibraryUI
import com.Presentation.CommonUI.mainScreenUI.NavigationBar_.AppScreenState
import com.Presentation.CommonUI.mainScreenUI.NavigationBar_.NavigationBar
import com.Presentation.CommonUI.mainScreenUI.NavigationBar_.NavigationBarUIStateHolder
import com.Presentation.CommonUI.mainScreenUI.NavigationBar_.NavigationBarUIStateHolderContract
import com.Presentation.CommonUI.mainScreenUI.calendar_.CalendarUI
import com.domain.AI.UserInput.IntentManager
import com.domain.AI.UserInput.UserInputContract
import com.domain.LoginLogic.isShowLoginScreenOnStart
import com.domain.TimeConfiguration
import com.domain.firebase_db.RemoteNotesDataSource

@Composable
fun MainScreen(
    eventLink: localManager,
    UIStateHolder: UIStateHolder,
    networkEvent: NetworkUILinkRepository,
    networkManager: NetworkManager,
    state: StatusBarStateHolder,
    str: isShowLoginScreenOnStart,
    obj2: RemoteNotesDataSource,
    navState: NavigationBarUIStateHolder,
    obj: NavigationBarUIStateHolderContract,
    obj3: TimeConfiguration,
    obj4: UserInputContract,
    intentManager: IntentManager
) {
    val mainState by UIStateHolder.state.collectAsState()
    val naveState_ by navState.NavigationBarUIState.collectAsState()

    val showNavigationBar = !(naveState_.currentScreen == AppScreenState.HOME &&
            mainState.currentView == HomeScreenInternalState.EVENT_TWO)

    Box(modifier = Modifier.fillMaxSize()) {

        if (naveState_.currentScreen == AppScreenState.HOME) {
            HomeScreenUI(eventLink, UIStateHolder, state)

            if (mainState.currentView != HomeScreenInternalState.DEFAULT_BOXES) {
                BackHandler(enabled = true) {
                    UIStateHolder.resetHomeEvents()
                }
            }

            when (mainState.currentView) {
                HomeScreenInternalState.EVENT_ONE -> Event_1(networkEvent, networkManager, str, obj2, obj3)
                HomeScreenInternalState.EVENT_TWO -> Event_2(obj4,intentManager=intentManager)
                HomeScreenInternalState.EVENT_THREE -> Event_3(str)
                HomeScreenInternalState.EVENT_FOUR -> Event_4()
                HomeScreenInternalState.DEFAULT_BOXES -> {}
            }
        }
        else if (naveState_.currentScreen == AppScreenState.CALENDER) {
            CalendarUI()
        }
        else if (naveState_.currentScreen == AppScreenState.LIBRARY) {
            LibraryUI()
        }

        AnimatedVisibility(
            visible = showNavigationBar,
            modifier = Modifier.align(Alignment.BottomCenter),
            enter = slideInVertically(initialOffsetY = { it }),
            exit = slideOutVertically(targetOffsetY = { it })
        ) {
            NavigationBar(obj = obj)
        }
    }
}