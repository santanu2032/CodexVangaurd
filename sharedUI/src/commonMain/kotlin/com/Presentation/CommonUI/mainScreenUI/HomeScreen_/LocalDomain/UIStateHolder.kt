package com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

enum class HomeScreenInternalState {
    DEFAULT_BOXES,
    EVENT_ONE,
    EVENT_TWO,
    EVENT_THREE,
    EVENT_FOUR
}

data class LocalUiState(
    val isClicked_1: Boolean = false,
    val isClicked_2: Boolean = false,
    val isClicked_3: Boolean = false,
    val isClicked_4: Boolean = false,
    val name: String? = "default",
    val mode: String = "default",
    val currentView: HomeScreenInternalState = HomeScreenInternalState.DEFAULT_BOXES
)

class UIStateHolder {

    private val _uiState_1 = MutableStateFlow(LocalUiState())
    private val _uiState_2 = MutableStateFlow(LocalUiState())
    private val _name = MutableStateFlow(LocalUiState().name)
    private val _mode = MutableStateFlow(LocalUiState())
    private val _state = MutableStateFlow(LocalUiState())

    val uiState_1: StateFlow<LocalUiState> = _uiState_1.asStateFlow()
    val uiState_2: StateFlow<LocalUiState> = _uiState_2.asStateFlow()
    val userName: StateFlow<String?> = _name.asStateFlow()
    val appMode: StateFlow<LocalUiState> = _mode.asStateFlow()
    val state: StateFlow<LocalUiState> = _state.asStateFlow()

    fun Clicked_1() {
        val newClickState = !_uiState_1.value.isClicked_1
        _uiState_1.value = _uiState_1.value.copy(
            isClicked_1 = newClickState,
            currentView = HomeScreenInternalState.EVENT_ONE
        )
        _state.value = _state.value.copy(
            isClicked_1 = newClickState,
            currentView = HomeScreenInternalState.EVENT_ONE
        )
    }

    fun Clicked_2() {
        val newClickState = !_uiState_2.value.isClicked_2
        _uiState_2.value = _uiState_2.value.copy(
            isClicked_2 = newClickState,
            currentView = HomeScreenInternalState.EVENT_TWO
        )
        _state.value = _state.value.copy(
            isClicked_2 = newClickState,
            currentView = HomeScreenInternalState.EVENT_TWO
        )
    }

    fun Clicked_3() {
        val newClickState = !_state.value.isClicked_3
        _state.value = _state.value.copy(
            isClicked_3 = newClickState,
            currentView = HomeScreenInternalState.EVENT_THREE
        )
    }

    fun Clicked_4() {
        val newClickState = !_state.value.isClicked_4
        _state.value = _state.value.copy(
            isClicked_4 = newClickState,
            currentView = HomeScreenInternalState.EVENT_FOUR
        )
    }

    fun setDefaultState() {
        _state.value = _state.value.copy(
            currentView = HomeScreenInternalState.DEFAULT_BOXES
        )
    }

    fun resetHomeEvents() {
        _uiState_1.value = _uiState_1.value.copy(
            isClicked_1 = false,
            currentView = HomeScreenInternalState.DEFAULT_BOXES
        )
        _uiState_2.value = _uiState_2.value.copy(
            isClicked_2 = false,
            currentView = HomeScreenInternalState.DEFAULT_BOXES
        )
        _state.value = _state.value.copy(
            isClicked_1 = false,
            isClicked_2 = false,
            isClicked_3 = false,
            isClicked_4 = false,
            currentView = HomeScreenInternalState.DEFAULT_BOXES
        )
    }

    fun setName(str1: String?) {
        val newname: String = str1.toString()
        _name.value = _name.value?.replace("default", newname)
        println(newname)
    }
}