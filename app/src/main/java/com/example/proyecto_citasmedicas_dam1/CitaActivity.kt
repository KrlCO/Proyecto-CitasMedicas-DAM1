package com.example.proyecto_citasmedicas_dam1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class CitaActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var tvCodC:TextView
    private lateinit var tvEspC:TextView
    private lateinit var tvMedicoC: TextView
    private lateinit var tvCodPC: TextView
    private lateinit var btnActualizarCita:Button
    private lateinit var btnEliminarCita: Button
    private lateinit var btnRegresarCL: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cita)

        tvCodC = findViewById(R.id.tvCodC)
        tvEspC = findViewById(R.id.tvEspC)
        tvMedicoC = findViewById(R.id.tvMedicoC)
        tvCodPC = findViewById(R.id.tvCodPC)

        btnActualizarCita = findViewById(R.id.btnActualizarCita)
        btnActualizarCita.setOnClickListener(this)
        btnEliminarCita = findViewById(R.id.btnEliminarCita)
        btnEliminarCita.setOnClickListener(this)
        btnRegresarCL = findViewById(R.id.btnRegresarCL)
        btnRegresarCL.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}