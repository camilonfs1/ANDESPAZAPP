package com.andes.andespazapp.Model


class User {
    var key: String? = null
    var roll: String? = null
    var andes_asociate: Boolean? = null
    var name: String? = null
    var identify: String? = null
    var region: String? = null
    var age: String? = null
    var email: String? = null
    var icon:Int? = null


    constructor(key: String, roll: String,andes_asociate:Boolean, name:String, identify:String, region:String, age:String,  email:String, icon:Int) {
        this.key = key
        this.roll = roll
        this.andes_asociate = andes_asociate
        this.name = name
        this.region = region
        this.age = age
        this.identify = identify
        this.email = email
        this.icon = icon
    }

    constructor() {
    }

}