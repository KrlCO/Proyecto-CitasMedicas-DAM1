package com.example.proyecto_citasmedicas_dam1.models

import java.io.Serializable

class Paciente(var codigo: Int, var nombre:String,
               var apellidos:String, var dni: String,
               var edad: Int, var sexo: String,
               var tlf: String, var mail: String,
               var clave: String): Serializable {
}