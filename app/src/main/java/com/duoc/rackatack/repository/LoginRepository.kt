package com.duoc.rackatack.repository

import com.duoc.rackatack.models.LoginDao
import com.duoc.rackatack.models.Users

class LoginRepository (private val dao: LoginDao){
    suspend fun insert(correo: Users ) = dao.insert(correo)
}