package com.andes.andespazapp.Model

class Commentary(key:String , owner:String ,commentary: String, date:String, mother_key:String) {
    var  key:String = ""
    var owner:String = ""
    var commentary:String = ""
    var date:String = ""
    var mother_key:String = ""
    init {
        this.key = key
        this.owner = owner
        this.commentary = commentary
        this.date = date
        this.mother_key = mother_key
    }
}