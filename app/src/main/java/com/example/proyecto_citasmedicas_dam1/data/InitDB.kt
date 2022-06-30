package com.example.proyecto_citasmedicas_dam1.data

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.proyecto_citasmedicas_dam1.util.appConfiguration

class InitDB: SQLiteOpenHelper(appConfiguration.CONTEXT, appConfiguration.BASE, null, appConfiguration.VERSION) {
    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL("create table tb_especialidad(" +
                "IdEsp Integer primary key autoincrement,"+
                "esp_nom varchar (120),"+
                "esp_desc varchar (160))")

        db.execSQL("insert into tb_especialidad values(null,'Otorinolaringologia','Horaio atencion L-V de 8:00am-5:00pm')")
        db.execSQL("insert into tb_especialidad values(null,'Rehabilitación y Terapia fisica','Horaio atencion L-V de 8:00am-5:00pm')")
        db.execSQL("insert into tb_especialidad values(null,'Pediatria','Horaio atencion L-V de 8:00am-5:00pm')")
        db.execSQL("insert into tb_especialidad values(null,'Ginecología Obstetricia','Horaio atencion L-V de 8:00am-5:00pm')")
        db.execSQL("insert into tb_especialidad values(null,'Medicina Interna','Horaio atencion L-V de 8:00am-5:00pm')")
        db.execSQL("insert into tb_especialidad values(null,'Cirugia General','Horaio atencion L-V de 8:00am-5:00pm')")
        db.execSQL("insert into tb_especialidad values(null,'Traumatologoía','Horaio atencion L-V de 8:00am-5:00pm')")
        db.execSQL("insert into tb_especialidad values(null,'Cardiología','Horaio atencion L-V de 8:00am-5:00pm')")
        db.execSQL("insert into tb_especialidad values(null,'Neurología','Horaio atencion L-V de 8:00am-5:00pm')")
        db.execSQL("insert into tb_especialidad values(null,'Psiquiatria','Horaio atencion L-V de 8:00am-5:00pm')")


        db.execSQL("create table tb_paciente(" +
                "IdPaciente Integer primary key autoincrement,"+
                "Nombre varchar (120),"+
                "Apellido varchar (120),"+
                "DNI char (8),"+
                "Edad Integer,"+
                "Sexo char(2),"+
                "Telefono char(9),"+
                "Correo varchar (120),"+
                "Clave varchar (160))")

        db.execSQL("insert into tb_paciente values(null,'Karen','Mendoza Lozano', '78677854', 30, 'F', '987534256', 'efafsfaef@gmail.com', "+
                "'12345')")
        db.execSQL("insert into tb_paciente values(null,'Emma','Magnolia', '38677854', 28, 'F', '908645356', 'zsdads@gmail.com', "+
                "'12345')")

        db.execSQL("create table tb_medico(" +
                "IdMedico Integer primary key autoincrement,"+
                "Nombre varchar (120),"+
                "Apellido varchar (120),"+
                "IdEsp Integer references tb_especialidad(IdEsp),"+
                "Direccion varchar(120)," +
                "Correo varchar(120),"+
                "Telefono char(9),"+
                "sexo char (1),"+
                "cid varchar (40))")

        db.execSQL("insert into tb_medico values(null,'Isabella','Ramirez Cortez', 2,'Jr. Jacarandas 169', 'isara@gmail.com', '977534276', " +
                "'F', 'CMP4353623')")
        db.execSQL("insert into tb_medico values(null,'Adriana', 'Marquez Rodriguez', 1,'Jr. Los Condores 345', 'adrimaa@gmail.com', '969534276'," +
                " 'F', 'CMP9656734')")

        db.execSQL("create table tb_cita(" +
                "IdCita Integer primary key autoincrement,"+
                "IdEsp Integer references tb_especialidad(IdEsp),"+
                "IdMedico Integer references tb_medico(IdMedico),"+
                "IdPaciente Integer references tb_paciente(IdPaciente),"+
                "Fecha Date,"+
                "Hora varchar(100),"+
                "Descripcion varchar (160))")

        db.execSQL("insert into tb_cita values(null, 2, 1, 2, '2022/01/31', '10:00AM', 'Consultorio N° 89')")
        db.execSQL("insert into tb_cita values(null, 1, 2, 1, '2022/10/21', '05:00PM', 'Consultorio N° 25')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}