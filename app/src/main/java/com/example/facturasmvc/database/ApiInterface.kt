package com.example.facturasmvc.database

import com.example.facturasmvc.entidades.Factura
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    // llamada get a la libreria retrofit
    @GET("facturas")
    fun getData(): Call<MutableList<Factura>>
}