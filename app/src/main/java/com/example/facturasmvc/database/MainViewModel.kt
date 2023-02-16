package com.example.facturasmvc.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.facturasmvc.entidades.Factura

class MainViewModel : ViewModel() {
    private val mainRepo: MainRepo = MainRepo()
    val getFacturaList: LiveData<MutableList<Factura>>
        get() = mainRepo.getFacturaModelLiveData

}