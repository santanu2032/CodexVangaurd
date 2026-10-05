package com.Presentation.CommonUI.mainScreenUI.HomeScreen_

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier

import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain.UIStateHolder
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain.StatusBarStateHolder
import com.Presentation.CommonUI.mainScreenUI.StatusBar
import com.Presentation.CommonUI.values.CustomColorKT




@Composable
fun HomeScreenUI(eventLink: localManager, manager: UIStateHolder, state: StatusBarStateHolder) {

    Box(modifier = Modifier.fillMaxSize().background(CustomColorKT.EerieBlack())) {


        StatusBar(state, manager)
        PrototypeBox_I(manager)
        PrototypeBox_II(manager)
        PrototypeBox_III(eventLink)
        PrototypeBox_IV(eventLink)



    }
}