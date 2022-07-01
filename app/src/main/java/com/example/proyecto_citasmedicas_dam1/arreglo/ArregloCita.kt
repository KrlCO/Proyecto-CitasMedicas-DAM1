package com.example.proyecto_citasmedicas_dam1.arreglo

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.example.proyecto_citasmedicas_dam1.models.Cita
import com.example.proyecto_citasmedicas_dam1.util.appConfiguration

class ArregloCita {

    fun lista():ArrayList<Cita>{
        var data = ArrayList<Cita>()
        var base = appConfiguration.BD.readableDatabase
        var sql = "select * from tb_cita"
        var rs = base.rawQuery(sql, null)
        while (rs.moveToNext()){

            var bean = Cita(rs.getInt(0),rs.getInt(1),rs.getInt(2),rs.getInt(3), rs.getString(4),
            rs.getString(5),rs.getString(6))
            data.add(bean)
        }
        return data
    }

    fun adicionar(bean:Cita):Int{
        var salida=-1
        val base: SQLiteDatabase = appConfiguration.BD.writableDatabase

        var claves = ContentValues()
        claves.put("IdEsp", bean.esp)
        claves.put("IdMedico",bean.doctor)
        claves.put("IdPaciente",bean.idpaciente)
        claves.put("Fecha",bean.fecha)
        claves.put("Hora",bean.hora)
        claves.put("Descripcion",bean.descripcion)
        salida = base.insert("tb_cita", "IdCita",claves).toInt()

        return salida
    }

}