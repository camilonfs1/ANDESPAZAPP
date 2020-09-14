package com.andes.andespazapp.Model.Firebase

import android.content.Context
import com.andes.andespazapp.Model.User

class User_Firebase {
    var user = User()
    fun readDB(id : String): User    {
        user = User(id , "estudiante",true , "camilo vargas", "1", "23", "1", "camilo@gmail.com",8)
        return user
    }

    fun UpdateDB(user:User, context: Context){

    }

    fun UpdateLogin(email:String, pass:String):Boolean{
        if(pass == ""){

        }else{

        }
        return true
    }
}