package com.Presentation.CommonUI.Event.Event_II

import com.domain.AI.UserInput.UserInputContract
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class UserInput_(
    val USER_INPUT_DATA: String? =""
)
class _UserInput: UserInputContract{

    val currentData =MutableStateFlow(UserInput_())
    val sendData: StateFlow<UserInput_> = currentData.asStateFlow()

    override fun setData(str: String?){
        currentData.value = currentData.value.copy(USER_INPUT_DATA = str)
    }

    override fun getData(): String? {
        val str: String? = UserInput_().USER_INPUT_DATA
        return str
    }
}