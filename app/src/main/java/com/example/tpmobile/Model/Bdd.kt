package com.example.tpmobile.Model

import android.content.Context
import androidx.room.Database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tpmobile.Model.Dao.TeamDao
import com.example.tpmobile.Model.Entity.Team


@Database(entities = arrayOf(Team::class),version = 1,exportSchema = false)
abstract  class Bdd :RoomDatabase() {
    abstract fun  TeamDao(): TeamDao

    companion object{
        @Volatile
        var database :Bdd?=null
        fun getInstance(context: Context): Bdd? {
            if (database==null){
                synchronized(Bdd::class.java){
                    if (database==null) {

                        database= Room.databaseBuilder(context.applicationContext,Bdd::class.java,"Database").allowMainThreadQueries().build()
                    }

                }
            }


            return database
        }


    }
}