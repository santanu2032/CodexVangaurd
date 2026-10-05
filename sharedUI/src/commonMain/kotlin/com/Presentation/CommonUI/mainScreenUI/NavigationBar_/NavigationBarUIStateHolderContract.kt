package com.Presentation.CommonUI.mainScreenUI.NavigationBar_

import kotlinx.coroutines.flow.StateFlow

interface NavigationBarUIStateHolderContract {
    fun setStateToHome()
    fun setStateLibrary()
    fun setStateCalender()
    val c1State: StateFlow<NavigationState>
    val c2State: StateFlow<NavigationState>
    val c3State: StateFlow<NavigationState>
    val n1State: StateFlow<NavigationState>
    val n2State: StateFlow<NavigationState>
    val n3State: StateFlow<NavigationState>


}