package com.example.guardgps10.Dao.`interface`

import com.example.guardgps10.model.PersonaApi

interface IUserDao {
    fun fechUserById(nickname:String): PersonaApi
    fun fetchAllUsers():List<PersonaApi>
    fun addUser(persona:PersonaApi):Boolean
    fun addUsers(personas:List<PersonaApi>):Boolean
    fun deleteAllUsers():Boolean
}