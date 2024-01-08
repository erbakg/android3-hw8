package com.example.android3_hw8

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getCharacters() : Call<ResponseData>
}