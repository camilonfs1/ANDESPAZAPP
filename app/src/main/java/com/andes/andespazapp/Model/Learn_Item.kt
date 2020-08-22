package com.andes.andespazapp.Model

class Learn_Item(key: String, name:String, description:String, image:Int, advance:Int) {

    var key: String? = null
    var name: String? = null
    var description: String? = null
    var image: Int? = null
    var advance: Int? = null
    init {
        this.key = key
        this.name = name
        this.description = description
        this.image = image
        this.advance = advance
    }
}