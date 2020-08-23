package com.andes.andespazapp.Model.Firebase

import android.util.Log
import com.andes.andespazapp.Model.Blog_item

class Blog_Firebase {

    var items: ArrayList<Blog_item>? = ArrayList()

    fun ReadDB(): ArrayList<Blog_item>{

        items!!.add(Blog_item("1", "camilo vargas",   "Discusión numero uno, propuesta para el desarrollo del tema propuesta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES segunda", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES tercera", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES cuarta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES quinta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "Discusión numero uno, propuesta para el desarrollo del tema propuesta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES segunda", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES tercera", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES cuarta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES quinta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "Discusión numero uno, propuesta para el desarrollo del tema propuesta", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES segunda", 1, 10, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES tercera", 1, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES cuarta", 6, 1, 1,"#fffff"))
        items!!.add(Blog_item("1", "camilo vargas",   "DEBATE ANDES quinta", 1, 1, 1,"#fffff"))

        return items!!
    }




}