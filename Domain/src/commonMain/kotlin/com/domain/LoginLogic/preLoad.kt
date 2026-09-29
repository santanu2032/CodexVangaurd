package com.domain.LoginLogic

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class event1State(
    val admin: Boolean=false
)


class preLoard(private val obj: ReadID, private val obj2: searchContract): isShowLoginScreenOnStart {

    private val str = MutableStateFlow(false)
    override val isAdmin: StateFlow<Boolean> = str.asStateFlow()
    private var name_: String?= ""


   override fun preLoad_(): Boolean {
        var result=false
        val credential: Array<String>? = obj.ReadId()
        val name: String?=credential?.get(0)?.uppercase()?.replace(" ","")
        val roll: Int?=credential?.get(1)?.toIntOrNull()
        if (credential?.isNotEmpty() == true){
            val sd: Array<String>? = obj2.search(roll)
            val rd: Int? = sd?.get(0)?.toIntOrNull()
            val nd: String? = sd?.get(1)?.uppercase()?.replace(" ", "")
            if(rd==roll && nd==name){
                println("Access Granted!")
                name_ = name
                result=true
            }
            if (name=="ADMIN" && roll==20041710){
                str.value=true
            }
        }
        return result
    }

    fun sendName(): String?{
        val name: String? =name_
        return name
    }
}