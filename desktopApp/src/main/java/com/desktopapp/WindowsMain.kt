package com.desktopapp
import SensoryLinks.Audio.ExecuteAudioWindows
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

import kotlinx.coroutines.delay
import androidx.compose.ui.graphics.Color
import com.Presentation.CommonUI.Event.AppContainer
import com.Presentation.CommonUI.Event.Event_I.network_module_UI.Local_Manager_NetworkUIRepository
import com.Presentation.CommonUI.Event.Event_I.network_module_UI.NetworkManager
import com.Presentation.CommonUI.MainScreen
import com.Presentation.CommonUI.StartScreen
import com.Presentation.CommonUI.mainScreenUI.LocalDomain.LocalManager
import com.Presentation.CommonUI.mainScreenUI.LocalDomain.StatusBarStateHolder
import com.Presentation.CommonUI.mainScreenUI.LocalDomain.Worker
import com.domain.MainScreenLogic.StatusBarLogic
import com.domain.RequestRepository


fun main() = application {//composition root
    Window(
        onCloseRequest = ::exitApplication,
        title = "Codex Vanguard"
    ) {
        // a scope that dies when the window closes
        val appScope = rememberCoroutineScope()
     /*** The object is created here so it can be passed down to Events Block******************/
        AppContainer.init(
            platformLink = ExecuteAudioWindows(appScope)
        )
        /**************************************************************************************/
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {
            var showMainScreen by remember { mutableStateOf(false) }
            val link = remember { Worker() }
            val localManager = remember { LocalManager() }
            val network =remember { Local_Manager_NetworkUIRepository() }
            val request= remember { RequestRepository() }
            val networkManager=remember { NetworkManager(request) }
            val statusBarLogic_= remember{ StatusBarLogic() }
            val hour=statusBarLogic_.timeState()
            val statusBar_ = remember {
                StatusBarStateHolder().apply {

                    changeGreeting(statusBarLogic_.timeState())
                }
            }
            LaunchedEffect(Unit) {
                statusBar_.changeGreeting(hour)
                delay(5000)
                showMainScreen = true
            }

            if (showMainScreen) {
                MainScreen(link, localManager,network,networkManager,statusBar_)
            } else {
                StartScreen()
            }
        }
    }
}