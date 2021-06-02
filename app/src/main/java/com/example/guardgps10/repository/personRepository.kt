package com.example.guardgps10.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.guardgps10.model.Personas
import com.example.guardgps10.model.database
import kotlinx.coroutines.CoroutineScope

class personRepository (application: Application,viewModelScope: CoroutineScope){

    private val iDaoPersona = database.getDatabase(
        application,
        viewModelScope
    ).iDaoPerson()

    val getAllPersona: LiveData<List<Personas>> = iDaoPersona.getPersona()

    suspend fun insert(personas: Personas){
        iDaoPersona.insertPerson(personas)
    }

    suspend fun deletePerson(personas: Personas){
        iDaoPersona.deletePerson(personas)
    }

    suspend fun deleteAllPerson(){
        iDaoPersona.deleteAllPerson()
    }


}