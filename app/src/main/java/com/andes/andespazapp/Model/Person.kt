package com.andes.andespazapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Person")
data class Person(
    var roll: String,
    var andes_asociate: Boolean,
    var name: String,
    var identify: Int,
    var Colegio: String,
    var age: String,
    var email: String,
    var icon: Int,
    @PrimaryKey(autoGenerate = true)
    var idPerson: Int = 0
)