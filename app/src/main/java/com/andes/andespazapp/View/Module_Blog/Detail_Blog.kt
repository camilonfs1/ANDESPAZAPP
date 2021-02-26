package com.andes.andespazapp.View.Module_Blog

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andes.andespazapp.Model.Commentary
import com.andes.andespazapp.Model.Firebase.Blog_Firebase
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
        var username = intent.getStringExtra("username")

        owner_mother!!.text = owner
        blog_text!!.text = title

        if (color.equals("#fffff")) {
            //linear_top!!.setBackgroundColor(Color.parseColor(color))
        }
//        linear_bottom!!.setBackgroundColor(Color.parseColor(color))

        list_commentary(key)
        //adaptador_C = Adapter_commentary(key)


        image_back!!.setOnClickListener {
            val intent = Intent(this, Blog_main::class.java)
            intent.putExtra("id", id)
            intent.putExtra("username", username)
            startActivity(intent)
        }

        commentary!!.setOnClickListener {
            new_commentary(key!!, username!!, color!!, title!!, id!!, username!!)
        }
    }

    fun recharge(
        key: String,
        owner: String,
        color: String,
        title: String,
        id: String,
        username: String
    ) {
        var intent = Intent(this, Detail_Blog::class.java)

        //Detail object blog
        intent.putExtra("id", id)
        intent.putExtra("key", key)
        intent.putExtra("owner", owner)
        intent.putExtra("color", color)
        intent.putExtra("title", title)
        intent.putExtra("username", username)

        this.startActivity(intent)
    }

    fun new_commentary(
        key: String,
        owner: String,
        color: String,
        title: String,
        id: String,
        username: String
    ) {
        var text = new_commentary!!.text.toString()
        mDatabase = FirebaseDatabase.getInstance()
        var firebase = Blog_Firebase()
        var commentary = Commentary("1", username, text, "1", username)
        firebase.new_commentary(commentary, key)
        recharge(key!!, owner!!, color!!, title!!, id!!, username!!)
        this.finish()
    }

    fun list_commentary(key: String) {
        var commentarys: ArrayList<Commentary> = ArrayList()
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference.child("Commentary").child(key)
        mDatabaseReference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (e in snapshot.children) {
                        var date = e.child("date").value.toString()
                        var owner = e.child("owner").value.toString()
                        var mother_key = e.child("mother_key").value.toString()
                        var commentar = e.child("commentary").value.toString()
                        var key = e.child("key").value.toString()
                        var commentary = Commentary(key, owner, commentar, date, mother_key)
                        commentarys.add(commentary)
                    }
                    adapter_v(commentarys, key)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })

    }

    fun adapter_v(commentarys: ArrayList<Commentary>, key: String) {
        adaptador_C = Adapter_commentary(commentarys, key)
        layoutmanager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        commentaryRecicler?.layoutManager = layoutmanager
        commentaryRecicler?.adapter = adaptador_C
    }


}