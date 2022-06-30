package com.example.proyecto_citasmedicas_dam1.arreglo

import android.content.ContentValues
import com.example.proyecto_citasmedicas_dam1.models.Medico
import com.example.proyecto_citasmedicas_dam1.util.appConfiguration

class ArregloMedico {

    fun lista():ArrayList<Medico>{

        var data = ArrayList<Medico>()
        var base = appConfiguration.BD.readableDatabase
        var sql = "select * from tb_medico"
        var rs = base.rawQuery(sql, null)
        while (rs.moveToNext()){
            var bean = Medico(rs.getInt(0),rs.getString(1),rs.getString(2),rs.getInt(3),
            rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8))
            data.add(bean)
        }
        return data
    }

    fun adicionar(bean:Medico):Int{

        var salida:Int=-1
        var base = appConfiguration.BD.writableDatabase
        var claves = ContentValues()
        claves.put("Nombre", bean.nombre)
        claves.put("Apellido",bean.apellido)
        claves.put("IdEsp",bean.especialidad)
        claves.put("Direccion",bean.direccion)
        claves.put("Correo",bean.correo)
        claves.put("Telefono",bean.telefono)
        claves.put("sexo",bean.sexo)
        claves.put("cid",bean.cid)
        salida = base.insert("tb_medico", "IdMedico",claves).toInt()

        return salida
    }
}