package com.example.proyecto_citasmedicas_dam1.models

import java.io.Serializable

class Cita(var codigo: Int, var esp: Int, var doctor:Int, var idpaciente: Int,
           var fecha:String, var hora:String, var descripcion: String):Serializable {
}