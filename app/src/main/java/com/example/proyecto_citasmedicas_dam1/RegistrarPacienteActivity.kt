package com.example.proyecto_citasmedicas_dam1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloPaciente
import com.example.proyecto_citasmedicas_dam1.models.Paciente

class RegistrarPacienteActivity : AppCompatActivity(),View.OnClickListener {
   private lateinit var edtNombrePR:EditText
   private lateinit var edtApellidosPR:EditText
   private lateinit var edtDniPR:EditText
   private lateinit var edtEdadPR:EditText
   private lateinit var edtSexoPR:EditText
   private lateinit var edtTelefonoPR:EditText
   private lateinit var edtCorreoPR:EditText
   private lateinit var edtPassPR:EditText

   private lateinit var btnGuardarPR:Button
   private lateinit var btnRegresarPR:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_paciente)

        edtNombrePR = findViewById(R.id.edtNombrePR)
        edtApellidosPR = findViewById(R.id.edtApellidosPR)
        edtDniPR = findViewById(R.id.edtDniPR)
        edtEdadPR = findViewById(R.id.edtEdadPR)
        edtSexoPR = findViewById(R.id.edtSexoPR)
        edtTelefonoPR = findViewById(R.id.edtTelefonoPR)
        edtCorreoPR = findViewById(R.id.edtCorreoPR)
        edtPassPR = findViewById(R.id.edtPassPR)

        btnGuardarPR = findViewById(R.id.btnGuardarPR)
        btnGuardarPR.setOnClickListener(this)
        btnRegresarPR = findViewById(R.id.btnRegresarPR)
        btnRegresarPR.setOnClickListener(this)



    }

    override fun onClick(v: View?) {
        if (v==btnGuardarPR){
            var nom = edtNombrePR.text.toString()
            var ape = edtApellidosPR.text.toString()
            var dni = edtDniPR.text.toString()
            var edad = edtEdadPR.text.toString().toInt()
            var sex = edtSexoPR.text.toString()
            var tlf = edtTelefonoPR.text.toString()
            var mail = edtCorreoPR.text.toString()
            var pass = edtPassPR.text.toString()

            var bean = Paciente(0,nom,ape,dni,edad,sex,tlf,mail,pass)

            var salida = ArregloPaciente().adicionar(bean)

            if (salida > 0)
                Toast.makeText(this, "Paciente Registrado", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Erro al Registar", Toast.LENGTH_SHORT).show()



        }
        if (v == btnRegresarPR){
            var intent = Intent(this, ConsultarPacienteActivity::class.java)
            startActivity(intent)
        }
    }
}