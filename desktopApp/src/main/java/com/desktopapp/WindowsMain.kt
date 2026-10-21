package com.desktopapp
/*
import SensoryLinks.Audio.ExecuteAudioWindows
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import com.data.firebasedb.dataOperation.TC
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.Presentation.CommonUI.Event.AppContainer
import com.Presentation.CommonUI.Event.Event_I.network_module_UI.Local_Manager_NetworkUIRepository
import com.Presentation.CommonUI.Event.Event_I.network_module_UI.NetworkManager
import com.Presentation.CommonUI.Login.AccessDeniedUI
import com.Presentation.CommonUI.Login.LoginUi
import com.Presentation.CommonUI.MainScreen
import com.Presentation.CommonUI.StartScreen
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain.StatusBarStateHolder
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain.UIStateHolder
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain.Worker
import com.Presentation.CommonUI.mainScreenUI.NavigationBar_.NavigationBarUIStateHolder
import com.domain.firebase_db.Note
import com.domain.LoginLogic.LoginScreenLogic
import com.domain.LoginLogic.LoginScreenLogicContract
import com.domain.LoginLogic.preLoard
import com.domain.MainScreenLogic.StatusBarLogic


import com.domain.firebase_db.RemoteNotesDataSource
import com.domain.processRequest_
import com.localdatabase.Execute_read_jvm
import com.localdatabase.Execute_search_jvm
import com.localdatabase.Write_jvm
import com.localdatabase.preLoadC_jvm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.withContext

fun main() = application { // composition root
    Window(
        onCloseRequest = ::exitApplication,
        title = "Codex Vanguard"
    ) {
        // A scope that dies when the window closes
        val appScope = rememberCoroutineScope()

        /*** The object is created here so it can be passed down to Events Block ******************/
        remember {
            AppContainer.init(
                platformLink = ExecuteAudioWindows(appScope)
            )
        }
        /******************************************************************************************/

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {
            val manager = remember { UIStateHolder() }
            var showMainScreen by remember { mutableStateOf(false) }
            val link = remember { Worker() }
            val network = remember { Local_Manager_NetworkUIRepository() }

            val dataSource = remember {
                object : RemoteNotesDataSource {
                    override suspend fun uploadPdfAndSaveToCloud(
                        id: String,
                        subject: String,
                        fileName: String,
                        pdfBytes: ByteArray
                    ): Result<Unit> = Result.success(Unit)

                    override fun observeNotesFromCloud(): Flow<List<Note>> = emptyFlow()
                }
            }

            val request = remember { processRequest_(dataSource) }
            val networkManager = remember { NetworkManager(request) }
            val statusBarLogic_ = remember { StatusBarLogic() }
            val navObj = remember { NavigationBarUIStateHolder() }
            val obj = remember { TC() }

            val statusBar_ = remember {
                StatusBarStateHolder().apply {
                    changeGreeting(statusBarLogic_.timeState())
                }
            }

            var isVerified: Boolean by remember { mutableStateOf(false) }

            // Using your JVM database implementations
            val loginLogic: LoginScreenLogicContract = remember {
                val readImpl = Execute_read_jvm()
                val searchImpl = Execute_search_jvm()
                val write = Write_jvm()

                LoginScreenLogic(
                    obj = readImpl,
                    obj2 = searchImpl,
                    obj3 = write
                )
            }

            val preLoadObj = remember {
                val readImpl = preLoadC_jvm()
                val searchImpl = Execute_search_jvm()
                preLoard(obj = readImpl, obj2 = searchImpl)
            }

            val isLoginGranted =true
            val _isAccessDenied by loginLogic.isAccessDenied.collectAsState()
            val isAdminAccessGranted by preLoadObj.isAdmin.collectAsState()
            var name__: String?

            LaunchedEffect(key1 = Unit) {
                val timerJob = async { delay(timeMillis = 5000) }

                val verifiedResult = withContext(Dispatchers.IO) {
                    val readImpl = preLoadC_jvm()
                    val searchImpl = Execute_search_jvm()
                    val tempPreLoadObj = preLoard(obj = readImpl, obj2 = searchImpl)
                    tempPreLoadObj.preLoad_()
                }

                timerJob.await()
                println("performing the operation now:..........................................")
                preLoadObj.preLoad_()
                name__ = preLoadObj.sendName()
                println("operation performed: $name__...........................................")
                manager.setName(name__)
                isVerified = verifiedResult
                showMainScreen = true
            }

            if (!showMainScreen) {
                StartScreen()
            } else if (isVerified || isLoginGranted) {
                MainScreen(
                    link,
                    manager,
                    network,
                    networkManager,
                    statusBar_,
                    preLoadObj,
                    dataSource,
                    navObj,
                    obj = navObj,
                    obj
                )
            } else {
                if (_isAccessDenied) {
                    AccessDeniedUI()
                } else {
                    LoginUi(obj = loginLogic)
                }
            }
        }
    }
}
*/
