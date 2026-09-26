package com.presentation.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.Presentation.CommonUI.Event.Event_I.network_module_UI.Local_Manager_NetworkUIRepository
import com.Presentation.CommonUI.Event.Event_I.network_module_UI.NetworkManager
import com.Presentation.CommonUI.StartScreen
import com.Presentation.CommonUI.MainScreen
import com.Presentation.CommonUI.mainScreenUI.LocalDomain.LocalManager
import com.Presentation.CommonUI.mainScreenUI.LocalDomain.StatusBarStateHolder
import com.Presentation.CommonUI.mainScreenUI.LocalDomain.Worker
import com.domain.LoginLogic.preLoard
import com.domain.MainScreenLogic.StatusBarLogic
import com.domain.processRequest_
import com.domain.network_android.FirestoreNotesDataSource
import com.localdatabase.Execute_read_android
import com.localdatabase.Execute_search_android
import com.localdatabase.preLoadC_android
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Black
            ) {
                val manager = remember { LocalManager() }
                var showMainScreen by remember { mutableStateOf(false) }
                val Link = remember { Worker() }
                val network =remember { Local_Manager_NetworkUIRepository() }
                val dataSource= remember { FirestoreNotesDataSource() }
                val request= remember { processRequest_(dataSource) }
                val networkManager=remember { NetworkManager(request) }
                val statusBarLogic_= remember{ StatusBarLogic() }
                val statusBar_ = remember {
                    StatusBarStateHolder().apply {

                        changeGreeting(statusBarLogic_.timeState())
                    }
                }
                val isVerified: Boolean = remember {
                    val readImpl = preLoadC_android()
                    val searchImpl =
                        Execute_search_android()

                    val preLoadObj = preLoard(readImpl, searchImpl)
                    preLoadObj.preLoad_()
                }

                LaunchedEffect(Unit) {
                    delay(5000)
                    showMainScreen = true
                }

                if (showMainScreen) {
                    MainScreen(Link,manager,network,networkManager,statusBar_)
                } else {
                    StartScreen()
                }
            }

            var boxOneStatus by remember { mutableStateOf(true) }
        }
    }
}