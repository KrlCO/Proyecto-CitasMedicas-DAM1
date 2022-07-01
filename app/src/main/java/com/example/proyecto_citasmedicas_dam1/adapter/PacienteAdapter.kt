package com.example.proyecto_citasmedicas_dam1.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_citasmedicas_dam1.PacienteActivity
import com.example.proyecto_citasmedicas_dam1.R
import com.example.proyecto_citasmedicas_dam1.models.Paciente

class PacienteAdapter(val info:ArrayList<Paciente>): RecyclerView.Adapter<VistaPaciente>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaPaciente {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_paciente, parent, false)
        return  VistaPaciente(view)
    }

    override fun onBindViewHolder(holder: VistaPaciente, position: Int) {
        //Accediendo a los atributos de la Clase VistaPaciente
        holder.tvCodP.text = info.get(position).codigo.toString()
        holder.tvNombreP.text = info.get(position).nombre
        holder.tvApep.text = info.get(position).apellidos
        holder.tvEdadP.text = info.get(position).edad.toString()
        holder.tvSexP.text = info.get(position).sexo

        val context:Context = holder.itemView.context

        //Asignando event cliclk to botton btnDetalle
        holder.btnDetallesP.setOnClickListener{
            //Toast.makeText(context,"prueba", Toast.LENGTH_SHORT).show()

            //Create Window to Dialog
           val  ventana = AlertDialog.Builder(context)
            //Objeto de tipo View que infla el Activity "detaller_paciente"
            val data =LayoutInflater.from(context).inflate(R.layout.detalle_paciente, null)
            //adicionar dentro del objeto "ventana" la vista "data"
            ventana.setView(data)
            val dialog = ventana.create()


            var tvCodPDetails: TextView = data.findViewById(R.id.tvCodPDetails)
            var tvNomPDetails: TextView = data.findViewById(R.id.tvNomPDetails)
            var tvApePDetails: TextView = data.findViewById(R.id.tvApePDetails)
            var tvDniPD: TextView = data.findViewById(R.id.tvDniPD)
            var tvEdadPDetails: TextView = data.findViewById(R.id.tvEdadPDetails)
            var tvSexoPDetails: TextView = data.findViewById(R.id.tvSexoPDetails)
            var tvFonoPDetails: TextView = data.findViewById(R.id.tvFonoPDetails)
            var tvCorreoPDetails: TextView = data.findViewById(R.id.tvCorreoPDetails)
            var tvPassPDetails: TextView = data.findViewById(R.id.tvPassPDetails)

            tvCodPDetails.text = info.get(position).codigo.toString()
            tvNomPDetails.text = info.get(position).nombre
            tvApePDetails.text = info.get(position).apellidos
            tvDniPD.text = info.get(position).dni
            tvEdadPDetails.text = info.get(position).edad.toString()
            tvSexoPDetails.text = info.get(position).sexo
            tvFonoPDetails.text = info.get(position).tlf
            tvCorreoPDetails.text = info.get(position).mail
            tvPassPDetails.text = info.get(position).clave


            //show Dialog
            dialog.show()
        }
        //Asignando event click to CardView of Paciente
        holder.itemView.setOnClickListener{
            //Toast.makeText(context,"Funciona!", Toast.LENGTH_SHORT).show()
            val intent = Intent(context,PacienteActivity::class.java)
            //crear clave para almacenar un objeto de la clase Paciente
            intent.putExtra("bean",info.get(position))
            ContextCompat.startActivity(context, intent, null)
        }


    }

    override fun getItemCount(): Int {
        return info.size
    }


}