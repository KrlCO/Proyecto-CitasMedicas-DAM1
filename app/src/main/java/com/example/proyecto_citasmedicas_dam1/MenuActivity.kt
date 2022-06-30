package com.example.proyecto_citasmedicas_dam1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MenuActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var btnCitas:Button
    private lateinit var btnPacientes:Button
    private lateinit var btnMedicos:Button
    private lateinit var btnEspecialidades:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        btnCitas = findViewById(R.id.btnCitas)
        btnCitas.setOnClickListener(this)
        btnPacientes = findViewById(R.id.btnPacientes)
        btnPacientes.setOnClickListener(this)
        btnMedicos = findViewById(R.id.btnMedicos)
        btnMedicos.setOnClickListener(this)
        btnEspecialidades = findViewById(R.id.btnEspecialidades)
        btnEspecialidades.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v==btnCitas){
            val intent = Intent(this, RegistrarCitaActivity::class.java)
            startActivity(intent)
        }
        if (v==btnPacientes){
            val intent = Intent(this, RegistrarPacienteActivity::class.java)
            startActivity(intent)
        }
        if (v==btnMedicos){
            val intent = Intent(this, ConsultarMedicoActivity::class.java)
            startActivity(intent)
        }
        if (v==btnEspecialidades){
            val intent = Intent(this, ConsultarEspecialidadActivity::class.java)
            startActivity(intent)
        }
    }
}