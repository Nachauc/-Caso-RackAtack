package com.duoc.rackatack.repository

import com.duoc.rackatack.models.Levantamiento
import com.duoc.rackatack.models.Rack
import com.duoc.rackatack.remote.RetrofitInstance

class LevantamientoRepository {
    suspend fun obtenerLevantamientos(): List<Levantamiento> {
        return RetrofitInstance.api.getLevantamientos()
    }

    suspend fun obtenerLevantamientoPorId(id: Int): Levantamiento {
        return RetrofitInstance.api.getLevantamientoPorId(id)
    }

    suspend fun crearLevantamiento(levantamiento: Levantamiento): Levantamiento {
        return RetrofitInstance.api.crearLevantamiento(levantamiento)
    }

    suspend fun actualizarLevantamiento(id: Int, levantamiento: Levantamiento): Levantamiento {
        return RetrofitInstance.api.actualizarLevantamiento(id, levantamiento)
    }

    suspend fun eliminarLevantamiento(id: Int) {
        RetrofitInstance.api.eliminarLevantamiento(id)
    }

    suspend fun obtenerRacks(): List<Rack> {
        return RetrofitInstance.api.getRacks()
    }

    suspend fun crearRack(rack: Rack): Rack {
        return RetrofitInstance.api.crearRack(rack)
    }
}