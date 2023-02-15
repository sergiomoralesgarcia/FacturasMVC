package com.example.facturasmvc

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val mainRepo: MainRepo
    val getFacturaList: LiveData<MutableList<Factura>>
        get() = mainRepo.getFacturaModelLiveData

    init {
        mainRepo = MainRepo()
    }

}