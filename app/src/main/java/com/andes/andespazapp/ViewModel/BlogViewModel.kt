package com.andes.andespazapp.ViewModel

import android.content.Context
import com.andes.andespazapp.Model.Blog_item
import com.andes.andespazapp.R
import com.andes.andespazapp.ViewModel.Adapter.AdapterRecyclerHorizontal_blog
import com.andes.andespazapp.ViewModel.Adapter.AdapterRecyclerVertical_blog

class BlogViewModel {
    var adaptador_H: AdapterRecyclerHorizontal_blog? = null
    var adaptador_V: AdapterRecyclerVertical_blog? = null
    var items_H: ArrayList<Blog_item>? = null
    var items_V: ArrayList<Blog_item>? = null

   fun horizontalAd(context: Context): AdapterRecyclerHorizontal_blog{
       adaptador_H = AdapterRecyclerHorizontal_blog(items_H!!, R.layout.blog_horizontal_item)
       return adaptador_H!!
   }
    fun verticalAd(context: Context): AdapterRecyclerVertical_blog{
        adaptador_V = AdapterRecyclerVertical_blog(items_V!!, R.layout.blog_vertical_item)
        return adaptador_V!!
    }
}