package com.andes.andespazapp.Model.Firebase

import android.content.Context
import com.andes.andespazapp.DB.DB_Administrator
import com.andes.andespazapp.Model.Blog_item
import com.andes.andespazapp.Model.Commentary
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Blog_Firebase {


    private var FireData: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null
    private var LocalDataBase: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseReference: DatabaseReference? = null

    var context: Context? = null
    var items: ArrayList<Blog_item>? = ArrayList()
    var returne: ArrayList<Blog_item>? = ArrayList()
    var commen: ArrayList<Commentary>? = ArrayList()
    var LocalDB: DB_Administrator? = null

    fun new_blogItem(blogItem: Blog_item){

        mDatabase = FirebaseDatabase.getInstance()

        mDatabaseReference = mDatabase!!.reference!!.child("Qualifications").child(blogItem.key.toString())
        mDatabaseReference!!.child("key").setValue(blogItem.key.toString())
        mDatabaseReference!!.child("name_owner").setValue(blogItem.name_owner.toString())
        mDatabaseReference!!.child("tittle").setValue(blogItem.title.toString())
        mDatabaseReference!!.child("date").setValue(blogItem.date.toString())
        mDatabaseReference!!.child("num_commentari").setValue(blogItem.num_commentari.toString())
        mDatabaseReference!!.child("avatar_owner").setValue(blogItem.avatar_owner.toString())
        mDatabaseReference!!.child("color").setValue(blogItem.color.toString())

    }


    fun get_blogItems(context: Context, flag: Int): ArrayList<Blog_item> {
        var ids: ArrayList<Int>? = ArrayList()
        var not_exits_ids: ArrayList<Int>? = ArrayList()
        var news: ArrayList<Blog_item>? = ArrayList()

        if (flag == 0) {

            //Obtein id list
            ids = ReadFirebaseDB_id()

            //consult local database
            for (id in ids!!) {
                var item = ReadLocalDB_id(id, context)
                if (item is Blog_item) {//Exist
                } else if (item == 0) {//Not exist
                    not_exits_ids!!.add(id)
                }
            }

            //Read firebase for new blog items
            for (id in not_exits_ids!!) {
                var item_uax = ReadObjectFirebase(id)
                if (item_uax.key != "-1") {
                    news!!.add(item_uax)
                } else {
                }
            }

            //Write new
            for (item: Blog_item in news!!) {
                WriteLocalDB(item)
            }
        }
        returne = ReadLocalDB(context)
        return returne!!
    }

    //Create list of id to consult local database
    fun ReadFirebaseDB_id(): ArrayList<Int> {
        var ids: ArrayList<Int>? = ArrayList()
        var items_list = FIREBASE()

        for (item in items_list) {
            ids!!.add(Integer.parseInt(item.key.toString()))
        }

        return ids!!
    }

    //Return if id exits or not in local db
    fun ReadLocalDB_id(id: Int, context: Context): Any {
        //Read local db
        LocalDB = DB_Administrator(context)
        var request = LocalDB!!.consult_blogId(id)
        return request
    }

    //Return item by id in firebase
    fun ReadObjectFirebase(id: Int): Blog_item {
        var items_list = FIREBASE()
        for (item in items_list) {
            if (item.key.toString() != "") {
                var id_aux = Integer.parseInt(item.key.toString())
                if (id_aux == id) {
                    return item
                }
            }
        }
        var item: Blog_item? = Blog_item("-1", "", "", 0, 0, 0, "--")
        return item!!
    }

    //Write item in local db
    fun WriteLocalDB(item: Blog_item) {
        LocalDB!!.write_blogitem(item)
    }


    //REad item in local db
    fun ReadLocalDB(context: Context): ArrayList<Blog_item> {
        LocalDB = DB_Administrator(context)
        return LocalDB!!.getallBlog()
    }


    fun getBlogDetail(): ArrayList<Commentary> {

        commen = ArrayList()
        commen!!.add(Commentary("1", "camilo", "comentario 1", "2", "1"))
        commen!!.add(Commentary("1", "sergio", "comentario 1", "3", "1"))
        commen!!.add(Commentary("1", "loany", "comentario 1", "1", "1"))
        commen!!.add(Commentary("1", "mario", "comentario 1", "1", "1"))
        commen!!.add(Commentary("1", "junito", "comentario 1", "1", "1"))
        commen!!.add(Commentary("1", "maria", "comentario 1", "1", "1"))
        commen!!.add(Commentary("1", "marianita", "comentario que no debe salir", "1", "2"))

        return commen!!
    }


    fun FIREBASE(): ArrayList<Blog_item> {
        items!!.add(
            Blog_item(
                "1",
                "camilo vargas0",
                "Discusión numero uno, propuesta para el desarrollo del tema propuesta",
                1,
                1,
                1,
                "#fffff"
            )
        )
        items!!.add(
            Blog_item(
                "2",
                "camilo vargas1",
                "DEBATE ANDES segunda",
                1, 1,
                1, "#fffff"
            )
        )
        items!!.add(
            Blog_item(
                "3",
                "camilo vargas2",
                "DEBATE ANDES tercera", 1, 1, 1, "#fffff"
            )
        )

        items!!.add(Blog_item("4", "camilo vargas3", "DEBATE ANDES cuarta", 1, 1, 1, "#fffff"))
        items!!.add(Blog_item("5", "camilo vargas4", "DEBATE ANDES quinta", 1, 1, 1, "#fffff"))
        items!!.add(
            Blog_item(
                "6",
                "camilo vargas5",
                "Discusión numero uno, propuesta para el desarrollo del tema propuesta",
                1,
                1,
                1,
                "#fffff"
            )
        )
        items!!.add(Blog_item("7", "camilo vargas6", "DEBATE ANDES segunda", 1, 1, 1, "#fffff"))
        items!!.add(Blog_item("8", "camilo vargas7", "DEBATE ANDES tercera", 1, 1, 1, "#fffff"))
        items!!.add(Blog_item("9", "camilo vargas8", "DEBATE ANDES cuarta", 1, 1, 1, "#fffff"))
        items!!.add(Blog_item("10", "camilo vargas9", "DEBATE ANDES quinta", 1, 1, 1, "#fffff"))
        items!!.add(
            Blog_item(
                "11",
                "camilo vargas10",
                "Discusión numero uno, propuesta para el desarrollo del tema propuesta",
                1,
                1,
                1,
                "#fffff"
            )
        )
        items!!.add(Blog_item("12", "camilo vargas11", "DEBATE ANDES segunda", 1, 10, 1, "#fffff"))
        items!!.add(Blog_item("13", "camilo vargas12", "DEBATE ANDES tercera", 1, 1, 1, "#fffff"))
        items!!.add(Blog_item("14", "camilo vargas13", "DEBATE ANDES cuarta", 6, 1, 1, "#fffff"))
        items!!.add(Blog_item("15", "camilo vargas14", "DEBATE ANDES quinta", 1, 1, 1, "#fffff"))

        return items!!
    }
}