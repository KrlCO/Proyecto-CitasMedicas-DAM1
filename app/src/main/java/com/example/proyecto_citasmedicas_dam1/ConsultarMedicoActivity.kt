package com.example.proyecto_citasmedicas_dam1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.adapter.MedicoAdapter
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloEspecialidad
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloMedico
import com.example.proyecto_citasmedicas_dam1.models.Medico

class ConsultarMedicoActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var rvMedico: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_medico)
        rvMedico = findViewById(R.id.rvMedico)

        var lista = ArregloMedico().lista()
        var adaptador = MedicoAdapter(lista)

        rvMedico.layoutManager = LinearLayoutManager(this)
        rvMedico.adapter = adaptador

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}