package com.example.proyecto_citasmedicas_dam1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.R
import com.example.proyecto_citasmedicas_dam1.models.Cita

class CitaAdapter(val info:ArrayList<Cita>):RecyclerView.Adapter<VistaCita>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaCita {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.item_cita,parent, false)
        return VistaCita(view)
    }

    override fun onBindViewHolder(holder: VistaCita, position: Int) {

        holder.tvCodC.text = info.get(position).codigo.toString()
        holder.tvEspc.text = info.get(position).esp.toString()
        holder.tvMedicoC.text = info.get(position).doctor.toString()
        holder.tvCodPC.text = info.get(position).idpaciente.toString()
    }

    override fun getItemCount(): Int {
        return info.size
    }
}