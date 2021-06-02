package com.example.guardgps10.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.guardgps10.R
import com.example.guardgps10.`interface`.ifApiPersona
import com.example.guardgps10.model.PersonaApi
import com.example.guardgps10.model.Personas
import com.example.guardgps10.model.Tipo_documentoApi
import com.example.guardgps10.model.persona
import com.example.guardgps10.services.persona_service
import com.example.guardgps10.util.RestEngine
import com.example.guardgps10.util.util
import com.example.guardgps10.viewModel.personaViewModel
import kotlinx.android.synthetic.main.fragment_signup.view.*

class fragment_signUp : Fragment(){

    private lateinit var  pViewModel: personaViewModel
    var myDatesetPersona = emptyList<Personas>()
    lateinit var tdocument:List<Tipo_documentoApi>

    lateinit var login: Button
    var auth = persona_service()
    private var editextNickName: EditText? = null
    private var editextnombre: EditText? = null
    private var editextapellido: EditText? = null
    private var editextDocumento: EditText? = null
    private var editextCorreo: EditText? = null
    private var editextContrasena: EditText? = null
    private var editextRContrasena: EditText? = null
    private var util: util = util()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_signup,container,false)
        val spinner: Spinner = root.findViewById(R.id.Tdocumento_spinner)
         tdocument = initTipoDocumento(root.context)
        val tipoDocumentoAdapter = ArrayAdapter<List<Tipo_documentoApi>>(root.context,android.R.layout.simple_spinner_item)
        tipoDocumentoAdapter.add(tdocument)
        spinner.adapter= tipoDocumentoAdapter

//        ArrayAdapter.createFromResource(
//                root.context,
//                Tipo_documentoApi,
//                android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            // Specify the layout to use when the list of choices appears
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            // Apply the adapter to the spinner
//            spinner.adapter = adapter
//        }
        return root
    }

    fun initTipoDocumento(contexto:Context):List<Tipo_documentoApi>{
        var tipo_documentoApi: List<Tipo_documentoApi>? =  this.auth.getTipoDocumento("usuario",contexto)
        if(tipo_documentoApi == null){
            tipo_documentoApi= listOf(Tipo_documentoApi("Ninguno"))
        }
        return tipo_documentoApi
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        pViewModel = ViewModelProvider(this).get(personaViewModel::class.java)
//        pViewModel.allPersona.observe(this)->
    }
}