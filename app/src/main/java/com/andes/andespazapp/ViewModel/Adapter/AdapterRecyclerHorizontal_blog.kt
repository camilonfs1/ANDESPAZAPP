package com.andes.andespazapp.ViewModel.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andes.andespazapp.Model.Blog_item
import com.andes.andespazapp.R
import kotlinx.android.synthetic.main.blog_horizontal_item.view.*

class AdapterRecyclerHorizontal_blog(private var blogitem: ArrayList<Blog_item>,resource : Int ):    RecyclerView.Adapter<AdapterRecyclerHorizontal_blog.ViewHolder>() {

    var items: ArrayList<Blog_item>? = null
    var resource: Int?  = null

    init {
        this.items = blogitem
        this.resource =resource
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(resource!!, parent, false)//create instance context
        var Holder = ViewHolder(vista)
        return Holder
    }

    override fun getItemCount(): Int {
        return this.items!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.activity?.text = item?.title
    }

    //ViewHolder inner class
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var vista = v
        var activity: TextView? = null
        init {
            activity = vista.txt_card_blog_horizontal_item
        }
    }

}