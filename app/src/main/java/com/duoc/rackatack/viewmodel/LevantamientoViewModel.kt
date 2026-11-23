package com.duoc.rackatack.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.duoc.rackatack.models.Levantamiento
import com.duoc.rackatack.repository.LevantamientoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LevantamientoViewModel(private val repository: LevantamientoRepository = LevantamientoRepository()) : ViewModel() {


    private val _levantamientos = MutableStateFlow<List<Levantamiento>>(emptyList())
    val levantamientos: StateFlow<List<Levantamiento>> = _levantamientos

    private val _mensajeBusqueda = MutableStateFlow<String?>(null)
    val mensajeBusqueda: StateFlow<String?> = _mensajeBusqueda

    var tempRackId: String = ""
    var tempFecha: String = ""
    var tempInspector: String = ""
    var tempObservaciones: String = ""

    init {
        cargarLevantamientos()
    }

    fun cargarLevantamientos() {
        viewModelScope.launch {
            try {
                _levantamientos.value = repository.obtenerLevantamientos()
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
                Log.e("API", "Error: ${e.message}")
            }
        }
    }

    fun eliminarLevantamiento(id: Int) {
        viewModelScope.launch {
            try {
                repository.eliminarLevantamiento(id)
                cargarLevantamientos()
            } catch (e: Exception) {
                Log.e("API", "Error: ${e.message}")

            }
        }
    }

    fun actualizarLevantamiento(id: Int, levantamiento: Levantamiento) {
        viewModelScope.launch {
            try {
                repository.actualizarLevantamiento(id, levantamiento)
                cargarLevantamientos()
            } catch (e: Exception) {
                Log.e("API", "Error: ${e.message}")

            }
        }
    }

    fun buscarLevantamientoPorId(id: Int) {
        viewModelScope.launch {
            try {
                val encontrado = repository.obtenerLevantamientoPorId(id)
                _levantamientos.value = listOf(encontrado)
                _mensajeBusqueda.value = null
            } catch (e: Exception) {
                _mensajeBusqueda.value = "No se encontró ningún levantamiento con el ID $id"
            }
        }
    }

    fun limpiarBusqueda() {
        _mensajeBusqueda.value = null
        cargarLevantamientos()
    }

}