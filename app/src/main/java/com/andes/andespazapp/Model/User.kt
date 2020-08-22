package com.andes.andespazapp.Model

class User {
    var key: String? = null
    var name: String? = null
    var id: String? = null
    var school: String? = null
    var region: String? = null

    constructor(name:String,id:String){
        this.name = name
        this.id = id
    }
    constructor(){
    }

}