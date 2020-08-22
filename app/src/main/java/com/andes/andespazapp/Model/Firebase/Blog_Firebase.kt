package com.andes.andespazapp.Model.Firebase

import com.andes.andespazapp.Model.Blog_item

class Blog_Firebase {

    var items: ArrayList<Blog_item>? = null
    var items_H: ArrayList<Blog_item>? = null
    var items_V: ArrayList<Blog_item>? = null
    var colors: ArrayList<String>? = null


    fun iniciar(){

        items = ArrayList()
        items_H = ArrayList()
        items_V = ArrayList()
        colors = ArrayList()


        colors!!.add("#673AB7")
        colors!!.add("#7986CB")
        colors!!.add("#64B5F6")
        colors!!.add("#4FC3F7")
        colors!!.add("#4DD0E1")
        colors!!.add("#4DB6AC")
        colors!!.add("#81C784")
        colors!!.add("#AED581")
        colors!!.add("#DCE775")

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

        for (i in 0 until items!!.size){
            if(i<=8){
                items_H!!.add(items!!.get(i))
                items_H!!.get(i).color = colors!!.get(i)
            }else{
                items_V!!.add(items!!.get(i))
            }
        }



    }


}