package com.example.proyecto_citasmedicas_dam1.adapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.R

class VistaMedico(itemView: View): RecyclerView.ViewHolder(itemView) {

    var tvCodigoMI: TextView
    var tvNombreMI: TextView
    var tvApellidoMI: TextView
    var tvEspecialidadMI: TextView
    var tvCidMI: TextView
    var btnDetalleMedico: Button

    init {
        tvCodigoMI = itemView.findViewById(R.id.tvCodigoMI)
        tvNombreMI = itemView.findViewById((R.id.tvNombreMI))
        tvApellidoMI = itemView.findViewById(R.id.tvApellidoMI)
        tvEspecialidadMI = itemView.findViewById(R.id.tvEspecialidadMI)
        tvCidMI = itemView.findViewById(R.id.tvCidMI)

        btnDetalleMedico = itemView.findViewById(R.id.btnDetalleMedico)


    }

}