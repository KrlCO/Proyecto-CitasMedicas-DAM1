package com.example.proyecto_citasmedicas_dam1.adapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.R

class VistaEspecialidad(item: View): RecyclerView.ViewHolder(item) {

    var tvCodigoE: TextView
    var tvNombreE: TextView
    var tvDescE: TextView

    //Block for init
    init {

        //references attributes with controls form activity  "item_especialidad"
        tvCodigoE = itemView.findViewById(R.id.tvCodigoE)
        tvNombreE = itemView.findViewById(R.id.tvNombreE)
        tvDescE = itemView.findViewById(R.id.tvDescE)
    }
}