package com.example.proyecto_citasmedicas_dam1.arreglo

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.proyecto_citasmedicas_dam1.models.Paciente
import com.example.proyecto_citasmedicas_dam1.util.appConfiguration

class ArregloPaciente {

    fun listado(): ArrayList<Paciente>{

        var data = ArrayList<Paciente>()
        val con: SQLiteDatabase = appConfiguration.BD.readableDatabase

        val sql = "select * from tb_paciente"

        val rs: Cursor = con.rawQuery(sql, null)

        while (rs.moveToNext()){

            val bean = Paciente(rs.getInt(0),rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4),
                rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8))

            data.add(bean)

        }
        return data

    }

    fun adicionar(bean:Paciente): Int{
        var salida: Int = -1

        //Into the BD in mode write
        val base:SQLiteDatabase = appConfiguration.BD.writableDatabase

        //Create obj class ContentValues
        val filas = ContentValues()

        //add claves
        filas.put("Nombre", bean.nombre)
        filas.put("Apellido", bean.apellidos)
        filas.put("DNI", bean.dni)
        filas.put("Edad ", bean.edad)
        filas.put("Sexo", bean.sexo)
        filas.put("Telefono", bean.tlf)
        filas.put("Correo", bean.mail)
        filas.put("Clave", bean.clave)
        salida=base.insert("tb_paciente","IdPaciente", filas).toInt()


        return salida
    }

}