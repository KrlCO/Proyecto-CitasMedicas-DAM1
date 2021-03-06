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
import com.example.proyecto_citasmedicas_dam1.models.Especialidad
import com.example.proyecto_citasmedicas_dam1.models.Medico

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

    lateinit var datae:ArrayList<Especialidad>
    lateinit var datam: ArrayList<Medico>

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


            var pac = edtPacienteCR.text.toString().toInt()
            var fc = edtFechaCR.toString()
            var hh = edtHoraCR.toString()
            var des = edtDescCR.toString()
            //obetner codigo de la Especialidad seleccionada
            var codEsp=datae.get(spnEspCR.selectedItemPosition).id
            //Get Id from Medico selected
            var idMed = datam.get(spnMedCR.selectedItemPosition).cod


                val r1 = Regex("[a-zA-Z][0-9][0-9][0-9][0-9]{3,30}")
                val r2 = Regex("[a-zA-Z]{3,30}")
                val r3 = Regex("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")
                val r4 = Regex("[1-9]")

                if (r1.matches(des)==false){
                    Toast.makeText(this, "La Descripcion: Minimo 3 - Maximo 30 Letras", Toast.LENGTH_LONG).show()
                    edtDescCR.requestFocus()
                }
                else{

                    var bean = Cita(0, codEsp,idMed,pac,fc,hh,des)

                    var salida = ArregloCita().adicionar(bean)


                    if (salida > 0)
                        Toast.makeText(this,"Cita Generada", Toast.LENGTH_SHORT).show()
                    else
                        Toast.makeText(this,"Error al Crear", Toast.LENGTH_SHORT).show()

                }

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

        datam = ArregloMedico().lista()

        val medico = ArrayList<String>()

        for(bean in datam)
            medico.add(bean.nombre)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1,medico)
        spnMedCR.adapter = adaptador



    }

    fun muestraEspecialidades(){

        datae = ArregloEspecialidad().lista()

        val especialidad = ArrayList<String>()

        for(bean in datae)
            especialidad.add(bean.nombre)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1,especialidad)

        spnEspCR.adapter = adaptador




    }

}
