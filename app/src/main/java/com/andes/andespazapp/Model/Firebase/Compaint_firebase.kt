package com.andes.andespazapp.Model.Firebase

import com.andes.andespazapp.Model.Complaint
import com.google.firebase.database.FirebaseDatabase

class Compaint_firebase {
    fun new_complaint(complaint: Complaint) {
        val ref = FirebaseDatabase.getInstance().getReference("/Complaint").push()
        ref.setValue(complaint)
    }
}