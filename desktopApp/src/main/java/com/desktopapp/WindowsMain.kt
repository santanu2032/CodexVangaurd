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
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain.UIStateHolder
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain.StatusBarStateHolder
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain.Worker
import com.network.LoginLogic.preLoard
import com.network.MainScreenLogic.StatusBarLogic
import com.network.processRequest_
import com.network.firebase_db.Note
import com.network.firebase_db.RemoteNotesDataSource
import com.localdatabase.Execute_search_jvm
import com.localdatabase.preLoadC_jvm
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

/*
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
            val UIStateHolder = remember { UIStateHolder() }
            val network =remember { Local_Manager_NetworkUIRepository() }
            val dataSource= remember { object : RemoteNotesDataSource{
                override suspend fun uploadPdfAndSaveToCloud(
                    id: String,
                    subject: String,
                    fileName: String,
                    pdfBytes: ByteArray
                ): Result<Unit> = Result.success(Unit)

                override fun observeNotesFromCloud(): Flow<List<Note>> = emptyFlow()
            } }
            val request= remember { processRequest_(dataSource) }
            val networkManager=remember { NetworkManager(request) }
            val statusBarLogic_= remember{ StatusBarLogic() }
            val hour=statusBarLogic_.timeState()
            val statusBar_ = remember {
                StatusBarStateHolder().apply {

                    changeGreeting(statusBarLogic_.timeState())
                }
            }
            val preLoadObj = remember {
                val readImpl = preLoadC_jvm()
                val searchImpl = Execute_search_jvm()
                preLoard(obj = readImpl, obj2 = searchImpl)
            }
            LaunchedEffect(Unit) {
                statusBar_.changeGreeting(hour)
                delay(5000)
                showMainScreen = true
            }

            if (showMainScreen) {
                MainScreen(link, UIStateHolder,network,networkManager,statusBar_,preLoadObj,dataSource)
            } else {
                StartScreen()
            }
        }
    }
}
*/
