package com.duoc.rackatack.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "login")
data class Users(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val correo : String,
    val password : String
)
