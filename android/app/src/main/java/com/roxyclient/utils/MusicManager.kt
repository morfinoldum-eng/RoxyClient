package com.roxyclient.utils

import android.content.Context
import android.content.Intent
import android.os.Build
import com.roxyclient.service.MusicService

object MusicManager {
    fun startMusic(context: Context) {
        val intent = Intent(context, MusicService::class.java).apply {
            action = "PLAY"
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intent)
        } else {
            context.startService(intent)
        }
    }

    fun stopMusic(context: Context) {
        val intent = Intent(context, MusicService::class.java).apply {
            action = "STOP"
        }
        context.startService(intent)
    }

    fun setVolume(context: Context, volume: Float) {
        val intent = Intent(context, MusicService::class.java).apply {
            action = "SET_VOLUME"
            putExtra("volume", volume.coerceIn(0f, 1f))
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intent)
        } else {
            context.startService(intent)
        }
    }
}
