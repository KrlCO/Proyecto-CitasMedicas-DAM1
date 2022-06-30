package com.example.proyecto_citasmedicas_dam1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.R
import com.example.proyecto_citasmedicas_dam1.models.Medico

class MedicoAdapter(val info: ArrayList<Medico>): RecyclerView.Adapter<VistaMedico>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaMedico {

        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_medico, parent, false )
        return VistaMedico(vista)
    }

    override fun onBindViewHolder(holder: VistaMedico, position: Int) {
        holder.tvCodigoMI.text = info.get(position).cod.toString()
        holder.tvNombreMI.text = info.get(position).nombre
        holder.tvApellidoMI.text = info.get(position).apellido
        holder.tvEspecialidadMI.text = info.get(position).especialidad.toString()
        holder.tvCidMI.text = info.get(position).cid

        //Get context form class VistaEspecialidad using parameter holder
        val context: Context = holder.itemView.context

        //Asignando event click to button DETALLE
        holder.btnDetalleMedico.setOnClickListener{
            Toast.makeText(context, "probando", Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return info.size
    }
}