package com.example.guardgps10.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.guardgps10.model.interfaces.IDaoPersona
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// anotates class to be  a Room Database with a table (entity) of the To-Do class

@Database(entities = arrayOf(Personas::class),version = 1, exportSchema=false)

public  abstract class database: RoomDatabase() {

    // asigna el dao a la base de datos
    abstract fun iDaoPerson():IDaoPersona
    companion object{
        @Volatile
        private var INSTANCE: database? = null

        fun getDatabase(context:Context,scope: CoroutineScope):database{
            val tempIntance = INSTANCE
            if(tempIntance != null){
                return tempIntance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    database::class.java,
                    "bddGuardGPS"
                ).addCallback(databaseCallback(scope)).build()
                INSTANCE = instance
                return instance
            }

        }
    }
    private class databaseCallback(private val scope:CoroutineScope):RoomDatabase.Callback(){
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let{database  ->
                scope.launch {
//                        populateDatabase(database.iDaoPerson())
                }
            }
        }
        suspend fun  populateDatabase(iDaoPersona: IDaoPersona){

        }

    }
}