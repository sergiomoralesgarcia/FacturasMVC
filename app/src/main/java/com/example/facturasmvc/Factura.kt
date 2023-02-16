package com.example.facturasmvc

import androidx.room.Entity

@Entity
data class Factura(
    val descEstado: String,
    val fecha: String,
    val importeOrdenacion: Double
)