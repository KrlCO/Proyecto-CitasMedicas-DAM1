package com.example.proyecto_citasmedicas_dam1.util

import android.app.Application
import android.content.Context
import com.example.proyecto_citasmedicas_dam1.data.InitDB

class appConfiguration: Application() {

    companion object{
        lateinit var CONTEXT : Context
        lateinit var BD: InitDB
        val BASE = "citas_medicas.db"
        val VERSION = 1


    }

    override fun onCreate() {
        super.onCreate()

        //Creando obj CONTEXT
        CONTEXT = applicationContext
        BD = InitDB()
    }

}