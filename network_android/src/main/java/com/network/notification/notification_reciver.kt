// File: network_android/src/main/java/com/network/notification/FcmSubscriptionClient.kt
package com.network.notification

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging

object FcmSubscriptionClient {
    private const val TAG = "FCM_Subscription"

    fun subscribeToGlobalUpdates() {
        FirebaseMessaging.getInstance().subscribeToTopic("global_updates")
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "Successfully subscribed to global_updates topic.")
                } else {
                    Log.e(TAG, "Failed to subscribe to global_updates topic.", task.exception)
                }
            }
    }
}