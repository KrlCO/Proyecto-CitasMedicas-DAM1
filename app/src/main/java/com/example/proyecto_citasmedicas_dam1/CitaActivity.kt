package com.example.proyecto_citasmedicas_dam1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloCita
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloEspecialidad
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloMedico
import com.example.proyecto_citasmedicas_dam1.arreglo.ArregloPaciente
import com.example.proyecto_citasmedicas_dam1.models.Cita
import com.example.proyecto_citasmedicas_dam1.models.Especialidad
import com.example.proyecto_citasmedicas_dam1.models.Medico
import com.example.proyecto_citasmedicas_dam1.models.Paciente

class CitaActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var tvCodC:TextView
    private lateinit var spnEspC:Spinner
    private lateinit var spnMedicoC:Spinner
    private lateinit var spnCodPC: Spinner
    private lateinit var edtFechaPCita:EditText
    private lateinit var edtHoraACita:EditText
    private lateinit var edtDescACita:EditText
    private lateinit var btnActualizarCita:Button
    private lateinit var btnEliminarCita: Button
    private lateinit var btnRegresarCL: Button

    lateinit var datae:ArrayList<Especialidad>
    lateinit var datam: ArrayList<Medico>
    lateinit var datap: ArrayList<Paciente>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cita)

        tvCodC = findViewById(R.id.tvCodC)
        spnEspC = findViewById(R.id.spnEspCR)
        spnMedicoC = findViewById(R.id.spnMedCR)
        spnCodPC = findViewById(R.id.spnCodPC)
        edtFechaPCita = findViewById(R.id.edtFechaPCita)
        edtHoraACita = findViewById(R.id.edtHoraACita)
        edtDescACita = findViewById(R.id.edtDescACita)

        btnActualizarCita = findViewById(R.id.btnActualizarCita)
        btnActualizarCita.setOnClickListener(this)
        btnEliminarCita = findViewById(R.id.btnEliminarCita)
        btnEliminarCita.setOnClickListener(this)
        btnRegresarCL = findViewById(R.id.btnRegresarCL)
        btnRegresarCL.setOnClickListener(this)

        datos()

    }

    override fun onClick(v: View?) {

        if (v == btnActualizarCita){

            var codC = tvCodC.text.toString().toInt()
            var espc = datae.get(spnEspC.selectedItemPosition).id
            var docc = datam.get(spnMedicoC.selectedItemPosition).cod
            var pac = datap.get(spnCodPC.selectedItemPosition).codigo
            var fc = edtFechaPCita.toString()
            var hh = edtHoraACita.toString()
            var des = edtDescACita.toString()

            var bean = Cita(codC, espc, docc,pac,fc,hh,des)

            var salida = ArregloCita().adicionar(bean)


            if (salida > 0)
                Toast.makeText(this,"Cita Actualizada", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Error al Crear", Toast.LENGTH_SHORT).show()
        }
        if (v == btnEliminarCita){

            var salida = ArregloPaciente().deletePaciente(tvCodC.text.toString().toInt())

            if (salida > 0)
                Toast.makeText(this, "Cita Eliminada", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Error al Eliminar!", Toast.LENGTH_SHORT).show()

        }
        if (v == btnRegresarCL){
            var intent = Intent(this, ConsultarPacienteActivity::class.java)
            startActivity(intent)
        }

    }

    fun datos(){

        val bean = intent.getSerializableExtra("bean") as Cita

        tvCodC.setText(bean.codigo.toString())
        var espc = bean.esp

        val adapter = spnEspC.adapter
        var posEsp = -1

        for (i in 0 until adapter.count){
            if (adapter.getItem(i).equals(espc))
                posEsp = i
        }
        spnEspC.setSelection(posEsp)

        var med = bean.doctor

        val adapterM = spnMedicoC.adapter
        var posMed = -1

        for (i in 0 until adapterM.count){
            if (adapter.getItem(i).equals(espc))
                posMed = i
        }
        spnMedicoC.setSelection(posMed)

        var pa = bean.idpaciente

        val adapterP = spnCodPC.adapter
        var posPa = -1

        for (i in 0 until adapterM.count){
            if (adapter.getItem(i).equals(pa))
                posPa = i
        }
        spnCodPC.setSelection(posPa)

        edtFechaPCita.setText(bean.fecha)
        edtHoraACita.setText(bean.hora)
        edtDescACita.setText(bean.descripcion)
    }

    fun muestraMedicos(){

        datam = ArregloMedico().lista()

        val medico = ArrayList<String>()

        for(bean in datam)
            medico.add(bean.nombre)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1,medico)
        spnMedicoC.adapter = adaptador

    }

    fun muestraEspecialidades(){

        datae = ArregloEspecialidad().lista()

        val especialidad = ArrayList<String>()

        for(bean in datae)
            especialidad.add(bean.nombre)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1,especialidad)

        spnEspC.adapter = adaptador

    }

   fun muestraPacientes(){

        datap = ArregloPaciente().listado()

        val paciente = ArrayList<String>()

        for(bean in datap)
            paciente.add(bean.nombre)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1,paciente)
        spnCodPC.adapter = adaptador

    }

}