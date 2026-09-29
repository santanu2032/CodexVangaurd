package com.domain.LoginLogic

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface isShowLoginScreenOnStart {
    fun preLoad_(): Boolean

    val isAdmin: StateFlow<Boolean>
}