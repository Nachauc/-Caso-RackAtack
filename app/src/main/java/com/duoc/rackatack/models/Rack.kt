package com.duoc.rackatack.models

data class Rack(
    val id: Int,
    val numero: Int,
    val modelo: String,
    val encargado: String,
    val capacidad: Int
)

//HAY QUE MODIFICAR LOS VAL CON LOS NOMBRES QUE HAY EN LA BASE DE DATOS