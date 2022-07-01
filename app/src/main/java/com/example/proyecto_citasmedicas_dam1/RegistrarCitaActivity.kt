package com.example.proyecto_citasmedicas_dam1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloCita
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloEspecialidad
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloMedico
import com.example.proyecto_citasmedicas_dam1.models.Cita

class RegistrarCitaActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var spnEspCR: Spinner
    private lateinit var spnMedCR: Spinner
    private lateinit var edtPacienteCR: EditText
    private lateinit var edtFechaCR: EditText
    private lateinit var edtHoraCR: EditText
    private lateinit var edtDescCR: EditText

    private lateinit var btnSaveCR: Button
    private lateinit var btnBackCR: Button
    private lateinit var btnCCita: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_cita)

        spnEspCR = findViewById(R.id.spnEspCR)
        spnMedCR = findViewById(R.id.spnMedCR)
        edtPacienteCR = findViewById(R.id.edtPacienteCR)
        edtFechaCR = findViewById(R.id.edtFechaCR)
        edtHoraCR = findViewById(R.id.edtHoraCR)
        edtDescCR = findViewById(R.id.edtDescCR)

        btnSaveCR = findViewById(R.id.btnSaveCR)
        btnSaveCR.setOnClickListener(this)
        btnBackCR = findViewById(R.id.btnBackCR)
        btnBackCR.setOnClickListener(this)
        btnCCita = findViewById(R.id.btnCCita)
        btnCCita.setOnClickListener(this)

        muestraEspecialidades()
        muestraMedicos()

    }

    override fun onClick(v: View?) {
        if (v == btnSaveCR){

            var esp = spnEspCR.selectedItem.toString().toInt()
            var med = spnMedCR.selectedItem.toString().toInt()
            var pac = edtPacienteCR.text.toString().toInt()
            var fc = edtFechaCR.toString()
            var hh = edtHoraCR.toString()
            var des = edtDescCR.toString()

            var bean = Cita(0, esp,med,pac,fc,hh,des)

            var salida = ArregloCita().adicionar(bean)

            if (salida > 0)
                Toast.makeText(this,"Cita Generada", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Error al Crear", Toast.LENGTH_SHORT).show()

        }
         if (v == btnCCita) {

             var intent = Intent(this, ConsultarCitaActivity::class.java)
             startActivity(intent)
         }


         if(v == btnBackCR) {
             val intent = Intent(this, MenuActivity::class.java)
             startActivity(intent)
         }

    }

    fun muestraMedicos(){

        val data = ArregloMedico().lista()

        val medico = ArrayList<String>()

        for(bean in data)
            medico.add(bean.nombre)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1,medico)
        spnMedCR.adapter = adaptador



    }

    fun muestraEspecialidades(){

        val data = ArregloEspecialidad().lista()

        val especialidad = ArrayList<String>()

        for(bean in data)
            especialidad.add(bean.nombre)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1,especialidad)

        spnEspCR.adapter = adaptador




    }

}
