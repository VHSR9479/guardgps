package com.example.guardgps10.services

import android.content.Context
import android.provider.ContactsContract
import android.widget.Toast
import com.example.guardgps10.`interface`.ifApiPersona
import com.example.guardgps10.model.PersonaApi
import com.example.guardgps10.model.Tipo_documentoApi
import com.example.guardgps10.model.UsuarioApi
import com.example.guardgps10.util.RestEngine

import retrofit2.Call;
import retrofit2.Callback
import retrofit2.Response

class persona_service() {

//    var persona: String = ""
    var persona: PersonaApi? = null
    var tipo_documento: List<Tipo_documentoApi>? = null


    fun getPersona(nickname: String): PersonaApi? {
        val apiPersona: ifApiPersona = RestEngine.getRestEngine().create(ifApiPersona::class.java)
        val  result: Call<PersonaApi> = apiPersona.listPerson(nickname)
        result.enqueue(object : Callback<PersonaApi>{
            override fun onResponse(call: Call<PersonaApi>, response: Response<PersonaApi>) {
                persona = response.body()
            }
            override fun onFailure(call: Call<PersonaApi>, t: Throwable) {
                persona = null
            }
        })
        return persona
    }

    fun getTipoDocumento(nickname: String,context: Context): List<Tipo_documentoApi>? {
        val apiPersona: ifApiPersona = RestEngine.getRestEngine().create(ifApiPersona::class.java)
        val  result: Call<List<Tipo_documentoApi>> = apiPersona.listTDoc()
//        if(result.isSuccessful){
//            val items = result.body()
//            if(items != null){
//                for(i in 0 until items.count()){
//                    val descripcion= items[i]?: "N/A"
//                }
//            }
//
//
//        }

        result.enqueue(object : Callback<List<Tipo_documentoApi>> {
                override fun onResponse(call: Call<List<Tipo_documentoApi>>, response: Response<List<Tipo_documentoApi>>) {
                    Toast.makeText(context,"Ok",Toast.LENGTH_LONG).show()
                    tipo_documento = response.body()
        }

                override fun onFailure(call: Call<List<Tipo_documentoApi>>, t: Throwable) {
                    Toast.makeText(context,"Error",Toast.LENGTH_LONG).show()
                    tipo_documento = null
        }

    })
        return tipo_documento
    }
}