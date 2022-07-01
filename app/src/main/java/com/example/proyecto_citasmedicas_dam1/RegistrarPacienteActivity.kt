package com.example.proyecto_citasmedicas_dam1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloPaciente
import com.example.proyecto_citasmedicas_dam1.models.Paciente

class RegistrarPacienteActivity : AppCompatActivity(),View.OnClickListener {
   private lateinit var edtNombrePR:EditText
   private lateinit var edtApellidosPR:EditText
   private lateinit var edtDniPR:EditText
   private lateinit var edtEdadPR:EditText
   private lateinit var spSexoPR:Spinner
   private lateinit var edtTelefonoPR:EditText
   private lateinit var edtCorreoPR:EditText
   private lateinit var edtPassPR:EditText

   private lateinit var btnGuardarPR:Button
   private lateinit var btnRegresarPR:Button
   private lateinit var btnCPaciente: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_paciente)

        edtNombrePR = findViewById(R.id.edtNombrePR)
        edtApellidosPR = findViewById(R.id.edtApellidosPR)
        edtDniPR = findViewById(R.id.edtDniPR)
        edtEdadPR = findViewById(R.id.edtEdadPR)
        spSexoPR = findViewById(R.id.spSexoPR)
        edtTelefonoPR = findViewById(R.id.edtTelefonoPR)
        edtCorreoPR = findViewById(R.id.edtCorreoPR)
        edtPassPR = findViewById(R.id.edtPassPR)

        btnGuardarPR = findViewById(R.id.btnGuardarPR)
        btnGuardarPR.setOnClickListener(this)
        btnRegresarPR = findViewById(R.id.btnRegresarPR)
        btnRegresarPR.setOnClickListener(this)
        btnCPaciente = findViewById(R.id.btnCPaciente)
        btnCPaciente.setOnClickListener(this)



    }

    override fun onClick(v: View?) {
        if (v==btnGuardarPR){
            var nom = edtNombrePR.text.toString()
            var ape = edtApellidosPR.text.toString()
            var dni = edtDniPR.text.toString()
            var edad = edtEdadPR.text.toString().toInt()
            var sex = spSexoPR.selectedItem.toString()
            var tlf = edtTelefonoPR.text.toString()
            var mail = edtCorreoPR.text.toString()
            var pass = edtPassPR.text.toString()


            val r1 = Regex("([a-zA-Z]{3,30}\\s*)+")
            val r2 = Regex("([a-zA-Z]{3,30}\\s*)+")
            val r3 = Regex("[0-9]{8}")
            val r4 = Regex("\\d{2}")
            val r5 = Regex("[0-9]{9}")
            val r6 = Regex("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
            val r8 = Regex("[1-9]")

                if (r1.matches(nom)==false){
                    Toast.makeText(this, "El Nombre solo puede tener 3 - 30 letras", Toast.LENGTH_LONG).show()
                    edtNombrePR.requestFocus()
                }
                else if (r2.matches(ape) == false){
                    Toast.makeText(this, "Los Apellidos solo puede tener 3 - 30 letras", Toast.LENGTH_LONG).show()
                    edtApellidosPR.requestFocus()
                }else if (r3.matches(dni) == false){
                    Toast.makeText(this, "El DNI solo puede tener 8 digitos", Toast.LENGTH_LONG).show()
                    edtDniPR.requestFocus()
                }
                else if (r4.matches(edad.toString()) == false){
                    Toast.makeText(this, "La edad solo puede ser de 2 digitos", Toast.LENGTH_LONG).show()
                    edtEdadPR.requestFocus()
                }else if (r5.matches(tlf) == false){
                    Toast.makeText(this, "El telefono solo puede tener 9 Caracteres", Toast.LENGTH_LONG).show()
                    edtTelefonoPR.requestFocus()
                }else if (r6.matches(mail) == false){
                    Toast.makeText(this, "El correo solo puede tener 30 Caracteres", Toast.LENGTH_LONG).show()
                    edtCorreoPR.requestFocus()
                }

            else{

                var bean = Paciente(0,nom,ape,dni,edad,sex,tlf,mail,pass)

                var salida = ArregloPaciente().adicionar(bean)

                if (salida > 0)
                    Toast.makeText(this, "Paciente Registrado", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "Erro al Registar", Toast.LENGTH_SHORT).show()

            }

        }
        if (v == btnCPaciente){
            var intent = Intent(this, ConsultarPacienteActivity::class.java)
            startActivity(intent)
        }
        if (v == btnRegresarPR){
            var intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}