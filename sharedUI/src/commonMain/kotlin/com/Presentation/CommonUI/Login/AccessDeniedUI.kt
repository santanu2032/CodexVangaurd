package com.Presentation.CommonUI.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import testui.sharedui.generated.resources.Res
import testui.sharedui.generated.resources.access_denied
import testui.sharedui.generated.resources.access_deniedWEBP
import testui.sharedui.generated.resources.ad
import testui.sharedui.generated.resources.login_bg


@Composable
fun AccessDeniedUI(){
    Box(modifier = Modifier
        .fillMaxSize()
    ){
        Image(
            painter = painterResource(Res.drawable.access_deniedWEBP),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}