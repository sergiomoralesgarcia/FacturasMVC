package com.example.facturasmvc.database

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.facturasmvc.entidades.Factura
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepo {
    private val apiService: ApiInterface = Service.getApiService

    companion object{
        private const val TAG = "MainRepo"
    }

    val getFacturaModelLiveData: MutableLiveData<MutableList<Factura>>
    get(){
        val data: MutableLiveData<MutableList<Factura>> = MutableLiveData<MutableList<Factura>>()
        apiService.getData().enqueue(object : Callback<MutableList<Factura>> {
            override fun onResponse(
                call: Call<MutableList<Factura>>,
                response: Response<MutableList<Factura>>
            ) {
                Log.e(TAG, "onResponse: " + response.code() )
                if (response.isSuccessful){
                    data.value = response.body()
                }
                else {
                    data.value = null
                }
            }

            override fun onFailure(call: Call<MutableList<Factura>>, t: Throwable) {
                Log.d(TAG, "onFailure: "+t.message)
                data.value = null
            }
        })
        return data
    }
}