package com.duoc.rackatack.models
import androidx.room.*

@Dao
interface LoginDao {

    @Insert
    suspend fun insert (correo: Users)


}