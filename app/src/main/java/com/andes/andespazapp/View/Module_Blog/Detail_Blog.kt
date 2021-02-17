package com.andes.andespazapp.View.Module_Blog

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andes.andespazapp.R
import com.andes.andespazapp.ViewModel.Adapter.Adapter_commentary
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_detail__blog.*

class Detail_Blog : AppCompatActivity() {

    var image_back: ImageView? = null
    var commentaryRecicler: RecyclerView? = null
    var adaptador_C: Adapter_commentary? = null
    var layoutmanager: RecyclerView.LayoutManager? = null
    var owner_mother: TextView? = null
    var blog_text: TextView? = null
    var linear_top: LinearLayout? = null
    var linear_bottom: LinearLayout? = null

    var commentary: Button? = null
    var new_commentary: EditText? = null

    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseReference: DatabaseReference? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail__blog)

        commentaryRecicler = recycler_commentary
        owner_mother = txt_owner
        blog_text = txt_blog_mother
        image_back = image_home
        commentary = btn_commentary

        linear_top = linear_topr
        linear_bottom = linear_botton
        new_commentary = txt_commentary

        var key = intent.getStringExtra("key").toString()
        var owner = intent.getStringExtra("owner")
        var color = intent.getStringExtra("color")
        var title = intent.getStringExtra("title")
        var id = intent.getStringExtra("id")





        owner_mother!!.text = owner
        blog_text!!.text = title
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

        commentary!!.setOnClickListener {
            new_commentary(id!! ,key!!)
        }
    }

    fun new_commentary(id: String,key: String) {
        var text = new_commentary!!.text.toString()
        var nums: ArrayList<String> = ArrayList()
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference.child("Blog")
        mDatabaseReference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (e in snapshot.children) {
                        var key1 = e.child("key")
                        //nums!!.add(key)
                        System.out.println("---->" + key1+ "---" +key)
                    }
                    create(nums, id, text)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }

    fun create(nums: ArrayList<String>, id: String, text: String) {

        for (i in nums) {
            System.out.println("---->" + i)
        }
    }
}