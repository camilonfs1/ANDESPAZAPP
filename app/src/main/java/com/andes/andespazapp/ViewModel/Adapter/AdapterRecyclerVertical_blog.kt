package com.andes.andespazapp.ViewModel.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andes.andespazapp.Model.Blog_item
import kotlinx.android.synthetic.main.blog_horizontal_item.view.*
import kotlinx.android.synthetic.main.blog_vertical_item.view.*

class AdapterRecyclerVertical_blog(private var blogitem: ArrayList<Blog_item>,resource : Int ):  RecyclerView.Adapter<AdapterRecyclerVertical_blog.ViewHolder>()  {
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
        holder.title?.text = item!!.title
        holder.days?.text = item!!.date.toString()+" días"
        holder.commnetary?.text = item!!.num_commentari.toString()+" Comentarios"
    }

    //ViewHolder inner class
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var vista = v
        var title: TextView? = null
        var days: TextView? = null
        var commnetary: TextView?  =  null

        init {
            title = vista.txt_card_blog_vertical_item
            days = vista.txt_num_day_V
            commnetary = vista.txt_num_commentary_V
        }
    }
}