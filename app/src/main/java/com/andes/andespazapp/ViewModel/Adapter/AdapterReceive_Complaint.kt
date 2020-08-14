package com.andes.andespazapp.ViewModel.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andes.andespazapp.Model.Blog_item
import com.andes.andespazapp.Model.Complaint
import kotlinx.android.synthetic.main.complaint_item.view.*

class AdapterReceive_Complaint(private var blogitem: ArrayList<Complaint>, resource : Int ):RecyclerView.Adapter<AdapterReceive_Complaint.ViewHolder>()  {
    var items: ArrayList<Complaint>? = null
    var resource: Int?  = null

    init {
        this.items = blogitem
        this.resource =resource
    }
    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): AdapterReceive_Complaint.ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(resource!!, parent, false)//create instance context
        var Holder = AdapterReceive_Complaint.ViewHolder(vista)
        return Holder
    }
    override fun getItemCount(): Int {
        return this.items!!.size
    }
    override fun onBindViewHolder(holder: AdapterReceive_Complaint.ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.complaint!!.text = item!!.complaint
        holder.date!!.text = "Hace "+item!!.date.toString()+" dias"
        holder.name_sent!!.text = item!!.name_sent
        holder.txt_key!!.text = item!!.key_sent
    }
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var vista = v
        var complaint : TextView? = null
        var date: TextView? = null
        var name_sent: TextView? = null
        var txt_key: TextView? = null
        init {
            name_sent = vista.txt_name_complaint
            txt_key = vista.txt_key
            complaint = vista.txt_complaint
            date = vista.txt_date_complaint
        }
    }
}