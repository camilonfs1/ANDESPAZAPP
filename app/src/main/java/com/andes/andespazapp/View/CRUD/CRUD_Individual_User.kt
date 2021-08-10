package com.andes.andespazapp.View.CRUD

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.*
import androidx.room.PrimaryKey
import com.andes.andespazapp.Model.Person
import com.andes.andespazapp.R
import com.andes.andespazapp.ViewModel.CRUD.CRUD_StudentViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_crud_user.*
import kotlinx.android.synthetic.main.activity_main_register.*
import kotlinx.android.synthetic.main.activity_main_register.icon_11_card
import kotlinx.android.synthetic.main.activity_main_register.icon_12_card
import kotlinx.android.synthetic.main.activity_main_register.icon_13_card
import kotlinx.android.synthetic.main.activity_main_register.icon_14_card
import kotlinx.android.synthetic.main.activity_main_register.icon_21_card
import kotlinx.android.synthetic.main.activity_main_register.icon_22_card
import kotlinx.android.synthetic.main.activity_main_register.icon_23_card
import kotlinx.android.synthetic.main.activity_main_register.icon_24_card
import kotlinx.android.synthetic.main.activity_main_register.icon_31_card
import kotlinx.android.synthetic.main.activity_main_register.icon_32_card
import kotlinx.android.synthetic.main.activity_main_register.icon_33_card
import kotlinx.android.synthetic.main.activity_main_register.icon_34_card

class CRUD_Individual_User : AppCompatActivity() {

    var icon_11: LinearLayout? = null
    var icon_12: LinearLayout? = null
    var icon_13: LinearLayout? = null
    var icon_14: LinearLayout? = null
    var icon_21: LinearLayout? = null
    var icon_22: LinearLayout? = null
    var icon_23: LinearLayout? = null
    var icon_24: LinearLayout? = null
    var icon_31: LinearLayout? = null
    var icon_32: LinearLayout? = null
    var icon_33: LinearLayout? = null
    var icon_34: LinearLayout? = null

    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mUserReference: DatabaseReference? = null
    private var mAuth: FirebaseAuth? = FirebaseAuth.getInstance()
    private var mDatabase2: DatabaseReference? = null
    var card = ArrayList<LinearLayout>()
    var icon: Int = 0

    var txtname: EditText? = null
    var txtid: EditText? = null
    var txtemail: EditText? = null
    var txtpass: EditText? = null
    var txtconfirmpass: EditText? = null

