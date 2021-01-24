package com.andes.andespazapp.View.Module_Blog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andes.andespazapp.R
import com.andes.andespazapp.ViewModel.Adapter.AdapterRecyclerHorizontal_blog
import com.andes.andespazapp.ViewModel.Adapter.Adapter_commentary
import kotlinx.android.synthetic.main.activity_detail__blog.*

class Detail_Blog : AppCompatActivity() {

    var commentaryRecicler: RecyclerView? =null
    var adaptador_C: Adapter_commentary? = null
    var layoutmanager: RecyclerView.LayoutManager? =  null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail__blog)

        commentaryRecicler = recycler_commentary

        var key = intent.getStringExtra("key")
        var owner = intent.getStringExtra("owner")
        var date = intent.getStringExtra("date")

        System.out.println("holaaaaaaaaaaaaaaaaaaa-------------->"+key+owner+date)
        adaptador_C = Adapter_commentary("hola")
        layoutmanager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        commentaryRecicler?.layoutManager = layoutmanager
        commentaryRecicler?.adapter = adaptador_C

    }
}