package com.roxyclient.model

import androidx.compose.runtime.mutableStateOf

data class ClientState(
    val version: String = "1.0.0",
    val isConnected: Boolean = false,
    val currentScreen: String = "menu",
    val fps: Int = 0,
    val cps: Int = 0,
    val playerCoordinates: String = "X: 0, Y: 0, Z: 0",
    val playerDirection: String = "N",
    val biome: String = "Unknown",
    val timeOfDay: String = "12:00",
    val ping: Int = 0
)

sealed class MenuItem(val title: String, val icon: String) {
    object Combat : MenuItem("Combat", "⚔️")
    object Movement : MenuItem("Movement", "🏃")
    object Visuals : MenuItem("Visuals", "👁️")
    object Player : MenuItem("Player", "👤")
    object World : MenuItem("World", "🌍")
    object HUD : MenuItem("HUD", "📊")
    object Settings : MenuItem("Settings", "⚙️")

    companion object {
        fun all() = listOf(Combat, Movement, Visuals, Player, World, HUD, Settings)
    }
}

data class HUDElement(
    val id: String,
    val name: String,
    val enabled: Boolean = true,
    val x: Float = 0f,
    val y: Float = 0f
)

data class CombatSettings(
    val enabled: Boolean = false,
    val showHitbox: Boolean = false,
    val showAttackRange: Boolean = false,
    val showCPS: Boolean = true
)

data class MovementSettings(
    val enabled: Boolean = false,
    val sprintEnabled: Boolean = false,
    val autoJumpEnabled: Boolean = false
)

data class VisualsSettings(
    val enabled: Boolean = false,
    val showESP: Boolean = false,
    val showEntityNametags: Boolean = false,
    val showDistance: Boolean = false,
    val fullbrightEnabled: Boolean = false,
    val showTracer: Boolean = false
)
