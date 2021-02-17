package com.andes.andespazapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "Commentary")
data class Commentary(
    var key: Int,
    var owner: String,
    var commentary: String,
    var date: Int,
    var mother_key: Int,
    @PrimaryKey(autoGenerate = true)
    var idItem: Int = 0
) : Serializable


