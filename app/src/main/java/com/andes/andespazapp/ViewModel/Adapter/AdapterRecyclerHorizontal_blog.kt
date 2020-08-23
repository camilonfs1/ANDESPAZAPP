package com.andes.andespazapp.ViewModel.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andes.andespazapp.Model.Blog_item
import com.andes.andespazapp.R
import com.andes.andespazapp.ViewModel.BlogViewModel
import kotlinx.android.synthetic.main.blog_horizontal_item.view.*

class AdapterRecyclerHorizontal_blog:    RecyclerView.Adapter<AdapterRecyclerHorizontal_blog.ViewHolder>() {

    var items: ArrayList<Blog_item>? = null
    private var BlogViewModel = BlogViewModel()

    init {
        this.items = BlogViewModel.horizontalAd()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.blog_horizontal_item, parent, false)//create instance context
        var Holder = ViewHolder(vista)
        return Holder
    }

    override fun getItemCount(): Int {
        return this.items!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.activity?.text = item!!.title
        holder.linear_botton?.setBackgroundColor(Color.parseColor(item!!.color))
        holder.linerr_top?.setBackgroundColor(Color.parseColor(item!!.color))
    }

    //ViewHolder inner class
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var vista = v
        var activity: TextView? = null
        var linear_botton: LinearLayout? = null
        var linerr_top: LinearLayout? = null

         init {
             linerr_top = vista.linear_top
            linear_botton = vista.linear_botton
            activity = vista.txt_card_blog_horizontal_item
        }
    }

}

