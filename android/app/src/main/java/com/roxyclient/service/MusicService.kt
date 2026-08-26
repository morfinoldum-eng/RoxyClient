package com.roxyclient.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.roxyclient.R
import kotlinx.coroutines.*

class MusicService : Service() {
    private var mediaPlayer: MediaPlayer? = null
    private val scope = CoroutineScope(Dispatchers.Default + Job())
    private var isPlaying = false
    private var currentVolume = 0.7f

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return when (intent?.action) {
            "PLAY" -> {
                startBackgroundMusic()
                START_STICKY
            }
            "STOP" -> {
                stopBackgroundMusic()
                stopSelf()
                START_NOT_STICKY
            }
            "SET_VOLUME" -> {
                val volume = intent.getFloatExtra("volume", 0.7f)
                setVolume(volume)
                START_STICKY
            }
            else -> START_STICKY
        }
    }

    private fun startBackgroundMusic() {
        if (isPlaying) return

        try {
            // Using raw resource folder - add background_music.ogg to res/raw/
            mediaPlayer = MediaPlayer().apply {
                // Note: You need to provide actual music file
                // setDataSource("file:///android_asset/music/background_music.ogg")
                // For now, we'll create a placeholder setup
                isLooping = true
                setVolume(currentVolume, currentVolume)
                // start() // Uncomment when actual file is available
                isPlaying = true
            }
        } catch (e: Exception) {
            e.printStackTrace()
            isPlaying = false
        }
    }

    private fun stopBackgroundMusic() {
        try {
            mediaPlayer?.apply {
                if (isPlaying) {
                    stop()
                    release()
                }
            }
            mediaPlayer = null
            isPlaying = false
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun setVolume(volume: Float) {
        currentVolume = volume.coerceIn(0f, 1f)
        mediaPlayer?.setVolume(currentVolume, currentVolume)
    }

    override fun onDestroy() {
        stopBackgroundMusic()
        scope.cancel()
        super.onDestroy()
    }
}
