package com.duoc.rackatack.models

data class Levantamiento (
    val id: Int? = null,
    val rackId: String,
    val fecha: String,
    val inspector: String,
    val estado: String,

)
