package com.andes.andespazapp.ViewModel.CRUD

import android.content.Context
import com.andes.andespazapp.Model.Firebase.User_Firebase
import com.andes.andespazapp.Model.Person

class CRUD_StudentViewModel {
    private var UserDB = User_Firebase()
    lateinit var user : Person

    fun readData(id: String): Person {
        user = UserDB.readDB(id)
        return user
    }

    fun update(user: Person,context: Context){
        UserDB.UpdateDB(user,context)
    }

    fun updatelogin(email:String, pass:String ):Boolean{
       // var confirm =UserDB.UpdateLogin(email,pass)
        return true
    }
}