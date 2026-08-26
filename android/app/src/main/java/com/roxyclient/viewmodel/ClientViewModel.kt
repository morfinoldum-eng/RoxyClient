package com.roxyclient.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roxyclient.model.*
import com.roxyclient.repository.SettingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ClientViewModel(private val settingsRepository: SettingsRepository) : ViewModel() {
    
    private val _clientState = MutableStateFlow(ClientState())
    val clientState: StateFlow<ClientState> = _clientState.asStateFlow()

    private val _appSettings = MutableStateFlow(AppSettings())
    val appSettings: StateFlow<AppSettings> = _appSettings.asStateFlow()

    private val _combatSettings = MutableStateFlow(CombatSettings())
    val combatSettings: StateFlow<CombatSettings> = _combatSettings.asStateFlow()

    private val _movementSettings = MutableStateFlow(MovementSettings())
    val movementSettings: StateFlow<MovementSettings> = _movementSettings.asStateFlow()

    private val _visualsSettings = MutableStateFlow(VisualsSettings())
    val visualsSettings: StateFlow<VisualsSettings> = _visualsSettings.asStateFlow()

    private val _hudElements = MutableStateFlow<List<HUDElement>>(emptyList())
    val hudElements: StateFlow<List<HUDElement>> = _hudElements.asStateFlow()

    init {
        loadSettings()
    }

    private fun loadSettings() {
        viewModelScope.launch {
            settingsRepository.settingsFlow.collect { settings ->
                _appSettings.value = settings
            }
        }
    }

    fun toggleCombat() {
        _combatSettings.value = _combatSettings.value.copy(
            enabled = !_combatSettings.value.enabled
        )
    }

    fun updateCombatSettings(settings: CombatSettings) {
        _combatSettings.value = settings
    }

    fun toggleMovement() {
        _movementSettings.value = _movementSettings.value.copy(
            enabled = !_movementSettings.value.enabled
        )
    }

    fun updateMovementSettings(settings: MovementSettings) {
        _movementSettings.value = settings
    }

    fun toggleVisuals() {
        _visualsSettings.value = _visualsSettings.value.copy(
            enabled = !_visualsSettings.value.enabled
        )
    }

    fun updateVisualsSettings(settings: VisualsSettings) {
        _visualsSettings.value = settings
    }

    fun updateClientState(newState: ClientState) {
        _clientState.value = newState
    }

    fun updateAudioVolume(volume: Float) {
        viewModelScope.launch {
            settingsRepository.updateAudioVolume(volume)
        }
    }

    fun updateMusicEnabled(enabled: Boolean) {
        viewModelScope.launch {
            settingsRepository.updateMusicEnabled(enabled)
        }
    }

    fun resetToDefaults() {
        viewModelScope.launch {
            settingsRepository.resetToDefaults()
        }
    }
}
