package com.example.proyecto_citasmedicas_dam1.adapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.R

class VistaPaciente(item: View):RecyclerView.ViewHolder(item) {

    var tvCodP: TextView
    var tvNombreP: TextView
    var tvApep: TextView
    var tvEdadP: TextView
    var tvSexP: TextView
    var btnDetallesP: Button

    init {
        tvCodP = itemView.findViewById(R.id.tvCodigoPA)
        tvNombreP = itemView.findViewById((R.id.tvNombreP))
        tvApep = itemView.findViewById(R.id.tvApeP)

        tvEdadP = itemView.findViewById(R.id.tvEdadP)
        tvSexP = itemView.findViewById(R.id.tvSexP)

        btnDetallesP = itemView.findViewById(R.id.btnRegresarLista)

    }

}