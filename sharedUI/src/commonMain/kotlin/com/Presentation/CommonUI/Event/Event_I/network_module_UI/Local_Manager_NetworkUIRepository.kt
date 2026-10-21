package com.Presentation.CommonUI.Event.Event_I.network_module_UI

import com.domain.NetworkUILinkRepository




class
Local_Manager_NetworkUIRepository: NetworkUILinkRepository {


    override  fun Status_Report(status: Boolean): Boolean {
        val current: Boolean=status
         return current
    }

}