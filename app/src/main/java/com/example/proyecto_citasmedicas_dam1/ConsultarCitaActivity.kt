package com.example.proyecto_citasmedicas_dam1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.adapter.CitaAdapter
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloCita

class ConsultarCitaActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var rvCitaConsult: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_cita)
        rvCitaConsult = findViewById(R.id.rvCitaConsult)

        var lista = ArregloCita().lista()
        var adaptador = CitaAdapter(lista)

        rvCitaConsult.layoutManager = LinearLayoutManager(this)
        rvCitaConsult.adapter = adaptador

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}