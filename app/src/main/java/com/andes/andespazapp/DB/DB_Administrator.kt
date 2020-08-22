package com.andes.andespazapp.DB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.andes.andespazapp.Model.User
import java.security.AccessControlContext

val DATABASE_NAME = "MyD"
val TABLE_NAME = "Users"
val COL_NAME = "name"
val COL_AGE = "age"
val COL_ID = "id"

class DB_Administrator (context: Context): SQLiteOpenHelper(context,DATABASE_NAME,null,1) {
    var context: Context?=null
    init {
        this.context  = context
    }
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE "+ TABLE_NAME+ " ( " +
                COL_ID   + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " VARCHAR (256), "+
                COL_AGE  + " INTEGER )"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertData(user : User){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME,user.name)
        cv.put(COL_AGE,user.id)
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
                user.id = result.getString(result.getColumnIndex(COL_ID)).toString()
                user.name = result.getString(result.getColumnIndex(COL_NAME)).toString()
                res = user
            } while (result.moveToNext())
        }
        result.close()
        db.close()
        return res
    }

}