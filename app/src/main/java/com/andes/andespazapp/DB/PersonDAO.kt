package com.andes.andespazapp.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.andes.andespazapp.Model.Person

@Dao
interface PersonDAO {
    @Query("SELECT * FROM person")
    fun getAll(): LiveData<List<Person>>


    @Query("SELECT * FROM person WHERE identify like :identify")
    fun get(identify:Int):  LiveData<Person>

    @Insert
    fun InsertAll(vararg person : Person)

    @Update
    fun Update(person: Person)
}