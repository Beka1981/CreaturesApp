package com.benten.creaturesapp.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.benten.creaturesapp.model.Creature

@Dao
interface CreaturesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCreature(creature: Creature)

    @Query("SELECT * FROM creatures")
    fun getAllCreatures():LiveData<List<Creature>>
}