package com.Presentation.CommonUI.Event.Event_III

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.domain.LoginLogic.isShowLoginScreenOnStart

@Composable
fun WebView_User(url: String) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Transparent)
    ) {
        WebHelper(
            url = "https://santanu2032.github.io/lottery/index.html",
            modifier = Modifier.fillMaxSize()
        )
    }
}