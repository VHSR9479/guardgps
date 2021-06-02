package com.example.guardgps10.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="Persona")
data class Personas (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo  (name="nickname")      val nickname:   String ,
    @ColumnInfo  (name="apellido")      val apellido:   String ,
    @ColumnInfo  (name="documento")     val documento:  String ,
    @ColumnInfo  (name="estado")        val estado:     String,
    @ColumnInfo  (name="nombre")        val nombre:     String,
    @ColumnInfo  (name="tipo_documento")    val tipo_documento: String
)

data class Usuarios(
    @PrimaryKey(autoGenerate = false)   val id_person:  Int,
    @ColumnInfo  (name="contrasena")    val contrasena: String ,
    @ColumnInfo  (name="correo")        val correo:     String
)