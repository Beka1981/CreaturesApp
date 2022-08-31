package com.benten.creaturesapp.views.allCreatures

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.benten.creaturesapp.model.Creature
import com.benten.creaturesapp.model.room.CreaturesRepositoryImpl

class AllCreaturesViewModel : ViewModel() {
    private val creaturesRepo = CreaturesRepositoryImpl()

    private val addClickedLiveData = MutableLiveData<Boolean>()

    fun getAllCreaturesLiveData(): LiveData<List<Creature>> {
        return creaturesRepo.getAllCreatures()
    }

    fun getAddClickedLiveData(): LiveData<Boolean> {
        return addClickedLiveData
    }

    fun onAddCreatureClicked() {
        addClickedLiveData.postValue(true)
        addClickedLiveData.postValue(false)
    }

}