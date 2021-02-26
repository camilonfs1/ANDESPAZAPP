package com.andes.andespazapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "Commentary")
data class Commentary(
    var key: String,
    var owner: String,
    var commentary: String,
    var date: String,
    var mother_key: String,
    @PrimaryKey(autoGenerate = true)
    var idItem: Int = 0
) : Serializable


