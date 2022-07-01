package com.example.proyecto_citasmedicas_dam1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.adapter.EspecialidadAdapter
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloEspecialidad

class ConsultarEspecialidadActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var rvEspecialidad: RecyclerView
    lateinit var btnBackMenuPE: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar_especialidad)

        rvEspecialidad = findViewById(R.id.rvEspecialidad)
        btnBackMenuPE = findViewById(R.id.btnBackMenuPE)
        btnBackMenuPE.setOnClickListener(this)

        var lista= ArregloEspecialidad().lista()
        var adaptador = EspecialidadAdapter(lista)

        rvEspecialidad.layoutManager = LinearLayoutManager(this)
        rvEspecialidad.adapter = adaptador
    }

    override fun onClick(v: View?) {
        if(v == btnBackMenuPE){
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}