package com.example.proyecto_citasmedicas_dam1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.adapter.EspecialidadAdapter
import com.example.proyecto_citasmedicas_dam1.adapter.VistaEspecialidad
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloEspecialidad

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}