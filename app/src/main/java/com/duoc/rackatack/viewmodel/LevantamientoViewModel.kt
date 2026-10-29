package com.duoc.rackatack.viewmodel

import androidx.lifecycle.ViewModel
import com.duoc.rackatack.repository.LevantamientoRepository

class LevantamientoViewModel : ViewModel() {
    private val repository = LevantamientoRepository()

    val levantamientos = repository.obtenerLevantamientos()
}
