package com.presentation.android

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
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
import com.network.LoginLogic.LoginScreenLogic
import com.network.LoginLogic.LoginScreenLogicContract
import com.network.LoginLogic.preLoard
import com.network.MainScreenLogic.StatusBarLogic
import com.network.processRequest_
import com.network.network_android.FirestoreNotesDataSource
import com.localdatabase.Execute_read_android
import com.localdatabase.Execute_search_android
import com.localdatabase.Write_android
import com.localdatabase.helper.getWritableDbPath
import com.localdatabase.preLoadC_android
import com.network.notification.FcmSubscriptionClient
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

        // Ensure the subscription is triggered only once when the app launches
        FcmSubscriptionClient.subscribeToGlobalUpdates()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "global_updates_channel",
                "Global Updates",
                NotificationManager.IMPORTANCE_HIGH
            ).apply { description = "Notifications for new server database uploads" }
            getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        }
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Black
            ) {
                // Set up the Android 13+ Notification Permission Request
                val context = LocalContext.current
                val permissionLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.RequestPermission()
                ) { isGranted ->
                    if (!isGranted) {
                        println("Notification permission denied by user.")
                    }
                }

                LaunchedEffect(Unit) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        val isGranted = ContextCompat.checkSelfPermission(
                            context,
                            Manifest.permission.POST_NOTIFICATIONS
                        ) == PackageManager.PERMISSION_GRANTED

                        if (!isGranted) {
                            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                        }
                    }
                }

                val manager = remember { UIStateHolder() }
                var showMainScreen by remember { mutableStateOf(false) }
                val Link = remember { Worker() }
                val network = remember { Local_Manager_NetworkUIRepository() }
                val dataSource = remember { FirestoreNotesDataSource() }
                val request = remember { processRequest_(dataSource) }
                val networkManager = remember { NetworkManager(request) }
                val statusBarLogic_ = remember { StatusBarLogic() }
                val navObj = remember { NavigationBarUIStateHolder() }

                val statusBar_ = remember {
                    StatusBarStateHolder().apply {
                        changeGreeting(statusBarLogic_.timeState())
                    }
                }

                var isVerified: Boolean by remember { mutableStateOf(false) }

                val loginLogic: LoginScreenLogicContract = remember {
                    val readImpl = Execute_read_android(credPath)
                    val searchImpl = Execute_search_android(studentPath)
                    val write = Write_android(credPath)

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
                    MainScreen(
                        Link,
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