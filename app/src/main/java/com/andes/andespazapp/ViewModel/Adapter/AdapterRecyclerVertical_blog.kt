package com.andes.andespazapp.ViewModel.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andes.andespazapp.Model.Blog_item
import com.andes.andespazapp.R
import com.andes.andespazapp.View.Module_Blog.Detail_Blog
import kotlinx.android.synthetic.main.blog_vertical_item.view.*

class AdapterRecyclerVertical_blog(context: Context):  RecyclerView.Adapter<AdapterRecyclerVertical_blog.ViewHolder>()  {
    var items: ArrayList<Blog_item>? = null
    private var BlogViewModel = com.andes.andespazapp.ViewModel.BlogViewModel()

    init {
        this.items = BlogViewModel.verticalAd(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.blog_vertical_item, parent, false)//create instance context
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

        holder.vista.setOnClickListener(object : View.OnClickListener  {
            override fun onClick(v: View?) {
                var intent = Intent(v!!.context, Detail_Blog::class.java)
                v.context.startActivity(intent)
            }

        })
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