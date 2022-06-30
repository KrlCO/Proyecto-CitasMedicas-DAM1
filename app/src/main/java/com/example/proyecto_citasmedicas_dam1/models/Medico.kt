package com.example.proyecto_citasmedicas_dam1.models

import java.io.Serializable

class Medico(var cod: Int, var nombre:String, var apellido:String
             , var especialidad: Int, var direccion:String, var correo:String,
             var telefono:String, var sexo:String, var cid:String): Serializable {
}