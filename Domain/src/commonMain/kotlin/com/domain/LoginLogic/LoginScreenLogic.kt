package com.domain.LoginLogic

class LoginScreenLogic(private val obj: LoginContract, private val obj2: searchContract):
    LoginScreenLogicContract {

  override fun RequestAccess(r: Int, name: String): String {

        val credential: Array<String>? = obj.execute()
        val name_local: String? = credential?.get(0)?.uppercase()?.replace(" ", "")
        val roll_local: Int? = credential?.get(1)?.toIntOrNull()

        val studentData: Array<String>? = obj2.search(roll = r) // roll 1 name 2
        val roll_sd = studentData?.get(0)?.toIntOrNull()
        val name_sd: String? = studentData?.get(1)?.uppercase()?.replace(" ", "")
        val n = name.uppercase().replace(" ", "")

        if (credential.isNullOrEmpty()) {
            println("New login")

            if (roll_sd == r && n == name_sd) {
                println("Access Granted!")
            } else {
                println("Access Denied!")
            }
        } else {
            val sd: Array<String>? = obj2.search(roll_local)
            val rd: Int? = sd?.get(0)?.toIntOrNull()
            val nd: String? = sd?.get(1)?.uppercase()?.replace(" ", "")

            if (name_local != null && roll_local != null && name_local == nd && roll_local == rd) {
                println("verified user")
            } else {
                println("Unexpected Error!")
            }
        }
        return ""
    }

}
