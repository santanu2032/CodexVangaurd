package com.network.LoginLogic

import kotlinx.coroutines.flow.StateFlow

interface LoginScreenLogicContract {

    val isAccessGranted: StateFlow<Boolean>

    val isAccessDenied: StateFlow<Boolean>
    fun RequestAccess(r: Int?, name: String?): Boolean
    fun submitAccessRequest(r:Int?,name:String?)
}