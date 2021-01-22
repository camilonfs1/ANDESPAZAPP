package com.andes.andespazapp.DB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.andes.andespazapp.Model.User
import com.andes.andespazapp.Model.ddhh
import java.lang.Boolean.FALSE
import java.security.AccessControlContext

val DATABASE_NAME ="BASE PRINCIAL"


class DB_Administrator (context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,1) {

    private var TABLE1 ="user"
    private var TABLE2 ="DDHH"
    private var TABLE3 ="VBG"

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

    var table2 = "CREATE TABLE "+TABLE2+" (id INTEGER PRIMARY KEY, product TEXT)"
    var table3 = "CREATE TABLE "+TABLE3+" (id INTEGER PRIMARY KEY, product TEXT)"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(table_user)
        db?.execSQL(table2)
        db?.execSQL(table3)
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
    fun gerUser(id:String,flag : Int):Any{
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


}