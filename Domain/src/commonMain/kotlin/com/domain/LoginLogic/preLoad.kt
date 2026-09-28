package com.domain.LoginLogic

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class preLoard(private val obj: ReadID, private val obj2: searchContract): isShowLoginScreenOnStart {

    private val str = MutableStateFlow(false)
    override val isAdmin: StateFlow<Boolean> = str.asStateFlow()



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
                result=true
            }
            if (name=="SANTANUSARKAR" && roll==1353245678){
                str.value=true
            }
        }
        return result
    }
}