package com.example.facturasmvc

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("questions")
    fun getData(): Call<MutableList<Factura>>
}