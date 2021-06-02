package com.example.guardgps10.`interface`

import retrofit2.Call
import com.example.guardgps10.model.PersonaApi
import com.example.guardgps10.model.Tipo_documentoApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface ifApiPersona {
    @GET("Persona/{user}.json")
    fun listPerson(@Path("user") user:String): Call<PersonaApi>

    @GET("Tipo_documento.json")
    fun listTDoc(): Call<List<Tipo_documentoApi>>

    @PUT("Persona/{ruta}")
    fun setPerson(@Path("ruta") ruta:String): Call<PersonaApi>





}