package com.duoc.rackatack.remote

import com.duoc.rackatack.models.Levantamiento
import com.duoc.rackatack.models.Rack
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET("levantamientos")
    suspend fun getLevantamientos(): List<Levantamiento>


    @GET("levantamientos/{id}")
    suspend fun getLevantamientoPorId(@Path("id") id: Int): Levantamiento


    @POST("levantamientos")
    suspend fun crearLevantamiento(@Body levantamiento: Levantamiento): Levantamiento


    @PUT("levantamientos/{id}")
    suspend fun actualizarLevantamiento(@Path("id") id: Int, @Body levantamiento: Levantamiento): Levantamiento


    @DELETE("levantamientos/{id}")
    suspend fun eliminarLevantamiento(@Path("id") id: Int)


    @GET("racks")
    suspend fun getRacks(): List<Rack>


    @POST("racks")
    suspend fun crearRack(@Body rack: Rack): Rack
}