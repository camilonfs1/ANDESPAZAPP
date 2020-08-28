package com.andes.andespazapp.Model.Firebase

import com.andes.andespazapp.Model.Course

class Courses_Firebase {
    var items: ArrayList<Course>? = ArrayList()
    fun read(): ArrayList<Course>{
        items!!.add(Course("curso 1","1","1"))
        items!!.add(Course("curso 2","2","2"))
        items!!.add(Course("curso 3","3","3"))
        items!!.add(Course("curso 4","4","4"))
        items!!.add(Course("curso 5","5","5"))
        items!!.add(Course("curso 6","6","6"))

        return items!!
    }

    fun write(curso: Course){

    }

    /*private fun readCoursesDb(keyTeacher: String,nameTeacher: String) {
        val adapter = GroupAdapter<GroupieViewHolder>()
        mDatabaseReference =
            mDatabase!!.reference.child("Courses")//Create child Courses in firebase database
        mDatabaseReference!!.addValueEventListener(object : ValueEventListener {
            //call "Courses" child in database firebase
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                CoursesList.clear()
                if (p0.exists()) {
                    for (e in p0.children) {
                        var cours = Courses(
                            e.child("Name").getValue().toString()
                        )
                        var teacher =
                            Courses(
                                e.child("Teacher").getValue().toString()
                            )

                        if (teacher.name.equals(nameTeacher + "")) {
                            CoursesList.add(cours.name)
                        }
                    }
                    for (value in 0..CoursesList.size - 1) {
                        mDatabaseReference =
                            mDatabase!!.reference.child("Courses").child(CoursesList[value] + "")
                                .child("Students")
                        mDatabaseReference!!.addValueEventListener(object : ValueEventListener {
                            //call "User" child in database firebase
                            override fun onCancelled(p0: DatabaseError) {
                            }

                            override fun onDataChange(p0: DataSnapshot) {
                                for (e in p0.children) {
                                    var name = e.child("Name").getValue().toString()
                                    var email = e.child("Email").getValue().toString()
                                    var id = e.child("Id").getValue().toString()
                                    var roll = e.child("Roll").getValue().toString()
                                    adapter.add(
                                        UserItem(
                                            User(
                                                e.key.toString(),
                                                name,
                                                email,
                                                id,
                                                roll,
                                                CoursesList[value]
                                            )
                                        )
                                    )
                                }
                            }
                        })
                    }
                }
                adapter.setOnItemClickListener { item, view ->
                    val UserItem = item as UserItem
                    val intent = Intent(view.context,
                        ChatLogActivity::class.java)
                    intent.putExtra("UserKeyA",keyTeacher)
                    intent.putExtra("userNameA",nameTeacher)
                    intent.putExtra("userNameB",UserItem.user.name)
                    intent.putExtra("UserKeyB",UserItem.user.key)
                    intent.putExtra("Roll","Teacher")
                    startActivity(intent )
                    finish()
                }
            }
        })
        RecyNewMen!!.adapter = adapter
    }*/
}