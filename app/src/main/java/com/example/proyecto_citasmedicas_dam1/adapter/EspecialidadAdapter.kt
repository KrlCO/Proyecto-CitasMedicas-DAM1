package com.example.proyecto_citasmedicas_dam1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.R
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloEspecialidad
import com.example.proyecto_citasmedicas_dam1.models.Especialidad

class EspecialidadAdapter(val info: ArrayList<Especialidad>): RecyclerView.Adapter<VistaEspecialidad>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaEspecialidad {

        var view=LayoutInflater.from(parent.context).inflate(R.layout.item_especialidad,parent,false)
        return VistaEspecialidad(view)
    }

    override fun onBindViewHolder(holder: VistaEspecialidad, position: Int) {
        //acceder a los atributos de la clase V
        holder.tvCodigoE.text=info.get(position).id.toString()
        holder.tvNombreE.text=info.get(position).nombre
        holder.tvDescE.text=info.get(position).descripcion
        //obtener context de la clase VistaDocente usando el parámetro holder
        //val context: Context =holder.itemView.context

    }

    override fun getItemCount(): Int {
        return info.size
    }
}