package com.example.guardgps10.model.interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.guardgps10.model.Personas

@Suppress("AndroidUnresolvedRoomSqlReference")
@Dao
interface IDaoPersona {
    @Query( "SELECT * from  Persona")
    fun getPersona(): LiveData<List<Personas>>

    @Insert( onConflict = OnConflictStrategy.IGNORE)
    fun insertPerson(personas: Personas)

    @Delete()
    suspend  fun deletePerson(personas: Personas)

    @Query( "DELETE FROM Persona")
    suspend  fun deleteAllPerson()
}