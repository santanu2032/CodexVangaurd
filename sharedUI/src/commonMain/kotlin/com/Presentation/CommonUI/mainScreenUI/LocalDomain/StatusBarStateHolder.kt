package com.Presentation.CommonUI.mainScreenUI.LocalDomain

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class StatusBarCurrentState(
    val modeCurrentState: String="casual",
    val currentTimeGreeting: String="Good Morning",
    val customerName:String="Admin"
)

class StatusBarStateHolder{

    private val CurrentState= MutableStateFlow(StatusBarCurrentState())
    val modeState: StateFlow<StatusBarCurrentState> =CurrentState.asStateFlow()

    fun changeMode(data: String){
        CurrentState.value=CurrentState.value.copy(modeCurrentState = data)
    }

}