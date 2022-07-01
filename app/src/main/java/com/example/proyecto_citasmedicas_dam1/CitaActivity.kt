package com.example.proyecto_citasmedicas_dam1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.example.proyecto_citasmedicas_dam1.models.Cita

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cita)

        tvCodC = findViewById(R.id.tvCodC)
        spnEspC = findViewById(R.id.tvEspC)
        spnMedicoC = findViewById(R.id.tvMedicoC)
        spnCodPC = findViewById(R.id.tvCodPC)
        edtFechaPCita = findViewById(R.id.edtFechaPCita)
        edtHoraACita = findViewById(R.id.edtHoraACita)
        edtDescACita = findViewById(R.id.edtDescACita)

        btnActualizarCita = findViewById(R.id.btnActualizarCita)
        btnActualizarCita.setOnClickListener(this)
        btnEliminarCita = findViewById(R.id.btnEliminarCita)
        btnEliminarCita.setOnClickListener(this)
        btnRegresarCL = findViewById(R.id.btnRegresarCL)
        btnRegresarCL.setOnClickListener(this)


    }

    override fun onClick(v: View?) {

        if (v == btnActualizarCita){

            var codC = tvCodC.text.toString().toInt()
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

}