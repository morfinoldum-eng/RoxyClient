package com.roxyclient.model

data class AppSettings(
    val menuAnimationSpeed: Float = 1f,
    val menuSize: Float = 1f,
    val floatingButtonSize: Float = 1f,
    val floatingButtonX: Float = 0f,
    val floatingButtonY: Float = 0f,
    val theme: String = "dark",
    val audioVolume: Float = 0.7f,
    val musicEnabled: Boolean = true,
    val showFPS: Boolean = true,
    val showCPS: Boolean = true,
    val showCoordinates: Boolean = true,
    val showKeystrokes: Boolean = true,
    val showPing: Boolean = true,
    val showSpeed: Boolean = true,
    val showDirection: Boolean = true,
    val customWatermark: String = "ROXY CLIENT v1.0.0"
)
