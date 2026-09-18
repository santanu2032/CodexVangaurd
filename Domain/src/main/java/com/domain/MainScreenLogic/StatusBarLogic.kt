package com.domain.MainScreenLogic

import java.time.LocalTime

class StatusBarLogic: StatusBarNewState{


    override fun newModeState() {

    }

    override fun timeState():String {
        val currentHour= LocalTime.now().hour
        var hour: String=""
        if (currentHour >=5 && currentHour<12){
            hour="Good Morning!"
        }
        else if (currentHour>= 12 && currentHour<16){
            hour="Good Afternoon!"
        }
        else if (currentHour>=16 && currentHour<20){
            hour="Good Evening!"
        }
        else{
            hour="Good Night!"
        }

        return hour
    }
}