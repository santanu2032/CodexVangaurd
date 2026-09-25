package com.Presentation.CommonUI.Event.Event_I.network_module_UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.RequestRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NetworkManager(private val request: RequestRepository): ViewModel() {
    private val _sendRequest= MutableStateFlow("Requesting Network Activity")
    val sendRequest=_sendRequest.asStateFlow()

     fun requestNetworkActivity(str: String){
        _sendRequest.value="Requesting server access!"
        print("Requesting server access!\n")
        viewModelScope.launch {
            val _procesedRequest = request.processRequest(str)
            _sendRequest.value=_procesedRequest
        }
    }


}