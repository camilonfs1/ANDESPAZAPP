package com.andes.andespazapp.ViewModel.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andes.andespazapp.Model.Commentary
import com.andes.andespazapp.R
import com.andes.andespazapp.ViewModel.BlogViewModel
import kotlinx.android.synthetic.main.commentary_item.view.*

class Adapter_commentary(owner:String): RecyclerView.Adapter<Adapter_commentary.ViewHolder>()  {
    var items: ArrayList<Commentary>? = null
    private var BlogViewModel = BlogViewModel()
    private var owner:String ? = null

    init {
        this.owner = owner
        this.items = BlogViewModel.commentary(owner)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.commentary_item, parent, false)//create instance context
        var Holder = ViewHolder(vista)
        return Holder
    }

    override fun getItemCount(): Int {
        return this.items!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.commnetary?.text = item!!.commentary
        holder.owner?.text = item!!.owner


    }

    //ViewHolder inner class
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var vista = v
        var commnetary: TextView?  =  null
        var owner:TextView? =null
        init {
            commnetary = vista.txt_commentary
            owner = vista.txt_owner_comment
        }
    }
}