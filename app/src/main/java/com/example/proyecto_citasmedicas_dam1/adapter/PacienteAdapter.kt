package com.example.proyecto_citasmedicas_dam1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.R
import com.example.proyecto_citasmedicas_dam1.models.Paciente

class PacienteAdapter(val info:ArrayList<Paciente>): RecyclerView.Adapter<VistaPaciente>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaPaciente {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_paciente, parent, false)
        return  VistaPaciente(view)
    }

    override fun onBindViewHolder(holder: VistaPaciente, position: Int) {
        holder.tvCodP.text = info.get(position).codigo.toString()
        holder.tvNombreP.text = info.get(position).nombre
        holder.tvApep.text = info.get(position).apellidos
        holder.tvEdadP.text = info.get(position).edad.toString()
        holder.tvSexP.text = info.get(position).sexo
    }

    override fun getItemCount(): Int {
        return info.size
    }


}