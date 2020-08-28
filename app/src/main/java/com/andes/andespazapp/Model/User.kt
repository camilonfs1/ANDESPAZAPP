package com.andes.andespazapp.Model

class User {
    var key: String? = null
    var roll: String? = null
    var andes_asociate: Boolean? = null
    var name: String? = null
    var region: String? = null
    var age: String? = null
    var course: String? = null
    var email: String? = null


    constructor(name: String, id: String) {
        this.name = name
    }

    constructor() {
    }

}