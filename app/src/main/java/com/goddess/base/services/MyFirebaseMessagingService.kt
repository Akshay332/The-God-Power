//package com.app_knit.base.services
//
//import android.app.Notification
//import android.app.NotificationChannel
//import android.app.NotificationManager
//import android.app.PendingIntent
//import android.content.Context
//import android.content.Intent
//import android.media.RingtoneManager
//import android.os.Build
//import androidx.core.app.NotificationCompat
//import androidx.core.content.ContextCompat
//import com.app_knit.base.R
//import com.app_knit.base.repository.models.Conversation
//import com.app_knit.base.repository.models.Post
//import com.app_knit.base.repository.preferences.UserPrefsManager
//import com.app_knit.base.utils.ApplicationGlobal
//import com.app_knit.base.utils.ValueMapping
//import com.app_knit.base.views.activities.HomeActivity
//import com.app_knit.base.views.activities.MainActivity
//import com.google.firebase.messaging.FirebaseMessagingService
//import com.google.firebase.messaging.RemoteMessage
//import com.google.gson.Gson
//
///**
// * Created by ShrayChona on 03-01-2019.
// */
//class MyFirebaseMessagingService : FirebaseMessagingService() {
//
//    companion object {
//        const val INTENT_EXTRAS_NOTIFICATION_TYPE = "notificationType"
//        const val INTENT_EXTRAS_POST = "post"
//        const val INTENT_EXTRAS_CONVERSATION = "conversation"
//    }
//
//    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
//        val data: Map<String, String>? = remoteMessage!!.data
//        if (null != data && data.isNotEmpty()) {
//            if (data.containsKey("title") && data.containsKey("reference") && data.containsKey("type")) {
//                val title = data["title"]
//                var message = data["subtitle"]
//                val refId = data["reference"]
//                val type = data["type"]
//                val payload = data["payload"]
//                if (message == null) message = ""
//                if (!title.isNullOrEmpty() && !refId.isNullOrEmpty() && refId!!.length > 7 && !type.isNullOrEmpty())
//                    constructNotification(title!!, message!!, Integer.parseInt(refId.substring(refId.length - 7, refId.length), 16), type!!.toInt(), payload)
//            }
//        }
//    }
//
//    private fun constructNotification(title: String, message: String, notificationId: Int, type: Int, payload: String?) {
//        if (ApplicationGlobal.accessToken.isNotEmpty()) {
//
//            val intent = Intent(this, HomeActivity::class.java).putExtra(INTENT_EXTRAS_NOTIFICATION_TYPE, type)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//            when (type) {
//
//                ValueMapping.getNotificationTypeCommentPost() -> {
//                    if (!payload.isNullOrEmpty())
//                        intent.putExtra(INTENT_EXTRAS_POST, Gson().fromJson(payload, Post::class.java))
//                    sendNotification(notificationId, title, message, intent)
//                }
//
//                ValueMapping.getNotificationTypeNewMessage(),
//                ValueMapping.getNotificationMessageNewGroup(),
//                ValueMapping.getNotificationMessageNinjaGroupCreated(),
//                ValueMapping.getNotificationMessageNinjaPersonalCreated(),
//                ValueMapping.getNotificationTypeNewMessagePersonal(),
//                ValueMapping.getNotificationTypeNewMessageGroup() -> {
//                    if (!payload.isNullOrEmpty()) {
//                        val conversation = Gson().fromJson(payload, Conversation::class.java)
//                        conversation.conversationId = conversation._id
//                        intent.putExtra(INTENT_EXTRAS_CONVERSATION, conversation)
//                        if (conversation._id != ApplicationGlobal.openConversationId)
//                            sendNotification(notificationId, title, message, intent)
//                    }
//                }
//
//                else -> {
//                    sendNotification(notificationId, title, message, intent)
//                }
//            }
//        }
//    }
//
//    private fun sendNotification(notificationId: Int, title: String, message: String, intent: Intent) {
//        val notificationManager = this
//                .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//        notificationManager.notify(notificationId, getNotification(title, message, PendingIntent
//                .getActivity(this, notificationId, intent, 0)))
//    }
//
//
//    private fun sendGeneralNotification(title: String, message: String) {
//        val notificationManager = this
//                .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        val intent: Intent = if (UserPrefsManager(this).isLogined) {
//            Intent(this, HomeActivity::class.java)
//        } else {
//            Intent(this, MainActivity::class.java)
//        }
//
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//
//        notificationManager.notify(0, getNotification(title, message,
//                PendingIntent.getActivity(this, 0, intent, 0)))
//    }
//
//    private fun getNotification(title: String, message: String, pendingIntent: PendingIntent): Notification {
//        val channelId = "mainChannelId"
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val channelName = "MainChannel"
//            val descriptionText = "All notifications are shown here"
//            val importance = NotificationManager.IMPORTANCE_DEFAULT
//            val channel = NotificationChannel(channelId, channelName, importance).apply {
//                description = descriptionText
//            }
//            // Register the channel with the system
//            val notificationManager: NotificationManager =
//                    getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//            notificationManager.createNotificationChannel(channel)
//        }
//
//        return NotificationCompat.Builder(
//                this, channelId)
//                .setContentTitle(title)
//                .setContentText(message)
//                .setStyle(NotificationCompat.BigTextStyle()
//                        .bigText(message))
//                .setSmallIcon(getNotificationIcon())
//                .setColor(ContextCompat.getColor(this,R.color.colorWhite))
//                .setTicker(message)
//                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
//                // .setSound(Uri.parse("android.resource://" + getPackageName() + "/" +
//                //        R.raw.notification_sound))
//                .setDefaults(Notification.DEFAULT_ALL)
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setWhen(System.currentTimeMillis())
//                .setContentIntent(pendingIntent)
//                .setAutoCancel(true).build()
//    }
//
//    private fun getNotificationIcon(): Int {
//        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
//            R.drawable.ic_logo_small
//        else
//            R.drawable.ic_logo_small
//    }
//}