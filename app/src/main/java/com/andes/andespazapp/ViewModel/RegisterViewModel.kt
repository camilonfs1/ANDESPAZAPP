package com.andes.andespazapp.ViewModel

import android.content.Context
import com.andes.andespazapp.Model.Firebase.Register_Firebase
import com.andes.andespazapp.Model.Person

class RegisterViewModel {
    var firesRegister = Register_Firebase()
    fun writebd(user: Person, pass: String, context: Context, querer: Boolean) {firesRegister.RegisterUser(user,context,pass, querer)}
    fun writelocal(person:Person, context:Context){
        firesRegister.reg_local(context,person)
    }


}