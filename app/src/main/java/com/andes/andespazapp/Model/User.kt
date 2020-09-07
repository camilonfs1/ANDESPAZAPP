package com.andes.andespazapp.Model

import android.util.Log
import com.andes.andespazapp.View.Chat.Chat_Module.Companion.TAG

class User {
    var key: String? = null
    var roll: String? = null
    var andes_asociate: Boolean? = null
    var name: String? = null
    var region: String? = null
    var age: String? = null
    var course: String? = null
    var email: String? = null
    var icon:Int? = null


    constructor(key: String, roll: String,andes_asociate:Boolean, name:String, region:String, age:String, course:String, email:String,icon:Int) {
        this.key = key
        this.roll = roll
        this.andes_asociate = andes_asociate
        this.name = name
        this.region = region
        this.course = course
        this.age = age
        this.email = email
        this.icon = icon

    }

    constructor() {
    }

}