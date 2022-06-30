package com.example.proyecto_citasmedicas_dam1.arreglo

import android.content.ContentValues
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.R
import com.example.proyecto_citasmedicas_dam1.models.Especialidad
import com.example.proyecto_citasmedicas_dam1.util.appConfiguration

class ArregloEspecialidad {

    fun lista():ArrayList<Especialidad>{
        var data = ArrayList<Especialidad>()
        var base = appConfiguration.BD.readableDatabase
        var sql ="select * from tb_especialidad"
        var rs = base.rawQuery(sql, null)
        while (rs.moveToNext()){
            var bean = Especialidad(rs.getInt(0), rs.getString(1), rs.getString(2))
            data.add(bean)

        }
        return data
    }

    fun adicionar(bean:Especialidad):Int{
        var salida:Int=-1
        var base = appConfiguration.BD.writableDatabase
        var claves = ContentValues()
        claves.put("esp_nom", bean.nombre)
        claves.put("esp_desc", bean.descripcion)
        salida = base.insert("tb_especialidad", "IdEsp",claves).toInt()

        return salida
    }



}