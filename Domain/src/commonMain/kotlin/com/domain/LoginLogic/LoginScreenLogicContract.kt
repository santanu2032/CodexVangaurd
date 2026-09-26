package com.domain.LoginLogic

interface LoginScreenLogicContract {
    fun RequestAccess(r: Int, name: String): String
}