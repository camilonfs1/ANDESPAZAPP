package com.andes.andespazapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "DDHH")
data class ddhh(
    val complaint:String,
    val type:String,
    @PrimaryKey(autoGenerate = true)
    var idItem: Int = 0
) : Serializable
