package com.example.ch15_outer

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.*

class MyMessengerService : Service() {
    lateinit var messenger: Messenger
    lateinit var replyMessenger: Messenger
    lateinit var player: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        player = MediaPlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
    }

    inner class IncomingHandler(
        context: Context,
        private val applicationContext: Context = context.applicationContext
    ): Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            when(msg.what){
                10 -> {
                    replyMessenger = msg.replyTo
                    if(!player.isPlaying){
                        player = MediaPlayer.create(this@MyMessengerService, R.raw.music)
                        try{
                            val replyMsg = Message()
                            replyMsg.what = 10
                            val replyBundle = Bundle()
                            replyBundle.putInt("duration", player.duration)
                            replyMsg.obj = replyBundle
                            replyMessenger.send(replyMsg)

                            player.start()
                        }catch (e: Exception){
                            e.printStackTrace()
                        }
                    }
                }
                20 -> {
                    if(player.isPlaying)
                        player.stop()
                }
                else -> super.handleMessage(msg)
            }
        }
    }
    override fun onBind(intent: Intent): IBinder {
        messenger = Messenger(IncomingHandler(this))
        return messenger.binder
    }
}