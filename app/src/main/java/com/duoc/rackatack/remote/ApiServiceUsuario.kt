package com.duoc.rackatack.remote

import com.duoc.rackatack.models.Usuario
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServiceUsuario {
    @POST("usuarios")
    suspend fun registrarUsuario(@Body usuario: Usuario): Usuario

    @GET("usuarios")
    suspend fun obtenerUsuarios(): List<Usuario>
}