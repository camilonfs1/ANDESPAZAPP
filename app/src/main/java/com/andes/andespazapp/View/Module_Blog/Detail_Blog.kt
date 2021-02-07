package com.andes.andespazapp.View.Module_Blog

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andes.andespazapp.R
import com.andes.andespazapp.View.Student.MainStudentMenu
import com.andes.andespazapp.ViewModel.Adapter.AdapterRecyclerHorizontal_blog
import com.andes.andespazapp.ViewModel.Adapter.Adapter_commentary
import kotlinx.android.synthetic.main.activity_detail__blog.*

class Detail_Blog : AppCompatActivity() {

    var image_back: ImageView? = null
    var commentaryRecicler: RecyclerView? =null
    var adaptador_C: Adapter_commentary? = null
    var layoutmanager: RecyclerView.LayoutManager? =  null
    var owner_mother: TextView? = null
    var blog_text : TextView?  = null
    var linear_top:LinearLayout? = null
    var linear_bottom:LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail__blog)

        commentaryRecicler = recycler_commentary
        owner_mother = txt_owner
        blog_text = txt_blog_mother
        image_back = image_home

        linear_top = linear_topr
        linear_bottom = linear_botton

        var key = intent.getStringExtra("key")
        var owner = intent.getStringExtra("owner")
        var color = intent.getStringExtra("color")
        var title = intent.getStringExtra("title")

        owner_mother!!.text=owner
        blog_text!!.text  = title
        linear_top!!.setBackgroundColor(Color.parseColor(color))
        linear_bottom!!.setBackgroundColor(Color.parseColor(color))

        adaptador_C = Adapter_commentary(key)
        layoutmanager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        commentaryRecicler?.layoutManager = layoutmanager
        commentaryRecicler?.adapter = adaptador_C

        image_back!!.setOnClickListener {
            val intent = Intent(this, Blog_main::class.java)
            startActivity(intent)
        }
    }
}