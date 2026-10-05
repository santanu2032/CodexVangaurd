package com.presentation.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.Presentation.CommonUI.Event.Event_I.network_module_UI.Local_Manager_NetworkUIRepository
import com.Presentation.CommonUI.Event.Event_I.network_module_UI.NetworkManager
import com.Presentation.CommonUI.Login.AccessDeniedUI
import com.Presentation.CommonUI.Login.LoginUi
import com.Presentation.CommonUI.StartScreen
import com.Presentation.CommonUI.MainScreen
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain.UIStateHolder
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain.StatusBarStateHolder
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain.Worker
import com.Presentation.CommonUI.mainScreenUI.NavigationBar_.NavigationBarUIStateHolder
import com.domain.LoginLogic.LoginScreenLogic
import com.domain.LoginLogic.LoginScreenLogicContract
import com.domain.LoginLogic.preLoard
import com.domain.MainScreenLogic.StatusBarLogic
import com.domain.processRequest_
import com.domain.network_android.FirestoreNotesDataSource
import com.localdatabase.Execute_read_android
import com.localdatabase.Execute_search_android
import com.localdatabase.Write_android
import com.localdatabase.helper.getWritableDbPath
import com.localdatabase.preLoadC_android
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val credPath = getWritableDbPath(applicationContext, "credential.db")
        val studentPath = getWritableDbPath(applicationContext, "studentRecord.db")
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Black
            ) {
                val manager = remember { UIStateHolder() }
                var showMainScreen by remember { mutableStateOf(false) }
                val Link = remember { Worker() }
                val network =remember { Local_Manager_NetworkUIRepository() }
                val dataSource= remember { FirestoreNotesDataSource() }
                val request= remember { processRequest_(dataSource) }
                val networkManager=remember { NetworkManager(request) }
                val statusBarLogic_= remember{ StatusBarLogic() }
                val navObj= remember { NavigationBarUIStateHolder() }
                val statusBar_ = remember {
                    StatusBarStateHolder().apply {

                        changeGreeting(statusBarLogic_.timeState())
                    }
                }

                var isVerified: Boolean by remember { mutableStateOf(false) }

                    val loginLogic: LoginScreenLogicContract = remember {
                        val readImpl = Execute_read_android(credPath)
                        val searchImpl = Execute_search_android(studentPath)
                        val write= Write_android(credPath)

                        LoginScreenLogic(
                            obj = readImpl,
                            obj2 = searchImpl,
                            obj3 = write
                        )
                    }

                val preLoadObj = remember {
                    val readImpl = preLoadC_android(dbPath = credPath)
                    val searchImpl = Execute_search_android(dbPath = studentPath)
                    preLoard(obj = readImpl, obj2 = searchImpl)
                }


                val isLoginGranted by loginLogic.isAccessGranted.collectAsState()
                val _isAccessDenied by loginLogic.isAccessDenied.collectAsState()
                val isAdminAccessGranted by preLoadObj.isAdmin.collectAsState()
                var name__: String?
                LaunchedEffect(key1 = Unit) {
                    val timerJob = async { delay(timeMillis = 5000) }

                    val verifiedResult = withContext(Dispatchers.IO) {
                        val readImpl = preLoadC_android(credPath)
                        val searchImpl = Execute_search_android(studentPath)
                        val preLoadObj = preLoard(obj = readImpl, obj2 = searchImpl)
                        preLoadObj.preLoad_()
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
                }
                else if (isVerified || isLoginGranted) {

                    MainScreen(Link,
                        manager,
                        network,
                        networkManager,
                        statusBar_,
                        preLoadObj,
                        dataSource,
                        navObj,
                        obj = navObj
                    )

                }
                else {

                    if (_isAccessDenied){
                        AccessDeniedUI()
                    }
                    else{
                        LoginUi(obj = loginLogic)
                    }
                }
            }


        }
    }
}