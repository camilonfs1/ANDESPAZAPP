package com.andes.andespazapp.Model.Firebase

import com.andes.andespazapp.Model.Course

class Courses_Firebase {
    var items: ArrayList<Course>? = ArrayList()
    fun read(): ArrayList<Course>{
        items!!.add(Course(0,"Curso : ","0","0"))
        items!!.add(Course(1,"curso 1","1","1"))
        items!!.add(Course(2,"curso 2","2","2"))
        items!!.add(Course(3,"curso 3","3","3"))
        items!!.add(Course(4,"curso 4","4","4"))
        items!!.add(Course(5,"curso 5","5","5"))
        items!!.add(Course(6,"curso 6","6","6"))

        return items!!
    }

    fun write(curso: Course){

    }


}