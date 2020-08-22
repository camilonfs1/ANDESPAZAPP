package com.andes.andespazapp.ViewModel

import com.andes.andespazapp.Model.Firebase.Learn_Firebase
import com.andes.andespazapp.Model.Learn_Item

class LearnViewModel {
    private var DbConsult = Learn_Firebase()
    var item: ArrayList<Learn_Item>? = ArrayList()
    fun read ():ArrayList<Learn_Item>{
        item =  DbConsult.readDB()

        return item!!
    }
}