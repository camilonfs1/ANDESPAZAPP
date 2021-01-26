package com.andes.andespazapp.DB

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.andes.andespazapp.Model.Blog_item
import com.andes.andespazapp.Model.User
import com.andes.andespazapp.Model.ddhh
import com.andes.andespazapp.View.CRUD.CRUD_Individual_User
import java.lang.Boolean.FALSE
import java.security.AccessControlContext

val DATABASE_NAME ="BASE PRINCIAL"


class DB_Administrator (context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,1) {

    private var TABLE1 ="user"
    private var TABLE2 ="blog"
    private var TABLE3 ="commentary"


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

    var table_blog = "create table blog(\n" +
            "\tkey INTEGER PRIMARY KEY,\n" +
            "\tname_owner varchar(100),\n" +
            "\ttitle varchar(500),\n" +
            "\tdate integer,\n" +
            "\tnum_commentari integer,\n" +
            "\tavatar_owner integer,\n" +
            "\tcolor varchar(10)\n" +
            ")"

    var table_commentary = "create table commentary(\n" +
            "\tkey INTEGER PRIMARY KEY,\n" +
            "\towner varchar(30),\n" +
            "\tcommentary varchar(500),\n" +
            "\tdate varchar(30),\n" +
            "\tmother_key(10)\n" +
            ")"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(table_user)
        db?.execSQL(table_blog)
        db?.execSQL(table_commentary)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS "+TABLE1)
        db?.execSQL("DROP TABLE IF EXISTS "+TABLE2)
        db?.execSQL("DROP TABLE IF EXISTS "+TABLE3)

        onCreate(db)
    }

    fun insertData_user(user:User):User{
        var db = this.readableDatabase
        var aso = false
        val query = "Select * from "+ TABLE1+ " where key = "+user.identify
        var result1 = db.rawQuery(query,null)
        if(result1.moveToFirst()){
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
            if(andes_asociate=="1"){aso = true}else {aso =false}
            var icono = Integer.parseInt(icon)
            user = User(key,roll,aso,name,identify,region,age,email,icono)
            System.out.println("Usuario ya existente")
            return user
        }else{
            db = this.writableDatabase
            var values = ContentValues()
            values.put("key",user.identify)
            values.put("roll",user.roll)
            values.put("andes_asociate",1)
            values.put("name",user.name)
            values.put("identify",user.identify)
            values.put("region",user.region)
            values.put("age",user.age)
            values.put("email",user.email)
            values.put("icon",user.icon)
            var result = db.insert(TABLE1, null, values)
            if(result == -1.toLong()){
                System.out.println("falla")
                return user
            }else{
                System.out.println("all ok")
                return user
            }

        }
        db.close()
    }
    fun getUser(id:String):Any{
        var aso = false
        val db = this.readableDatabase
        val query = "Select * from "+ TABLE1 + " where key = "+id
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
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
                    if(andes_asociate=="1"){aso = true}else {aso =false}
                    var icono = Integer.parseInt(icon)
                    user = User(key,roll,aso,name,identify,region,age,email,icono)
                    System.out.println("Usuario ya existente")
                    return user
        }
        return false
    }
    fun getprice(): ArrayList<User>{
        val db = this.readableDatabase
        var aso = false

        val valores = ArrayList<User>()
        val query = "Select * from "+ TABLE1//+ " where id = 123"
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
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
                if(andes_asociate=="1"){aso = true}else {aso =false}
                var icono = Integer.parseInt(icon)
                user = User(key,roll,aso,name,identify,region,age,email,icono)
                valores.add(user)
            } while (result.moveToNext())
        }

        return  valores
    }

    fun inserData_Blog(blog : Blog_item): Blog_item{
        var db = this.readableDatabase
        var aso = false
        val query = "Select * from "+ TABLE2+ " where key = "+blog.key
        var result1 = db.rawQuery(query,null)
        if(result1.moveToFirst()){
            var key = result1.getString(result1.getColumnIndex("key"))
            var name_owner = result1.getString(result1.getColumnIndex("name_owner"))
            var title = result1.getString(result1.getColumnIndex("title"))
            var date = result1.getString(result1.getColumnIndex("date")) as Int
            var num_commentari = result1.getString(result1.getColumnIndex("num_commentari")) as Int
            var avatar_owner = result1.getString(result1.getColumnIndex("avatar_owner"))as Int
            var color = result1.getString(result1.getColumnIndex("color"))

             var blog = Blog_item(key,name_owner,title,date,num_commentari,avatar_owner,color)
            System.out.println("Usuario ya existente")
            return blog
        }else{
            db = this.writableDatabase
            var values = ContentValues()
            values.put("key",blog.key)
            values.put("name_owner",blog.name_owner)
            values.put("title",blog.title)
            values.put("date",blog.date)
            values.put("num_commentari",blog.num_commentari)
            values.put("avatar_owner",blog.avatar_owner)
            values.put("color",blog.color)
            var result = db.insert(TABLE1, null, values)
            if(result == -1.toLong()){
                System.out.println("falla")
                return blog
            }else{
                System.out.println("all ok")
                return blog
            }

        }
        db.close()
    }
    fun getBlog(id:String):Any{
        var aso = false
        val db = this.readableDatabase
        val query = "Select * from "+ TABLE1 + " where key = "+id
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            var key = result.getString(result.getColumnIndex("key"))
            var name_owner = result.getString(result.getColumnIndex("name_owner"))
            var title = result.getString(result.getColumnIndex("title"))
            var date = result.getString(result.getColumnIndex("date")) as Int
            var num_commentari = result.getString(result.getColumnIndex("num_commentari")) as Int
            var avatar_owner = result.getString(result.getColumnIndex("avatar_owner"))as Int
            var color = result.getString(result.getColumnIndex("color"))

            var blog = Blog_item(key,name_owner,title,date,num_commentari,avatar_owner,color)
            System.out.println("Usuario ya existente")
            return blog
        }
        return false
    }
    fun insert_commentary(){

    }
    fun getCommentary(){

    }


}