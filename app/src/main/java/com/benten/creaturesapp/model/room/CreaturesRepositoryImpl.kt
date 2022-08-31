package com.benten.creaturesapp.model.room

import androidx.lifecycle.LiveData
import com.benten.creaturesapp.app.CreaturesApp
import com.benten.creaturesapp.model.Creature
import com.benten.creaturesapp.model.CreaturesRepository

class CreaturesRepositoryImpl : CreaturesRepository {

    override fun insertCreature(creature: Creature) {
        CreaturesApp.database.creaturesDao().insertCreature(creature)
    }

    override fun getAllCreatures(): LiveData<List<Creature>> {
        return CreaturesApp.database.creaturesDao().getAllCreatures()
    }

}