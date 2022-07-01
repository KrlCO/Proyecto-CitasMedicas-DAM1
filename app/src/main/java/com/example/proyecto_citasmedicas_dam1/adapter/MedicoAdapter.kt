package com.example.proyecto_citasmedicas_dam1.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.MedicoActivity
import com.example.proyecto_citasmedicas_dam1.PacienteActivity
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
            //Toast.makeText(context, "probando", Toast.LENGTH_LONG).show()

            val ventana = AlertDialog.Builder(context)
            val data = LayoutInflater.from(context).inflate(R.layout.detalle_medico,null)
            ventana.setView(data)
            val dialog = ventana.create()

            var tvMedDetails: TextView = data.findViewById(R.id.tvMedDetails)
            var tvNomMDetails: TextView = data.findViewById(R.id.tvNomMDetails)
            var tvApeMDetails: TextView = data.findViewById(R.id.tvApeMDetails)
            var tvEspMDetail: TextView = data.findViewById(R.id.tvEspMDetails)
            var tvDirMDetails: TextView = data.findViewById(R.id.tvDirMDetails)
            var tvMailMDetails: TextView = data.findViewById(R.id.tvMailMDetails)
            var tvTlfMDetails: TextView = data.findViewById(R.id.tvTlfMDetails)
            var tvCidMDetails: TextView = data.findViewById(R.id.tvCidMDetails)

            tvMedDetails.text = info.get(position).cod.toString()
            tvNomMDetails.text = info.get(position).nombre
            tvApeMDetails.text = info.get(position).apellido
            tvEspMDetail.text = info.get(position).especialidad.toString()
            tvDirMDetails.text = info.get(position).direccion
            tvMailMDetails.text = info.get(position).correo
            tvTlfMDetails.text = info.get(position).telefono
            tvCidMDetails.text = info.get(position).cid

            dialog.show()
        }
/*
        holder.itemView.setOnClickListener{
            //Toast.makeText(context,"Funciona!", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, MedicoActivity::class.java)
            //crear clave para almacenar un objeto de la clase Paciente
            intent.putExtra("bean",info.get(position))
            ContextCompat.startActivity(context, intent, null)
        }*/
    }

    override fun getItemCount(): Int {
        return info.size
    }
}