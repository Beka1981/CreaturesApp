package com.benten.creaturesapp.views.addCreature

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.benten.creaturesapp.model.AttributeValue
import com.benten.creaturesapp.model.CreatureAttributes
import com.benten.creaturesapp.model.CreatureGenerator
import com.benten.creaturesapp.model.room.CreaturesRepositoryImpl

class AddCreatureViewModel : ViewModel() {
    private val creatureGenerator = CreatureGenerator()
    private val creaturesRepo = CreaturesRepositoryImpl()
    private val savedLiveData = MutableLiveData<Boolean>()

    fun getSavedLiveData(): LiveData<Boolean> {
        return savedLiveData
    }

    fun onSaveClicked(creatureAttributes: CreatureAttributes, name: String, chosenAvatar: Int) {
        val creature = creatureGenerator.generateCreature(creatureAttributes, name, chosenAvatar)
        creaturesRepo.insertCreature(creature)
        savedLiveData.postValue(true)
    }


    private var intelligence: AttributeValue? = null
    private var strength: AttributeValue? = null
    private var endurance: AttributeValue? = null

    fun onIntelligenceSelected(intelligence: AttributeValue) {
        this.intelligence = intelligence
    }

    fun onStrengthSelected(strength: AttributeValue) {
        this.strength = strength
    }

    fun onEnduranceSelected(endurance: AttributeValue) {
        this.endurance = endurance
    }

    private val hitPointsLiveData = MutableLiveData<Int>()

    fun getHitPointsLiveData(): LiveData<Int> {
        return hitPointsLiveData
    }

    fun getHitPoints() {
        if (intelligence != null && strength != null && endurance != null) {
            val hitPoints = generateHitPoints()
            hitPointsLiveData.postValue(hitPoints)
        }
    }

    private fun generateHitPoints() : Int {
        return 5 * intelligence!!.value +
                3 * strength!!.value +
                4 * endurance!!.value
    }

}