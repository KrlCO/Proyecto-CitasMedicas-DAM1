package com.example.proyecto_citasmedicas_dam1.adapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.R

class VistaCita(item: View):RecyclerView.ViewHolder(item) {

    var tvCodC: TextView
    var tvEspc: TextView
    var tvMedicoC: TextView
    var tvCodPC: TextView
    var btnDetalleC: Button

    init {
        tvCodC = itemView.findViewById(R.id.tvCodC)
        tvEspc = itemView.findViewById(R.id.tvEspC)
        tvMedicoC = itemView.findViewById(R.id.tvMedicoC)
        tvCodPC = itemView.findViewById(R.id.tvCodPC)


        btnDetalleC = itemView.findViewById(R.id.btnDetalleC)
    }

}