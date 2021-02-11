package com.andes.andespazapp.DB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.andes.andespazapp.Model.Blog_item
import com.andes.andespazapp.Model.User

val DATABASE_NAME = "BASE PRINCIAL"


class DB_Administrator(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    private var TABLE1 = "user"
    private var TABLE2 = "blog"
    private var TABLE3 = "comentary"


    var table_user = "create table user (\n" +
            "\tkey INTEGER PRIMARY KEY,\n" +
            "\troll varchar(10) not null,\n" +
            "\tandes_asociate varchar(25) not null,\n" +
            "\tname varchar(250) not null,\n" +
            "\tidentify varchar(15) not null,\n" +
            "\tregion varchar(100) not null,\n" +
            "\tage integer not null,\n" +
            "\temail varchar(250) not null,\n" +
            "\ticon integer not null\n" +
            ")"

    var table_blog = "create table blog (\n" +
            "\tkey INTEGER PRIMARY KEY,\n" +
            "\tname_owner varchar(100),\n" +
            "\ttitle varchar(500),\n" +
            "\tdate integer,\n" +
            "\tnum_commentari integer,\n" +
            "\tavatar_owner integer,\n" +
            "\tcolor varchar(10)\n" +
            ")"

    var table_commentary = "create table comentary (\n" +
            "\tkey INTEGER PRIMARY KEY,\n" +
            "\towner varchar(30),\n" +
            "\tcommentary varchar(250),\n" +
            "\tdate varchar (30),\n" +
            "\tmother_key INTEGER(10)\n" +
            ")"


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(table_user)
        db?.execSQL(table_blog)
        db?.execSQL(table_commentary)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE1)
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE2)
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE3)

        onCreate(db)
    }

    fun insertData_user(user: User): User {
        var db = this.readableDatabase
        var aso = false
        val query = "Select * from " + TABLE1 + " where key = " + user.identify
        var result1 = db.rawQuery(query, null)
        if (result1.moveToFirst()) {
            var user = User()
            var key = result1.getString(result1.getColumnIndex("key"))
            var roll = result1.getString(result1.getColumnIndex("name"))
            var andes_asociate = result1.getString(result1.getColumnIndex("andes_asociate"))
            var name = result1.getString(result1.getColumnIndex("name"))
            var identify = result1.getString(result1.getColumnIndex("identify"))
            var region = result1.getString(result1.getColumnIndex("region"))
            var age = result1.getString(result1.getColumnIndex("age"))
            var email = result1.getString(result1.getColumnIndex("email"))
            var icon = result1.getString(result1.getColumnIndex("icon"))
            if (andes_asociate == "1") {
                aso = true
            } else {
                aso = false
            }
            var icono = Integer.parseInt(icon)
            user = User(key, roll, aso, name, identify, region, age, email, icono)
            System.out.println("Usuario ya existente")
            return user
        } else {
            db = this.writableDatabase
            var values = ContentValues()
            values.put("key", user.identify)
            values.put("roll", user.roll)
            values.put("andes_asociate", 1)
            values.put("name", user.name)
            values.put("identify", user.identify)
            values.put("region", user.region)
            values.put("age", user.age)
            values.put("email", user.email)
            values.put("icon", user.icon)
            var result = db.insert(TABLE1, null, values)
            if (result == -1.toLong()) {
                System.out.println("falla")
                return user
            } else {
                System.out.println("all ok")
                return user
            }

        }
        db.close()
    }

    fun getUser(id: String): Any {
        var aso = false
        val db = this.readableDatabase
        val query = "Select * from " + TABLE1 + " where key = " + id
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            var key = result.getString(result.getColumnIndex("key"))
            var roll = result.getString(result.getColumnIndex("name"))
            var andes_asociate = result.getString(result.getColumnIndex("andes_asociate"))
            var name = result.getString(result.getColumnIndex("name"))
            var identify = result.getString(result.getColumnIndex("identify"))
            var region = result.getString(result.getColumnIndex("region"))
            var age = result.getString(result.getColumnIndex("age"))
            var email = result.getString(result.getColumnIndex("email"))
            var icon = result.getString(result.getColumnIndex("icon"))
            if (andes_asociate == "1") {
                aso = true
            } else {
                aso = false
            }
            var icono = Integer.parseInt(icon)
            var user = User(key, roll, aso, name, identify, region, age, email, icono)
            return user
        }
        return false
    }

    fun getprice(): ArrayList<User> {
        val db = this.readableDatabase
        var aso = false

        val valores = ArrayList<User>()
        val query = "Select * from " + TABLE1//+ " where id = 123"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                var user = User()
                var key = result.getString(result.getColumnIndex("key"))
                var roll = result.getString(result.getColumnIndex("name"))
                var andes_asociate = result.getString(result.getColumnIndex("andes_asociate"))
                var name = result.getString(result.getColumnIndex("name"))
                var identify = result.getString(result.getColumnIndex("identify"))
                var region = result.getString(result.getColumnIndex("region"))
                var age = result.getString(result.getColumnIndex("age"))
                var email = result.getString(result.getColumnIndex("email"))
                var icon = result.getString(result.getColumnIndex("icon"))
                if (andes_asociate == "1") {
                    aso = true
                } else {
                    aso = false
                }
                var icono = Integer.parseInt(icon)
                user = User(key, roll, aso, name, identify, region, age, email, icono)
                valores.add(user)
            } while (result.moveToNext())
        }

        return valores
    }

    //--------------------------------------->  Blog
    fun consult_blogId(id: Int): Any {
        var db = this.readableDatabase
        val query = "Select * from " + TABLE2 + " where key = " + id
        val result = db.rawQuery(query, null)
        //if exit, return item
        if (result.moveToFirst()) {

            var key = result.getString(result.getColumnIndex("key"))
            var name_owner = result.getString(result.getColumnIndex("name_owner"))
            var title = result.getString(result.getColumnIndex("title"))
            var date = result.getString(result.getColumnIndex("date"))
            var num_commentari = result.getString(result.getColumnIndex("num_commentari"))
            var avatar_owner = result.getString(result.getColumnIndex("avatar_owner"))
            var color = result.getString(result.getColumnIndex("color"))

            var item = Blog_item(
                key,
                name_owner,
                title,
                Integer.parseInt(date.toString()),
                Integer.parseInt(num_commentari.toString()),
                Integer.parseInt(avatar_owner.toString()),
                color
            )
            System.out.println("Existe")
            db.close()
            return item!!

        }//If not exit return 0
        else {
            db.close()
            return 0
        }
        db.close()
        return 0
    }

    //Only write blog item in local db
    fun write_blogitem(item: Blog_item) {
        var db = this.readableDatabase
        db = this.writableDatabase
        var values = ContentValues()
        values.put("key", item.key)
        values.put("name_owner", item.name_owner)
        values.put("title", item.title)
        values.put("date", item.date)
        values.put("num_commentari", item.num_commentari)
        values.put("avatar_owner", item.avatar_owner)
        values.put("color", item.color)

        var result = db.insert(TABLE2, null, values)
        if (result == -1.toLong()) {
            System.out.println("falla")
        } else {
            System.out.println("all ok")
        }

        db.close()
    }


    fun getallBlog(): ArrayList<Blog_item> {
        val db = this.readableDatabase
        var aso = false
        val items = ArrayList<Blog_item>()
        val query = "Select * from " + TABLE2//+ " where id = 123"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                var key = result.getString(result.getColumnIndex("key"))
                var name_owner = result.getString(result.getColumnIndex("name_owner"))
                var title = result.getString(result.getColumnIndex("title"))
                var date = result.getString(result.getColumnIndex("date"))
                var num_commentari = result.getString(result.getColumnIndex("num_commentari"))
                var avatar_owner = result.getString(result.getColumnIndex("avatar_owner"))
                var color = result.getString(result.getColumnIndex("color"))

                var item = Blog_item(
                    key,
                    name_owner,
                    title,
                    Integer.parseInt(date.toString()),
                    Integer.parseInt(num_commentari.toString()),
                    Integer.parseInt(avatar_owner.toString()),
                    color
                )
                items.add(item)
            } while (result.moveToNext())
        }
        return items
    }

    fun maxcommentarynum(): Int {
        val db = this.readableDatabase
        val query = "Select key from " + TABLE2
        val result = db.rawQuery(query, null)
        var aux = 0
        if (result.moveToFirst()) {
            do {
                var key = result.getString(result.getColumnIndex("key"))
                if(Integer.parseInt(key.toString()) > aux){
                    aux =  Integer.parseInt(key.toString())
                }
            } while (result.moveToNext())
        }
        return aux
    }

}


