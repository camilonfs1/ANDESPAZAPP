package com.andes.andespazapp.View

import android.util.Log
import com.andes.andespazapp.DB.TABLE_NAME
import com.andes.andespazapp.Model.Api.ApiService
import com.andes.andespazapp.Model.Person
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRest_Connection {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://11057a3620bd.ngrok.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create<ApiService>(ApiService::class.java)

    public fun connection(){
        service.getAllPerson().enqueue(object :Callback<List<Person>>{
            override fun onResponse(call: Call<List<Person>>, response: Response<List<Person>>) {
                val post = response?.body()
                System.out.println(Gson().toJson(post))
            }

            override fun onFailure(call: Call<List<Person>>, t: Throwable) {
                t?.printStackTrace()
            }


        })
    }

}