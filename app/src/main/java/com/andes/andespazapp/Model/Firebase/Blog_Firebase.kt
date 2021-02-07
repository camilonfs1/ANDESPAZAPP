package com.andes.andespazapp.Model.Firebase

import com.andes.andespazapp.DB.DB_Administrator
import com.andes.andespazapp.Model.Blog_item
import com.andes.andespazapp.Model.Commentary
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class Blog_Firebase {

    var LocalDB: DB_Administrator? = null


    private var FireData: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null
    private var LocalDataBase: DatabaseReference? = null

    var items: ArrayList<Blog_item>? = ArrayList()
    var commen: ArrayList<Commentary>? = ArrayList()


    private var mDatabase: FirebaseDatabase? = null
    private var mDatabaseReference: DatabaseReference? = null



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
        items!!.add(Blog_item("2", "camilo vargas1", "DEBATE ANDES segunda", 1, 1, 1, "#fffff"))
        items!!.add(Blog_item("3", "camilo vargas2", "DEBATE ANDES tercera", 1, 1, 1, "#fffff"))
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

    //Return if id exits or not in local db
    fun ReadLocalDB_id(id: Int): Any {
        //Read local db
        var request = LocalDB!!.consult_blogId(id)
        return request
    }

    //Return item by id in firebase
    fun ReadObjectFirebase(id: Int): Blog_item {
        var items_list = FIREBASE()
        for (item in items_list){
            if(Integer.parseInt(item.key.toString()) == id){
                return item
            }
        }
        return null!!
    }

    //Create list of id to consult local database
    fun ReadFirebaseDB_id(): ArrayList<Int> {
        var ids: ArrayList<Int>? = ArrayList()
        var items_list = FIREBASE()
        for (item in items_list){
            ids!!.add(Integer.parseInt(item.key.toString()))
        }
        return ids!!
    }

    //Write item in local db
    fun WriteLocalDB(item: Blog_item) {
        LocalDB!!.write_blogitem(item)
    }

    fun get_blogItems(): ArrayList<Blog_item> {
        var ids: ArrayList<Int>? = ArrayList()

        //obtein id list
        ids = ReadFirebaseDB_id()

        var not_exits_ids: ArrayList<Int>? = ArrayList()

        //consult local database
        for (id: Int in ids!!) {
            var item = ReadLocalDB_id(id)
            if (item !is Blog_item) {//Exist
                items!!.add(ReadLocalDB_id(id) as Blog_item)
            } else if (item !is Int) {//Not exist
                not_exits_ids!!.add(item as Int)
            }
        }

        //Read firebase for new blog items
        var news: ArrayList<Blog_item>? = ArrayList()
        for (id: Int in not_exits_ids!!) {
            news!!.add(ReadObjectFirebase(id))
            items!!.add(ReadObjectFirebase(id))
        }

        //Write new
        for (item: Blog_item in news!!) {
            WriteLocalDB(item)
        }

        return items!!
    }

    fun getBlogDetail(): ArrayList<Commentary>{

        commen= ArrayList()
        commen!!.add(Commentary("1", "camilo", "comentario 1", "2", "1"))
        commen!!.add(Commentary("1", "sergio", "comentario 1", "3", "1"))
        commen!!.add(Commentary("1", "loany", "comentario 1", "1", "1"))
        commen!!.add(Commentary("1", "mario", "comentario 1", "1", "1"))
        commen!!.add(Commentary("1", "junito", "comentario 1", "1", "1"))
        commen!!.add(Commentary("1", "maria", "comentario 1", "1", "1"))
        commen!!.add(Commentary("1", "marianita", "comentario que no debe salir", "1", "2"))

        return commen!!
    }
}