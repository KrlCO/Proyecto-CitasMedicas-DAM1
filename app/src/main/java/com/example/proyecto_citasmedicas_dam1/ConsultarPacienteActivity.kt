package com.example.proyecto_citasmedicas_dam1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.adapter.PacienteAdapter
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloPaciente

class ConsultarPacienteActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var rvPacienteConsult: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_paciente)
        rvPacienteConsult = findViewById(R.id.rvPacienteConsult)

        var lista = ArregloPaciente().listado()
        var adaptador = PacienteAdapter(lista)

        rvPacienteConsult.layoutManager = LinearLayoutManager(this)
        rvPacienteConsult.adapter = adaptador
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}