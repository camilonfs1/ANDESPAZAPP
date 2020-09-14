package com.andes.andespazapp.ViewModel.CRUD

import android.content.Context
import com.andes.andespazapp.Model.Firebase.User_Firebase
import com.andes.andespazapp.Model.User

class CRUD_StudentViewModel {
    private var UserDB = User_Firebase()
    private var user = User()

    fun readData(id: String): User {
        user = UserDB.readDB(id)

        return user
    }

    fun update(user: User,context: Context){
        UserDB.UpdateDB(user,context)
    }

    fun updatelogin(email:String, pass:String ):Boolean{
        var confirm =UserDB.UpdateLogin(email,pass)
        return confirm
    }
}