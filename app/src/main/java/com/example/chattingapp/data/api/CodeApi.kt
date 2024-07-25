package com.example.chattingapp.data.api

import com.example.chattingapp.data.model.DialCodeModel
import retrofit2.Response
import retrofit2.http.GET

interface CodeApi {
    @GET("/api/v0.1/countries/codes")
    suspend fun getCodes() : Response<DialCodeModel>
}