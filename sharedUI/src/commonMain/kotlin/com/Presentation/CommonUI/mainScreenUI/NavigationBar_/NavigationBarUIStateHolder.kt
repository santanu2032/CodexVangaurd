package com.Presentation.CommonUI.mainScreenUI.NavigationBar_

import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class NavigationState(
    val currentScreen: AppScreenState = AppScreenState.HOME,
    val c1: Color =Color.White,
    val c2: Color =Color(0xFF8B92A5),
    val c3: Color =Color(0xFF8B92A5),
    val n1: Color =Color(0xFF635688).copy(alpha = 0.3f),
    val n2: Color =Color(0xFF191C24),
    val n3: Color =Color(0xFF191C24)
)



class NavigationBarUIStateHolder: NavigationBarUIStateHolderContract {

    private val state= MutableStateFlow(NavigationState())
    private val c1State_= MutableStateFlow(NavigationState())
    private val c2State_= MutableStateFlow(NavigationState())
    private val c3State_= MutableStateFlow(NavigationState())

    private val n1State_= MutableStateFlow(NavigationState())
    private val n2State_= MutableStateFlow(NavigationState())
    private val n3State_= MutableStateFlow(NavigationState())


    val NavigationBarUIState: StateFlow<NavigationState> =state.asStateFlow()
    override val c1State: StateFlow<NavigationState> =c1State_.asStateFlow()
    override val c2State: StateFlow<NavigationState> =c2State_.asStateFlow()
    override val c3State: StateFlow<NavigationState> =c3State_.asStateFlow()
    override val n1State: StateFlow<NavigationState> =n1State_.asStateFlow()
    override val n2State: StateFlow<NavigationState> =n1State_.asStateFlow()
    override val n3State: StateFlow<NavigationState> =n1State_.asStateFlow()

    override fun setStateToHome() {
        state.value= NavigationState(currentScreen = AppScreenState.HOME)
        c1State_.value= NavigationState(c1 = Color.White)
        c2State_.value= NavigationState(c2 = Color(0xFF8B92A5))
        c3State_.value= NavigationState(c3 = Color(0xFF8B92A5))
        n1State_.value= NavigationState(n1 = Color(0xFF635688).copy(alpha = 0.3f))
        n2State_.value= NavigationState(n2 = Color(0xFF191C24))
        n3State_.value= NavigationState(n3=Color(0xFF191C24))
    }

    override fun setStateLibrary() {
        state.value= NavigationState(currentScreen = AppScreenState.LIBRARY)
        c1State_.value= NavigationState(c1 = Color(0xFF8B92A5))
        c2State_.value= NavigationState(c2 = Color.White)
        c3State_.value= NavigationState(c3 = Color(0xFF8B92A5))
        n1State_.value= NavigationState(n1 = Color(0xFF191C24))
        n2State_.value= NavigationState(n2 = Color(0xFF635688).copy(alpha = 0.3f))
        n3State_.value= NavigationState(n3=  Color(0xFF191C24))
    }

    override fun setStateCalender() {
        state.value= NavigationState(currentScreen = AppScreenState.CALENDER)
        c1State_.value= NavigationState(c1 = Color(0xFF8B92A5))
        c2State_.value= NavigationState(c2 = Color(0xFF8B92A5))
        c3State_.value= NavigationState(c3 = Color.White)
        n1State_.value= NavigationState(n1 = Color(0xFF191C24))
        n2State_.value= NavigationState(n2 = Color(0xFF191C24))
        n3State_.value= NavigationState(n3=  Color(0xFF635688).copy(alpha = 0.3f))
    }
}