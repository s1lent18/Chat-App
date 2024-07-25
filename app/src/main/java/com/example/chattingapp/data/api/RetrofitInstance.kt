package com.example.chattingapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASEURL = "https://countriesnow.space/"

    private fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val codeapi: CodeApi = getInstance().create(CodeApi::class.java)
}