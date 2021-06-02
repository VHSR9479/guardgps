package com.example.guardgps10.model

data class PersonaApi(
    val nickname: String,
    val apellido: String,
    val documento: Int,
    val estado: Int,
    val nombre: String,
    val tipo_documento: Int,
    val usuario: UsuarioApi
)

data class Id(
    val id:String,
    val persona : PersonaApi
)

data class UsuarioApi(
    val contrasena: String,
    val correo: String
)

data class Tipo_documentoApi(
        val desc:String?
)

