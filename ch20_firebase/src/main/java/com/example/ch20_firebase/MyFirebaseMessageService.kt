package com.example.ch20_firebase

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessageService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("criss", "fcm token.................$token")
        //d0vptMuWTFGiQwHuoz2OIS:APA91bGIWYoyRDUPzq3VoM28B1IEmur_T_Z70ybOQstmffoHcj7Ec1LRtOofTWjDF1Hfn4BGRF8Sc3AIQrUqfnoOtqp_1IzAG6F0usXoUQC0nNj2SMsM6alsGb3jjjTh0W27ozXo57ca
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.d("criss", "fcm message................ ${message.notification}")
        Log.d("criss", "fcm message................ ${message.data}")
    }
}