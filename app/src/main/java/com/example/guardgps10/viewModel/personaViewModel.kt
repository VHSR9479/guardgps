package com.example.guardgps10.viewModel

import android.app.Application
import android.os.Build.ID
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope

import com.example.guardgps10.model.Personas
import com.example.guardgps10.repository.personRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers

public class personaViewModel(application: Application):AndroidViewModel(application){

    private val repositor: personRepository = personRepository( application, viewModelScope)

    val allPersona: LiveData<List<Personas>> =  this.repositor.getAllPersona

    init {
//        this.repositor = personRepository( application, viewModelScope)
//        allPersona = this.repositor.getAllPersona
    }

    fun insert(personas: Personas){
        viewModelScope.launch(Dispatchers.IO) {
            repositor.insert(personas)
        }
    }

    fun deletePersona(personas: Personas){
        viewModelScope.launch(Dispatchers.IO) {
            repositor.deletePerson(personas)
        }
    }

    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO) {
            repositor.deleteAllPerson()
        }
    }
}