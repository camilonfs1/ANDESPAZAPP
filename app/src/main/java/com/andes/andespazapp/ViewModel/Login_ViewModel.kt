package com.andes.andespazapp.ViewModel

import android.content.Context
import com.andes.andespazapp.Model.Firebase.Learn_Firebase
import com.andes.andespazapp.Model.Firebase.Login_Firebase

class Login_ViewModel {
    private var login = Login_Firebase()

    fun login_funtion(context: Context, Email :String, Pass: String){
        login.login(context,Email,Pass)
    }
}