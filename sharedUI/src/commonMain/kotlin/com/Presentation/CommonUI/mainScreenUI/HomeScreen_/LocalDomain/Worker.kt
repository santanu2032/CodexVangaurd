package com.Presentation.CommonUI.mainScreenUI.HomeScreen_.LocalDomain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.Presentation.CommonUI.mainScreenUI.HomeScreen_.localManager


class Worker : localManager {
    var isSelected by mutableStateOf(false)


    override fun onBoxIClicked(currentStatus: Boolean): Boolean {
        isSelected = currentStatus
        return isSelected
    }
    override fun onBoxIIClicked(currentStatus: Boolean): Boolean {
        isSelected = currentStatus
        return isSelected
    }
    override fun onBoxIIIClicked(currentStatus: Boolean): Boolean {
        isSelected = currentStatus
        return isSelected
    }
    override fun onBoxIVClicked(currentStatus: Boolean): Boolean {
        isSelected = currentStatus
        return isSelected
    }

}