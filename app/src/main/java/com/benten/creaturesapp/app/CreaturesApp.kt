package com.benten.creaturesapp.app

import android.app.Application
import androidx.room.Room
import com.benten.creaturesapp.model.room.CreatureDatabase

class CreaturesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, CreatureDatabase::class.java, "creatures_database")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    companion object {
        lateinit var database: CreatureDatabase
    }
}