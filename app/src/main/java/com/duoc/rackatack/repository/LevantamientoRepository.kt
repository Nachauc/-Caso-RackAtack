package com.duoc.rackatack.repository

import com.duoc.rackatack.models.Levantamiento
import com.duoc.rackatack.models.Rack
import com.duoc.rackatack.remote.ApiService
import com.duoc.rackatack.remote.RetrofitInstance

class LevantamientoRepository(private val api: ApiService = RetrofitInstance.api) {
    suspend fun obtenerLevantamientos(): List<Levantamiento> {
        return api.getLevantamientos()
    }

    suspend fun obtenerLevantamientoPorId(id: Int): Levantamiento {
        return api.getLevantamientoPorId(id)
    }

    suspend fun crearLevantamiento(levantamiento: Levantamiento): Levantamiento {
        return api.crearLevantamiento(levantamiento)
    }

    suspend fun actualizarLevantamiento(id: Int, levantamiento: Levantamiento): Levantamiento {
        return api.actualizarLevantamiento(id, levantamiento)
    }

    suspend fun eliminarLevantamiento(id: Int) {
        api.eliminarLevantamiento(id)
    }

    suspend fun obtenerRacks(): List<Rack> {
        return api.getRacks()
    }

    suspend fun crearRack(rack: Rack): Rack {
        return api.crearRack(rack)
    }
}