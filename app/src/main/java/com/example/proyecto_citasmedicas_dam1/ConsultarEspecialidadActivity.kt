package com.example.proyecto_citasmedicas_dam1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.adapter.EspecialidadAdapter
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloEspecialidad

class ConsultarEspecialidadActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var rvEspecialidad: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_especialidad)
        rvEspecialidad = findViewById(R.id.rvEspecialidad)

        var lista= ArregloEspecialidad().lista()
        var adaptador = EspecialidadAdapter(lista)

        rvEspecialidad.layoutManager = LinearLayoutManager(this)
        rvEspecialidad.adapter = adaptador
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}