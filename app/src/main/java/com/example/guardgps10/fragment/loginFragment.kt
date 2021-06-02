package com.example.guardgps10.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.guardgps10.R
import com.example.guardgps10.locationActivity
import com.example.guardgps10.model.PersonaApi
import com.example.guardgps10.services.persona_service
import com.example.guardgps10.util.util

class loginFragment : Fragment(),View.OnClickListener{
    lateinit var login: Button
    var auth = persona_service()
    private var editextNickName: EditText? = null
    private var editextContrasena: EditText? = null
    private var util:util = util()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_login,container,false)
        login = root.findViewById(R.id.actionlogin)
        login.setOnClickListener(this)
        editextNickName = root.findViewById(R.id.edtTxtNickName)
        editextContrasena = root.findViewById(R.id.editextContrasena)
        return root
    }

    override fun onClick(view: View?)  {
        var persona: PersonaApi?
        if(util.validarConexioninternet(activity!!.applicationContext)){
            Toast.makeText(context, "Conectando con la Api", Toast.LENGTH_LONG).show()
            persona = loginApi()
        } else{
            Toast.makeText(context, "Conectando con la base de datos", Toast.LENGTH_LONG).show()
        }
    }

    fun loginApi(): PersonaApi? {
        var persona: PersonaApi? =  this.auth.getPersona(editextNickName!!.text.toString())
        Toast.makeText(context, editextNickName!!.text.toString(), Toast.LENGTH_LONG).show()
        if (persona == null){
            Toast.makeText(context, "Usuario no encontrado", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context, "Bienvenido "+persona.nombre.toString()+" "+persona.apellido.toString(), Toast.LENGTH_LONG).show()
            val intento = Intent(context,locationActivity::class.java)
            startActivity(intento)
        }
        return persona
    }

}