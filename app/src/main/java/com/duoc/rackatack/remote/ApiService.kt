package com.duoc.rackatack.remote

import com.duoc.rackatack.models.Levantamiento
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET("levantamiento")
    suspend fun getLevantamientos(): List<Levantamiento>


    @GET("levantamiento/{id}")
    suspend fun getLevantamientoPorId(@Path("id") id: Int): Levantamiento


    @POST("levantamiento")
    suspend fun crearLevantamiento(@Body levantamiento: Levantamiento): Levantamiento


    @PUT("levantamiento/{id}")
    suspend fun actualizarLevantamiento(@Path("id") id: Int, @Body levantamiento: Levantamiento): Levantamiento


    @DELETE("levantamiento/{id}")
    suspend fun eliminarLevantamiento(@Path("id") id: Int)

}