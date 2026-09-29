package com.Presentation.CommonUI.mainScreenUI.LocalDomain

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class LocalUiState(
    val isClicked_2: Boolean = false,
    val isClicked_1:Boolean=false,
    val name: String?="default",
    val mode: String="default"
)

class UIStateHolder {

    private val _uiState_2 = MutableStateFlow(LocalUiState())
    private val _uiState_1=MutableStateFlow(LocalUiState())
    private val _name=MutableStateFlow(LocalUiState())
    private val _mode=MutableStateFlow(LocalUiState())
    val uiState_2: StateFlow<LocalUiState> = _uiState_2.asStateFlow()

    val uiState_1: StateFlow<LocalUiState> = _uiState_1.asStateFlow()
    val userName: StateFlow<LocalUiState> =_name.asStateFlow()
    val appMode: StateFlow<LocalUiState> =_mode.asStateFlow()

    fun Clicked_2() {
        _uiState_2.value = _uiState_2.value.copy(isClicked_2 = !_uiState_2.value.isClicked_2)

    }

    fun Clicked_1(){
        _uiState_1.value =_uiState_1.value.copy(isClicked_1 = !_uiState_1.value.isClicked_1)
    }

    fun setName(str1: String?){
        _name.value = _name.value.copy(name = str1)
    }

}