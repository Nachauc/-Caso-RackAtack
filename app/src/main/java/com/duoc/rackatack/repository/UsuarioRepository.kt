package com.duoc.rackatack.repository

import com.duoc.rackatack.models.Usuario
import com.duoc.rackatack.remote.RetrofitInstance

class UsuarioRepository {
    private val apiUsuarios = RetrofitInstance.apiUsuarios

    suspend fun registrarUsuario(usuario: Usuario): Usuario {
        return apiUsuarios.registrarUsuario(usuario)
    }

    suspend fun obtenerUsuarios(): List<Usuario> {
        return apiUsuarios.obtenerUsuarios()
    }
}