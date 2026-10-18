package com.duoc.rackatack.repository

import com.duoc.rackatack.models.Levantamiento

class LevantamientoRepository {
    fun obtenerLevantamientos(): List<Levantamiento> = listOf(
        Levantamiento("Rack-DC-01","13-OCT-2026","Alan Alfaro","Valido"),
        Levantamiento("Rack-DC-01","13-OCT-2026","Maria Urrutia","Valido"),
        Levantamiento("Rack-DC-01","13-OCT-2026","Alan Alfaro","Valido"),
        Levantamiento("Rack-DC-01","13-OCT-2026","Maria Urrutia","Valido"),


    )
}