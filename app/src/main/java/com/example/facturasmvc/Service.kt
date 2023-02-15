package com.example.facturasmvc

object Service {
    private const val BASE_URL = "https://private-4826e0-facturasviewnext.apiary-mock.com/"
    val getApiService: ApiInterface
    get() = Retrofit.getRetrofitClient(BASE_URL).create(ApiInterface::class.java)
}