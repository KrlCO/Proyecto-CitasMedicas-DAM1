package com.example.proyecto_citasmedicas_dam1.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.CitaActivity
import com.example.proyecto_citasmedicas_dam1.PacienteActivity
import com.example.proyecto_citasmedicas_dam1.R
import com.example.proyecto_citasmedicas_dam1.models.Cita

class CitaAdapter(val info:ArrayList<Cita>):RecyclerView.Adapter<VistaCita>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaCita {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cita,parent, false)
        return VistaCita(view)
    }

    override fun onBindViewHolder(holder: VistaCita, position: Int) {

        holder.tvCodC.text = info.get(position).codigo.toString()
        holder.tvEspc.text = info.get(position).esp.toString()
        holder.tvMedicoC.text = info.get(position).doctor.toString()
        holder.tvCodPC.text = info.get(position).idpaciente.toString()

        val context: Context = holder.itemView.context

        holder.itemView.setOnClickListener{
            //Toast.makeText(context,"Funciona!", Toast.LENGTH_SHORT).show()
             val intent = Intent(context, CitaActivity::class.java)
             //crear clave para almacenar un objeto de la clase Paciente
             intent.putExtra("bean",info.get(position))
             ContextCompat.startActivity(context, intent, null)
        }

    }



    override fun getItemCount(): Int {
        return info.size
    }
}