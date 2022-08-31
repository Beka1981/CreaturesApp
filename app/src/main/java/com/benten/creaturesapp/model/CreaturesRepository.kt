package com.benten.creaturesapp.model

import androidx.lifecycle.LiveData

interface CreaturesRepository {
    fun insertCreature(creature: Creature)
    fun getAllCreatures(): LiveData<List<Creature>>
}