    var btnupdate: Button? = null
    var person: Person? = null
    var spinAge: Spinner? = null
    var icon_select=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud_user)

        txtname = txtNameCrud
        txtid = txtidCrud
        txtemail = txtemailCrud

        btnupdate = BtnUpdateCrud


        icon_11 = icon_11_card
        icon_12 = icon_12_card
        icon_13 = icon_13_card
        icon_14 = icon_14_card
        icon_21 = icon_21_card
        icon_22 = icon_22_card
        icon_23 = icon_23_card
        icon_24 = icon_24_card
        icon_31 = icon_31_card
        icon_32 = icon_32_card
        icon_33 = icon_33_card
        icon_34 = icon_34_card

        card.add(icon_11!!)
        card.add(icon_12!!)
        card.add(icon_13!!)
        card.add(icon_14!!)
        card.add(icon_21!!)
        card.add(icon_22!!)
        card.add(icon_23!!)
        card.add(icon_24!!)
        card.add(icon_31!!)
        card.add(icon_32!!)
        card.add(icon_33!!)
        card.add(icon_34!!)

        var id = intent.getStringExtra("id")
        readDB(id)


        icon_11!!.setOnClickListener {
            icon = 1
            icon_selected(icon_11!!)
        }
        icon_12!!.setOnClickListener {
            icon = 2
            icon_selected(icon_12!!)
        }
        icon_13!!.setOnClickListener {
            icon = 3
            icon_selected(icon_13!!)
        }
        icon_14!!.setOnClickListener {
            icon = 4
            icon_selected(icon_14!!)
        }
        icon_21!!.setOnClickListener {
            icon = 5
            icon_selected(icon_21!!)
        }
        icon_22!!.setOnClickListener {
            icon = 6
            icon_selected(icon_22!!)
        }
        icon_23!!.setOnClickListener {
            icon = 7
            icon_selected(icon_23!!)
        }
        icon_24!!.setOnClickListener {
            icon = 8
            icon_selected(icon_24!!)
        }
        icon_31!!.setOnClickListener {
            icon = 9
            icon_selected(icon_31!!)
        }
        icon_32!!.setOnClickListener {
            icon = 10
            icon_selected(icon_32!!)
        }
        icon_33!!.setOnClickListener {
            icon = 11
            icon_selected(icon_33!!)
        }
        icon_34!!.setOnClickListener {
            icon = 12
            icon_selected(icon_34!!)
        }

        spinAge = spin_age_register1



        btnupdate!!.setOnClickListener {
            var user2: Person
            if (person!!.name != txtname!!.text.toString() || person!!.name != txtid!!.text.toString() || person!!.Colegio != txtemail!!.text.toString() || person!!.icon != icon || spinAge!!.getSelectedItem()
                    .toString() != person!!.age.toString()
            ) {
                icon_select =  iconSelected()!!

                user2 = Person(
                    person!!.roll,
                    person!!.andes_asociate!!,
                    txtname!!.text.toString(),
                    person!!.identify,
                    txtemail!!.text.toString(),
                    spinAge!!.getSelectedItem().toString(),
                    person!!.email,
                    iconSelected()!!
                )
                writeDB(user2)
            }


        }


    }

    fun writeDB(user: Person) {
        mDatabase2 = FirebaseDatabase.getInstance().reference
        mDatabase2 = mDatabase2!!.child("Usuarios").child(user.identify!!.toString())


        mDatabase2!!.child("Nombre").setValue(user.name!!)
        mDatabase2!!.child("Roll").setValue(user.roll!!)
        mDatabase2!!.child("Edad").setValue(user.age!!)
        mDatabase2!!.child("Region").setValue(user.Colegio!!)
        mDatabase2!!.child("Andes").setValue(user.andes_asociate!!)
        mDatabase2!!.child("Email").setValue(user.email!!)
        mDatabase2!!.child("icon").setValue(user.icon!!)
        mDatabase2!!.child("Id").setValue(user.identify!!)
        Toast.makeText(this, "Datos actualizados!!", Toast.LENGTH_LONG).show()


    }

    fun iconSelected():Int{
        icon_11!!.setOnClickListener {
            icon = 1
        }
        icon_12!!.setOnClickListener {
            icon = 2
        }
        icon_13!!.setOnClickListener {
            icon = 3
        }
        icon_14!!.setOnClickListener {
            icon = 4
        }
        icon_21!!.setOnClickListener {
            icon = 5
        }
        icon_22!!.setOnClickListener {
            icon = 6
        }
        icon_23!!.setOnClickListener {
            icon = 7
        }
        icon_24!!.setOnClickListener {
            icon = 8
        }
        icon_31!!.setOnClickListener {
            icon = 9
        }
        icon_32!!.setOnClickListener {
            icon = 10
        }
        icon_33!!.setOnClickListener {
            icon = 11
        }
        icon_34!!.setOnClickListener {
            icon = 12
        }
        icon = icon
        return icon!!
    }

    fun icon(cardSelecte: Int) {
        card[cardSelecte-1].setBackgroundColor(Color.parseColor("#01ff90"))
    }

    fun icon_selected(cardSelecte: LinearLayout) {
        for (i in card) {
            var cardItem = i
            cardItem.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        cardSelecte.setBackgroundColor(Color.parseColor("#01ff90"))
    }

    fun readDB(id: String) {

        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference
        mUserReference = mDatabaseReference!!.child("Usuarios")
        mUserReference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (e in snapshot.children) {

                        var key = e.child("Id").value.toString()
                        if (key == id) {

                            var Nombre = e.child("Nombre").value.toString()
                            var Roll = e.child("Roll").value.toString()
                            var Edad = e.child("Edad").value.toString()
                            var Region = e.child("Colegio").value.toString()
                            var Andes = e.child("Andes").value as Boolean
                            var Email = e.child("Email").value.toString()
                            var icon = Integer.parseInt(e.child("icon").value.toString())
                            var user = Person(
                                Roll!!,
                                Andes!!,
                                Nombre,
                                Integer.parseInt(key.toString()),
                                Region,
                                Edad,
                                Email,
                                icon
                            )
                            putuser(user)
                        }
                    }


                } else {

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        })
    }

    fun putuser(user: Person) {
        this.person = user
        txtname!!.text = Editable.Factory.getInstance().newEditable(user.name)
        txtid!!.text = Editable.Factory.getInstance().newEditable(user.identify.toString())
        txtemail!!.text = Editable.Factory.getInstance().newEditable(user.Colegio)
        spin_age_register1.setSelection(Integer.parseInt(user.age)-7)
        icon_select = user.icon!!.toInt()
        icon = user.icon!!.toInt()
        icon(user.icon!!.toInt())
    }
}