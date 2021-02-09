package com.andes.andespazapp.ViewModel

import android.content.Context
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


    //Return blog item horizontal list
   fun horizontalAd(context:Context): ArrayList<Blog_item>{

       colors = ArrayList()
        //Change color for first nine blot items
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

        //Read database local
       items = Blog_Db.get_blogItems(context,0)
       for (i in 0 until items!!.size){
           if(i<=8){
               items_H!!.add(items!!.get(i))
               items_H!!.get(i).color = colors!!.get(i)
           }
       }
       return items_H!!
   }

    //Return blog itme vertical list
    fun verticalAd(context:Context): ArrayList<Blog_item>{
        items_V =ArrayList()
        items =ArrayList()
        items = Blog_Db.get_blogItems(context,1)
        for (i in 0 until items!!.size){
            if(i>=8){
                items_V!!.add(items!!.get(i))
            }
        }
        return items_V!!
    }

    //Return commentary list
    fun commentary(owner:String): ArrayList<Commentary>{
        commentsmain= ArrayList()
        commentsaux= ArrayList()
        commentsaux = Blog_Db.getBlogDetail()
        for(i in 0 until commentsaux!!.size){
            if (commentsaux!!.get(i).mother_key.equals(owner)){
                commentsmain!!.add(commentsaux!!.get(i))
            }
        }
        return  commentsmain!!
    }
}