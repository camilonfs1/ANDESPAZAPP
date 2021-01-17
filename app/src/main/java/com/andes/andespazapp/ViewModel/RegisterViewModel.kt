package com.andes.andespazapp.ViewModel

import android.content.Context
import com.andes.andespazapp.Model.Firebase.Register_Firebase
import com.andes.andespazapp.Model.User

class RegisterViewModel {
    var firesRegister = Register_Firebase()
    fun writebd(user: User, pass: String, context: Context) {firesRegister.RegisterUser(user,context,pass)}
    fun writelocal(user:User, context:Context){
        firesRegister.reg_local(context,user)
    }


}