package com.andes.andespazapp.Model.Firebase

import com.andes.andespazapp.Model.ddhh
import com.google.firebase.database.FirebaseDatabase

class DDHH_firebase {


    fun new_ddhh(ddhh: ddhh) {
        val ref = FirebaseDatabase.getInstance().getReference("/DDHH").push()
        ref.setValue(ddhh)
    }
}