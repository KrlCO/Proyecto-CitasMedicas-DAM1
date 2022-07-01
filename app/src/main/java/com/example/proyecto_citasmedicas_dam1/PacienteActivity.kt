package com.example.proyecto_citasmedicas_dam1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloPaciente
import com.example.proyecto_citasmedicas_dam1.models.Paciente

class PacienteActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var tvCodigoPA: TextView
    private lateinit var edtNombrePA: EditText
    private lateinit var edtApellidosPA: EditText
    private lateinit var edtDNIAc: EditText
    private lateinit var edtEdadPA:EditText
    private lateinit var spnSexoPacienteA: Spinner
    private lateinit var edtTelefonoPA: EditText
    private lateinit var edtMailPA: EditText
    private lateinit var edtPassPA: EditText
    private lateinit var btnActualizaPaciente: Button
    private lateinit var btnEliminaPaciente: Button
    private lateinit var btnRegresarLista: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paciente)

        tvCodigoPA = findViewById(R.id.tvCodigoPA)
        edtNombrePA = findViewById(R.id.edtNombrePA)
        edtApellidosPA = findViewById(R.id.edtApellidosPA)
        edtDNIAc = findViewById(R.id.edtDNIAc)
        edtEdadPA = findViewById(R.id.edtEdadPA)
        spnSexoPacienteA = findViewById(R.id.spnSexoPacienteA)
        edtTelefonoPA = findViewById(R.id.edtTelefonoPA)
        edtMailPA = findViewById(R.id.edtMailPA)
        edtPassPA = findViewById(R.id.edtPassPA)

        btnActualizaPaciente = findViewById(R.id.btnActualizaPaciente)
        btnActualizaPaciente.setOnClickListener(this)
        btnEliminaPaciente = findViewById(R.id.btnEliminaPaciente)
        btnEliminaPaciente.setOnClickListener(this)
        btnRegresarLista = findViewById(R.id.btnRegresarLista)
        btnRegresarLista.setOnClickListener(this)

        datos()

    }

    override fun onClick(v: View?) {

        if (v == btnActualizaPaciente){

            var cod = tvCodigoPA.text.toString().toInt()
            var nom = edtNombrePA.text.toString()
            var ape = edtApellidosPA.text.toString()
            var dni = edtDNIAc.text.toString()
            var edad = edtEdadPA.text.toString().toInt()
            var sex = spnSexoPacienteA.selectedItem.toString()
            var tlf = edtTelefonoPA.text.toString()
            var mail = edtMailPA.text.toString()
            var pass = edtPassPA.text.toString()

            val r1 = Regex("([a-zA-Z]{3,30}\\s*)+")
            val r2 = Regex("([a-zA-Z]{3,30}\\s*)+")
            val r3 = Regex("[0-9]{8}")
            val r4 = Regex("\\d{2}")
            val r5 = Regex("[0-9]{9}")
            val r6 = Regex("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
            val r8 = Regex("[1-9]")

            if (r1.matches(nom)==false){
                Toast.makeText(this, "El Nombre solo puede tener 3 - 30 letras", Toast.LENGTH_LONG).show()
                edtNombrePA.requestFocus()
            }
            else if (r2.matches(ape) == false){
                Toast.makeText(this, "Los Apellidos solo puede tener 3 - 30 letras", Toast.LENGTH_LONG).show()
                edtApellidosPA.requestFocus()
            }else if (r3.matches(dni) == false){
                Toast.makeText(this, "El DNI solo puede tener 8 digitos", Toast.LENGTH_LONG).show()
                edtDNIAc.requestFocus()
            }
            else if (r4.matches(edad.toString()) == false){
                Toast.makeText(this, "La edad solo puede ser de 2 digitos", Toast.LENGTH_LONG).show()
                edtEdadPA.requestFocus()
            }else if (r5.matches(tlf) == false){
                Toast.makeText(this, "El telefono solo puede tener 9 Caracteres", Toast.LENGTH_LONG).show()
                edtTelefonoPA.requestFocus()
            }else if (r6.matches(mail) == false){
                Toast.makeText(this, "El correo solo puede tener 30 Caracteres", Toast.LENGTH_LONG).show()
                edtMailPA.requestFocus()
            }
            else{
                var bean = Paciente(cod,nom,ape,dni,edad,sex,tlf,mail,pass)

                var salida = ArregloPaciente().updatePaciente(bean)

                if (salida > 0)
                    Toast.makeText(this, "Paciente Actualizado", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "Error al Actualizar!", Toast.LENGTH_SHORT).show()
            }

        }

        if (v == btnEliminaPaciente){

            var salida = ArregloPaciente().deletePaciente(tvCodigoPA.text.toString().toInt())

            if (salida > 0)
                Toast.makeText(this, "Paciente Borrado", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Error al Eliminar!", Toast.LENGTH_SHORT).show()

        }
        if (v == btnRegresarLista){
            var intent = Intent(this, ConsultarPacienteActivity::class.java)
            startActivity(intent)
        }


    }

    fun datos(){

        val bean = intent.getSerializableExtra("bean") as Paciente

        tvCodigoPA.setText(bean.codigo.toString())
        edtNombrePA.setText(bean.nombre)
        edtApellidosPA.setText(bean.apellidos)
        edtDNIAc.setText(bean.dni)
        edtEdadPA.setText(bean.edad.toString())
        var sexo = bean.sexo

        val adapter = spnSexoPacienteA.adapter

        var posSexo = -1

        for (i in 0 until adapter.count){
            if (adapter.getItem(i).equals(sexo))
            posSexo = i
        }
        spnSexoPacienteA.setSelection(posSexo)
        edtTelefonoPA.setText(bean.tlf)
        edtMailPA.setText(bean.mail)
        edtPassPA.setText(bean.clave)

    }
}