package com.andes.andespazapp.ViewModel.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andes.andespazapp.Model.BlogItem
import com.andes.andespazapp.R
import com.andes.andespazapp.View.Module_Blog.Detail_Blog
import kotlinx.android.synthetic.main.blog_horizontal_item.view.*
import kotlinx.android.synthetic.main.blog_vertical_item.view.*

class AdapterRecyclerVertical_blog(
    items_blog: ArrayList<BlogItem>, id: String,
    username: String
) : RecyclerView.Adapter<AdapterRecyclerVertical_blog.ViewHolder>() {
    var items: ArrayList<BlogItem>? = null
    private var BlogViewModel = com.andes.andespazapp.ViewModel.BlogViewModel()
    var id: String? = null
    var username: String? = null

    init {
        this.id = id
        this.username = username
        this.items = BlogViewModel.verticalAd(items_blog)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.blog_vertical_item, parent, false)//create instance context
        var Holder = ViewHolder(vista)
        return Holder
    }

    override fun getItemCount(): Int {
        return this.items!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.title?.text = item!!.title
        holder.key?.text = item.key.toString()
        holder.days?.text = item!!.date.toString() + " días"
        holder.commnetary?.text = item!!.num_commentari.toString() + " Comentarios"

        holder.vista.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                var intent = Intent(v!!.context, Detail_Blog::class.java)

                //Detail object blog
                intent.putExtra("id", id.toString())
                intent.putExtra("username", username)
                intent.putExtra("key", holder.key?.text)
                intent.putExtra("owner", items?.get(position)!!.name_owner)
                intent.putExtra("date", items?.get(position)!!.date)
                intent.putExtra("color", "#fffff")
                intent.putExtra("title", items?.get(position)!!.title)

                v.context.startActivity(intent)
            }

        })
    }

    //ViewHolder inner class
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var vista = v
        var title: TextView? = null
        var days: TextView? = null
        var commnetary: TextView? = null
        var key: TextView? = null

        init {
            title = vista.txt_card_blog_vertical_item
            days = vista.txt_num_day_V
            key = vista.key_v
            commnetary = vista.txt_num_commentary_V
        }
    }
}