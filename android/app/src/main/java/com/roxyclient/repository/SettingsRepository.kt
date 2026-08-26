package com.roxyclient.repository

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.roxyclient.model.AppSettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "roxy_settings")

class SettingsRepository(private val context: Context) {
    companion object {
        private val MENU_ANIMATION_SPEED = floatPreferencesKey("menu_animation_speed")
        private val MENU_SIZE = floatPreferencesKey("menu_size")
        private val FLOATING_BUTTON_SIZE = floatPreferencesKey("floating_button_size")
        private val FLOATING_BUTTON_X = floatPreferencesKey("floating_button_x")
        private val FLOATING_BUTTON_Y = floatPreferencesKey("floating_button_y")
        private val THEME = stringPreferencesKey("theme")
        private val AUDIO_VOLUME = floatPreferencesKey("audio_volume")
        private val MUSIC_ENABLED = booleanPreferencesKey("music_enabled")
        private val SHOW_FPS = booleanPreferencesKey("show_fps")
        private val SHOW_CPS = booleanPreferencesKey("show_cps")
        private val SHOW_COORDINATES = booleanPreferencesKey("show_coordinates")
        private val SHOW_KEYSTROKES = booleanPreferencesKey("show_keystrokes")
        private val SHOW_PING = booleanPreferencesKey("show_ping")
        private val SHOW_SPEED = booleanPreferencesKey("show_speed")
        private val SHOW_DIRECTION = booleanPreferencesKey("show_direction")
        private val CUSTOM_WATERMARK = stringPreferencesKey("custom_watermark")
    }

    val settingsFlow: Flow<AppSettings> = context.dataStore.data.map { preferences ->
        AppSettings(
            menuAnimationSpeed = preferences[MENU_ANIMATION_SPEED] ?: 1f,
            menuSize = preferences[MENU_SIZE] ?: 1f,
            floatingButtonSize = preferences[FLOATING_BUTTON_SIZE] ?: 1f,
            floatingButtonX = preferences[FLOATING_BUTTON_X] ?: 0f,
            floatingButtonY = preferences[FLOATING_BUTTON_Y] ?: 0f,
            theme = preferences[THEME] ?: "dark",
            audioVolume = preferences[AUDIO_VOLUME] ?: 0.7f,
            musicEnabled = preferences[MUSIC_ENABLED] ?: true,
            showFPS = preferences[SHOW_FPS] ?: true,
            showCPS = preferences[SHOW_CPS] ?: true,
            showCoordinates = preferences[SHOW_COORDINATES] ?: true,
            showKeystrokes = preferences[SHOW_KEYSTROKES] ?: true,
            showPing = preferences[SHOW_PING] ?: true,
            showSpeed = preferences[SHOW_SPEED] ?: true,
            showDirection = preferences[SHOW_DIRECTION] ?: true,
            customWatermark = preferences[CUSTOM_WATERMARK] ?: "ROXY CLIENT v1.0.0"
        )
    }

    suspend fun updateMenuAnimationSpeed(speed: Float) {
        context.dataStore.edit { it[MENU_ANIMATION_SPEED] = speed }
    }

    suspend fun updateFloatingButtonPosition(x: Float, y: Float) {
        context.dataStore.edit {
            it[FLOATING_BUTTON_X] = x
            it[FLOATING_BUTTON_Y] = y
        }
    }

    suspend fun updateAudioVolume(volume: Float) {
        context.dataStore.edit { it[AUDIO_VOLUME] = volume }
    }

    suspend fun updateMusicEnabled(enabled: Boolean) {
        context.dataStore.edit { it[MUSIC_ENABLED] = enabled }
    }

    suspend fun resetToDefaults() {
        context.dataStore.edit { it.clear() }
    }
}
