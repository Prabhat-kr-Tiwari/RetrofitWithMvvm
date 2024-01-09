package com.example.retrofitmvvm.api

import com.example.retrofitmvvm.model.Data
import com.example.retrofitmvvm.model.Jokes
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/get_memes")
    suspend fun getMemes():Response<Jokes>
}