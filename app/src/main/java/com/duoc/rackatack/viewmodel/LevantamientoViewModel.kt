package com.duoc.rackatack.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duoc.rackatack.models.Levantamiento
import com.duoc.rackatack.models.Rack
import com.duoc.rackatack.repository.LevantamientoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LevantamientoViewModel : ViewModel() {
    private val repository = LevantamientoRepository()

    private val _levantamientos = MutableStateFlow<List<Levantamiento>>(emptyList())
    val levantamientos: StateFlow<List<Levantamiento>> = _levantamientos

    private val _racks = MutableStateFlow<List<Rack>>(emptyList())
    val racks: StateFlow<List<Rack>> = _racks

    var tempRackId: String = ""
    var tempFecha: String = ""
    var tempInspector: String = ""
    var tempObservaciones: String = ""

    init {
        cargarLevantamientos()
        cargarRacks()
    }

    fun cargarLevantamientos() {
        viewModelScope.launch {
            try {
                _levantamientos.value = repository.obtenerLevantamientos()
                Log.d("API", "Cargados: ${_levantamientos.value.size}")
            } catch (e: Exception) {
                Log.e("API", "Error: ${e.message}")
            }
        }
    }

    fun cargarRacks() {
        viewModelScope.launch {
            try {
                _racks.value = repository.obtenerRacks()
            } catch (e: Exception) {

            }
        }
    }

    fun guardarLevantamiento(nuevoLevantamiento: Levantamiento) {
        viewModelScope.launch {
            try {
                repository.crearLevantamiento(nuevoLevantamiento)
                cargarLevantamientos()
            } catch (e: Exception) {
            }
        }
    }
}