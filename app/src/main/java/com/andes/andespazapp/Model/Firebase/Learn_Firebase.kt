package com.andes.andespazapp.Model.Firebase

import com.andes.andespazapp.Model.Learn_Item

class Learn_Firebase {
    var item: ArrayList<Learn_Item>? = ArrayList()
    fun readDB(): ArrayList<Learn_Item>{
        item = ArrayList()
        item!!.add(
            Learn_Item("1", "primero", "este es el primero", 1,1)
        )
        item!!.add(
            Learn_Item("2", "segunda", "este es el segundo", 1,30)
        )
        item!!.add(
            Learn_Item("3", "tercera", "este es el tercero", 1,10)
        )
        item!!.add(
            Learn_Item("3", "tercera", "este es el tercero", 1,15)
        )
        item!!.add(
            Learn_Item("3", "tercera", "este es el tercero", 1,5)
        )
        return item!!
    }

}