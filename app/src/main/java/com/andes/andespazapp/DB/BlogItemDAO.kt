package com.andes.andespazapp.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.andes.andespazapp.Model.BlogItem

@Dao
interface BlogItemDAO {
    @Query("SELECT * FROM BLog")
    fun getAll():  LiveData<BlogItem>


    @Query("SELECT * FROM BLog WHERE idItem = :id")
    fun get(id: Int): LiveData<BlogItem>



    @Insert
    fun InsertAll(vararg BlogItem: BlogItem)

    @Update
    fun Update(blogItem: BlogItem)

}