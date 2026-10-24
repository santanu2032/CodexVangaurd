package com.Presentation.CommonUI.Event.Event_II

import com.domain.AI.UserInput.UserInputContract

class InputStateHolder : UserInputContract {
    private var current: String? = ""

    override fun setData(value: String?) { current = value }
    override fun getData(): String? = current
}