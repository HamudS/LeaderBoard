package com.example.leaderboard

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("leaders.json")
    fun getLeader(): Call<List<Leader>>

    companion object{
        var BASE_URL = "https://gadsapi.herokuapp.com/"

        fun creat(): ApiInterface{

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}