package com.example.proyecto_citasmedicas_dam1.util

import com.example.proyecto_citasmedicas_dam1.api.ApiServer

class ApiUtils {

    companion object {
        val BASE_URL="https://medicamento-api.herokuapp.com"
        //https://modelo-cl3.herokuapp.com/medicamento/lista
        fun getAPIService(): ApiServer {
            return RetrofitClient.getClient(BASE_URL).create(ApiServer::class.java)
        }
    }

}