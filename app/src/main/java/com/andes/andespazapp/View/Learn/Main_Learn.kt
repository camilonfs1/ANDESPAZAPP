package com.andes.andespazapp.View.Learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import com.andes.andespazapp.Model.Learn_Item
import com.andes.andespazapp.R
import com.andes.andespazapp.ViewModel.Adapter.AdapterViewPager_Learn
import kotlinx.android.synthetic.main.activity_main__learn.*

class Main_Learn : AppCompatActivity() {
    var item: ArrayList<Learn_Item>? = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main__learn)

       val adapter = AdapterViewPager_Learn(this )
       var viewPager1 = viewPager2
       viewPager1?.setAdapter(adapter)
       viewPager1!!.setPadding(130, 0, 130, 0)
    }

}