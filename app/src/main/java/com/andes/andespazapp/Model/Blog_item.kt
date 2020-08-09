package com.andes.andespazapp.Model

class Blog_item(key:String, name_owner: String,   title: String, date: Int, num_commentari: Int, avatar_owner:Int, color: String) {
    var key: String?= null
    var name_owner: String?= null
    var title: String?= null
    var num_commentari: Int?= null
    var date: Int?= null
    var avatar_owner: Int?= null
    var color: String? = null

    init {
        this.key = key
        this.name_owner =name_owner
        this.title =title
        this.num_commentari =num_commentari
        this.date =date
        this.avatar_owner =avatar_owner
        this.color = color
    }

}