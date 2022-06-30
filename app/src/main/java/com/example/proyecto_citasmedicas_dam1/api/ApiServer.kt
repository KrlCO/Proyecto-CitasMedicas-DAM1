package com.example.proyecto_citasmedicas_dam1.api

import com.example.proyecto_citasmedicas_dam1.models.Especialidad
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.Call

interface ApiServer {

    @POST("/medicamento/registrar")
    fun saveEspecialidad(@Body bean:Especialidad): Call<Void>
    @GET("/medicamento/buscar/{codigo}")
    fun findEspecialidad(@Path("codigo") cod:Int): Call<Especialidad>
    @GET("/medicamento/lista")
    fun listarEspecialidad(): Call<List<Especialidad>>

}