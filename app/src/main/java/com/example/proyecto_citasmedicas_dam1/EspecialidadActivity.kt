package com.example.proyecto_citasmedicas_dam1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.adapter.EspecialidadAdapter
import com.example.proyecto_citasmedicas_dam1.api.ApiServer
import com.example.proyecto_citasmedicas_dam1.models.Especialidad
import com.example.proyecto_citasmedicas_dam1.util.ApiUtils
import com.example.proyecto_citasmedicas_dam1.util.appConfiguration
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EspecialidadActivity : AppCompatActivity(), View.OnClickListener  {
    lateinit var btnAgregar: Button
    lateinit var btnConsultar: Button
    lateinit var rvposMedicamento: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_especialidad)

        rvposMedicamento=findViewById(R.id.rgvEspecialista)

        btnAgregar=findViewById(R.id.btnAgregarEspecialidad)
        btnConsultar=findViewById(R.id.btnConsultarEspecialidad)

        btnAgregar.setOnClickListener(this)
        btnConsultar.setOnClickListener(this)

        //listarEspecialidad()

    }

    override fun onClick(v: View?) {
        if(v==btnAgregar){
            var intent= Intent(this,RegistrarEspecialidadActivity::class.java)
            startActivity(intent)
        }else{
            val intent= Intent(this,ConsultarEspecialidadActivity::class.java)
            startActivity(intent)
        }
    }

   /* fun listarEspecialidad(){
        api.listarEspecialidad().enqueue(object: Callback<List<Especialidad>> {
            override fun onResponse(call: Call<List<Especialidad>>, response: Response<List<Especialidad>>) {

                var lista=response.body()

                val adaptador=EspecialidadAdapter(lista!!)

                rvposMedicamento.layoutManager= LinearLayoutManager(appConfiguration.CONTEXT)

                rvposMedicamento.adapter=adaptador
            }

            override fun onFailure(call: Call<List<Especialidad>>, t: Throwable) {
                Log.d("Error ",t.message!!)
            }
        })
    }*/

}