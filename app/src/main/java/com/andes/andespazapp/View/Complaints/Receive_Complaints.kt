package com.andes.andespazapp.View.Complaints

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andes.andespazapp.Model.Complaint
import com.andes.andespazapp.R
import com.andes.andespazapp.ViewModel.Adapter.AdapterReceive_Complaint
import kotlinx.android.synthetic.main.activity_receive_complaints.*

class Receive_Complaints : AppCompatActivity() {

    var recycler: RecyclerView? = null
    var items: ArrayList<Complaint>? = null
    var adaptador: AdapterReceive_Complaint? = null
    var layoutmanager: RecyclerView.LayoutManager? =  null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_complaints)
        items = ArrayList()
        recycler = recycler_complaint_Vertical

        items!!.add(Complaint("camilo vargas romero","kjdaiu7dakjhsd983h", "raalizada por mi como pruebaenuncia numero 1 raalizada por mi como pruebaenuncia numero 1 raalizada por mi como pruebaenuncia numero 1 raalizada por mi como pruebaenuncia numero 1 raalizada por mi como pruebaenuncia numero 1 raalizada por mi como prueba", 10))
        items!!.add(Complaint("camilo","kjdaiu7dakjhsd983h", "denuncia numero 1 raalizada por mi como prueba", 10))
        items!!.add(Complaint("camilo","kjdaiu7dakjhsd983h", "denuncia numero 1 raalizada por mi como prueba", 10))
        items!!.add(Complaint("camilo","kjdaiu7dakjhsd983h", "denuncia numero 1 raalizada por mi como prueba", 10))

        adaptador = AdapterReceive_Complaint(items!!, R.layout.complaint_item)
        layoutmanager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recycler?.layoutManager = layoutmanager
        recycler?.adapter = adaptador

    }
}