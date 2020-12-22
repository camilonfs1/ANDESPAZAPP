package com.andes.andespazapp.Model.Api

import com.andes.andespazapp.Model.Person
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("/person")
    fun getAllPerson(): Call<List<Person>>

    @GET("person/{id}")
    fun getPersonById(@Path("id") id : Int): Call<Person>

    @POST("person/{id}")
    fun editPersonById(@Path("id") id : Int, @Body person: Person?): Call<Person>



}