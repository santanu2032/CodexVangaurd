package com.Presentation.CommonUI.mainScreenUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import com.Presentation.CommonUI.mainScreenUI.LocalDomain.LocalManager
import com.Presentation.CommonUI.mainScreenUI.LocalDomain.StatusBarStateHolder
import com.Presentation.CommonUI.values.CustomColorKT




@Composable
fun DrawMainScreenBackground(eventLink: localManager, manager: LocalManager,state: StatusBarStateHolder) {
    Box(modifier = Modifier.fillMaxSize().background(CustomColorKT.EerieBlack())) {
        Text(
            text = "Test",
            modifier = Modifier.align(Alignment.Center),
            color = Color.White
        )
        StatusBar(state)
        PrototypeBox_I(manager)
        PrototypeBox_II(manager)
        PrototypeBox_III(eventLink)
        PrototypeBox_IV(eventLink)
        NavigationBar()


    }
}