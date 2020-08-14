package com.andes.andespazapp.Model

class Complaint(name_sent: String, key_sent:String, complaint:String, date:Int) {

    var name_sent: String? = null
    var key_sent: String? = null
    var complaint: String? = null
    var date: Int? = null

    init {
        this.name_sent = name_sent
        this.key_sent = key_sent
        this.complaint = complaint
        this.date = date
    }


}