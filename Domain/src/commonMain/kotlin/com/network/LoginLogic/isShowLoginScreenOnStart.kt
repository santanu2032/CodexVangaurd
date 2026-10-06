package com.network.LoginLogic

import kotlinx.coroutines.flow.StateFlow

interface isShowLoginScreenOnStart {
    fun preLoad_(): Boolean

    val isAdmin: StateFlow<Boolean>
    val isUser: StateFlow<Boolean>
}