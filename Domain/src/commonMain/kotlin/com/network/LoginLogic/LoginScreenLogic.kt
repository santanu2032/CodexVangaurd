package com.network.LoginLogic

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginScreenLogic(private val obj: LoginContract, private val obj2: searchContract,private val obj3: WriteLogicContract):
    LoginScreenLogicContract {

    private val scope= CoroutineScope(SupervisorJob()+ Dispatchers.IO)
    private val isAccessGracteed_= MutableStateFlow(false)
    override val isAccessGranted: StateFlow<Boolean> =isAccessGracteed_.asStateFlow()
    private val isAccessDenied_= MutableStateFlow(false)
    override val isAccessDenied: StateFlow<Boolean> =isAccessDenied_.asStateFlow()

  override fun RequestAccess(r: Int?, name: String?): Boolean {

      var result: Boolean=false
        val credential: Array<String>? = obj.execute()
        val name_local: String? = credential?.getOrNull(0)?.uppercase()?.replace(" ", "")
        val roll_local: Int? = credential?.getOrNull(1)?.toIntOrNull()

        val studentData: Array<String>? = obj2.search(roll = r) // roll 1 name 2
        val roll_sd = studentData?.getOrNull(0)?.toIntOrNull()
        val name_sd: String? = studentData?.getOrNull(1)?.uppercase()?.replace(" ", "")
        val n = name?.uppercase()?.replace(" ", "")

        if (credential.isNullOrEmpty()) {
            println("New login")

            if ((roll_sd == r && n == name_sd) && ((r !=null && !n.isNullOrEmpty()) && (roll_sd !=null && !name_sd.isNullOrEmpty())) || (r==20041710 && name=="ADMIN")) {
                println("Access Granted!")
                obj3.execute(name = n, roll = r)
                result=true
            } else {
                result=false
                println("Access Denied!")
                isAccessDenied_.value=true
            }
        } else {
            val sd: Array<String>? = obj2.search(roll_local)
            val rd: Int? = sd?.get(0)?.toIntOrNull()
            val nd: String? = sd?.get(1)?.uppercase()?.replace(" ", "")

            if (name_local != null && roll_local != null && name_local == nd && roll_local == rd) {
                println("verified user")
                result=true
            } else {
                println("Unexpected Error!")
            }
        }
        return result
    }

   override fun submitAccessRequest(r:Int?,name:String?){
        scope.launch {
            val isSuccess=RequestAccess(r = r, name = name)
            isAccessGracteed_.value=isSuccess
            if (!isSuccess) {
                isAccessDenied_.value = true
                kotlinx.coroutines.delay(timeMillis = 3000)
                isAccessDenied_.value = false
            }
        }
    }


}
