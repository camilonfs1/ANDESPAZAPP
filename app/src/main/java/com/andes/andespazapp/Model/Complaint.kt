package com.andes.andespazapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Complaint")
data class Complaint(
    val complaint:String,
    val contact:String,
    @PrimaryKey(autoGenerate = true)
    var idItem: Int = 0
) : Serializable
