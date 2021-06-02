package com.example.guardgps10.Dao.`interface`

import com.example.guardgps10.model.PersonaApi
import com.example.guardgps10.model.interfaces.IUserSchema

class UserDao :IUserDao, IUserSchema {
    override fun fechUserById(nickname: String): PersonaApi {
        TODO("Not yet implemented")
    }

    override fun fetchAllUsers(): List<PersonaApi> {
        TODO("Not yet implemented")
    }

    override fun addUser(persona: PersonaApi): Boolean {
        TODO("Not yet implemented")
    }

    override fun addUsers(personas: List<PersonaApi>): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteAllUsers(): Boolean {
        TODO("Not yet implemented")
    }
}