package com.network.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlin.random.Random

class FcmMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        // Only trigger if the message contains a notification payload
        message.notification?.let {
            showForegroundNotification(it.title, it.body)
        }
    }

    private fun showForegroundNotification(title: String?, body: String?) {
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "global_updates_channel"

        // Android 8.0+ requires a Notification Channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Global Updates",
                NotificationManager.IMPORTANCE_HIGH // Triggers the Heads-up banner
            ).apply {
                description = "Notifications for new server database uploads"
            }
            notificationManager.createNotificationChannel(channel)
        }

        // Build the visual UI of the notification
        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(android.R.drawable.ic_popup_sync) // Replace with your app's actual icon drawable
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .build()

        // Display the notification using a random ID so multiple alerts don't overwrite each other
        notificationManager.notify(Random.nextInt(), notification)
    }

    // Triggered if the Firebase token is refreshed by the system
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // If you were routing notifications to specific users, you would send this new token to your server here.
    }
}