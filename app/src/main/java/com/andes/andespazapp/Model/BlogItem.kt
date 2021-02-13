package com.andes.andespazapp.Model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Blog")
data class BlogItem(
    var key: String,
    var name_owner: String,
    var title: String,
    var num_commentari: Int,
    var date: Int,
    var avatar_owner: Int,
    var color: String,
    @PrimaryKey(autoGenerate = true)
    var idItem: Int = 0) : Serializable
