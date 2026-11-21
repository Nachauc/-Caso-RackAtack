package com.duoc.rackatack.remote

import com.duoc.rackatack.models.Rack
import retrofit2.http.GET

interface ApiService {
    @GET("racks")
    suspend fun getRacks(): List<Rack>
}
