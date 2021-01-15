package com.andes.andespazapp.DB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.andes.andespazapp.Model.User
import com.andes.andespazapp.Model.ddhh
import java.security.AccessControlContext

val DATABASE_NAME ="BASE PRINCIAL"
val TABLE1 ="USUARIO"
val TABLE2 ="DDHH"
val TABLE3 ="VBG"

val COL_NAME = "primero"
val COL_AGE = "segundo"
val COL_ID = "tercero"

class DB_Administrator (context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,1) {

    private var TABLE1 ="USUARIO"
    private var TABLE2 ="DDHH"
    private var TABLE3 ="VBG"



    override fun onCreate(db: SQLiteDatabase?) {
        var table1 = "CREATE TABLE "+TABLE1+" (id INTEGER PRIMARY KEY, product TEXT)"
        var table2 = "CREATE TABLE "+TABLE2+" (id INTEGER PRIMARY KEY, product TEXT)"
        var table3 = "CREATE TABLE "+TABLE3+" (id INTEGER PRIMARY KEY, product TEXT)"

        db?.execSQL(table1)
        db?.execSQL(table2)
        db?.execSQL(table3)
    }



    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS "+TABLE1)
        db?.execSQL("DROP TABLE IF EXISTS "+TABLE2)
        db?.execSQL("DROP TABLE IF EXISTS "+TABLE3)

        onCreate(db)
    }

    fun insertData2(producto1:String,producto2:String,producto3:String):Boolean{
        val db = this.writableDatabase
        var values = ContentValues()
        values.put("product",producto1)
        db.insert(TABLE1, null, values)

        values.put("product",producto2)
        db.insert(TABLE2, null, values)
        
        values.put("product",producto3)
        db.insert(TABLE3, null, values)
        db.close()
        return true
    }

    fun getprice(): ArrayList<String>{
        val db = this.readableDatabase
        val valores = ArrayList<String>()
        val query = "Select * from "+ TABLE1//+ " where id = 123"
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                valores.add(result.getString(result.getColumnIndex("product")))
            } while (result.moveToNext())
        }

        return  valores
    }



    /*fun insertData(user : User){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME,user.name)
        cv.put(COL_AGE,user.key)
        var result = db.insert(TABLE_NAME,null,cv)

        if(result == -1.toLong()){
            Toast.makeText(context,"failet", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context,"Succes", Toast.LENGTH_LONG).show()
        }
    }

    fun readData(id:String):User{
        var res : User = User()

        val db = this.readableDatabase
        val query = "Select * from "+ TABLE_NAME//+ " where id = 123"
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                var user = User()
                user.key = result.getString(result.getColumnIndex(COL_ID)).toString()
                user.name = result.getString(result.getColumnIndex(COL_NAME)).toString()
                res = user
            } while (result.moveToNext())
        }
        result.close()
        db.close()
        return res
    }*/

}