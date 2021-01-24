package com.andes.andespazapp.ViewModel

import android.util.Log
import com.andes.andespazapp.Model.Blog_item
import com.andes.andespazapp.Model.Commentary
import com.andes.andespazapp.Model.Firebase.Blog_Firebase

class BlogViewModel {
    var items: ArrayList<Blog_item>? = null
    var items_H: ArrayList<Blog_item>? = null
    var items_V: ArrayList<Blog_item>? = null
    private var Blog_Db : Blog_Firebase =  Blog_Firebase()
    private var colors: ArrayList<String>? = null

    private var commentsaux: ArrayList<Commentary>? = null
    private var commentsmain: ArrayList<Commentary>? = null

   fun horizontalAd(): ArrayList<Blog_item>{
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
       items =ArrayList()
       items_H =ArrayList()

       items = Blog_Db.ReadDB()
       for (i in 0 until items!!.size){
           if(i<=8){
               items_H!!.add(items!!.get(i))
               items_H!!.get(i).color = colors!!.get(i)
           }
       }
       return items_H!!
   }
    fun verticalAd(): ArrayList<Blog_item>{
        items_V =ArrayList()
        items =ArrayList()
        items = Blog_Db.ReadDB()
        for (i in 0 until items!!.size){
            if(i>=8){
                items_V!!.add(items!!.get(i))
            }
        }
        return items_V!!
    }

    fun commentary(owner:String): ArrayList<Commentary>{
        commentsmain= ArrayList()
        commentsaux= ArrayList()
        commentsaux = Blog_Db.getBlogDetail()

        for(i in 0 until commentsaux!!.size){

            System.out.println("------------------------->"+commentsaux!!.get(i).commentary+"-----"+owner)
        }

        return  commentsaux!!
    }
}