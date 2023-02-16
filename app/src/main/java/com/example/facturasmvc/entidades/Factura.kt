package com.example.facturasmvc.entidades

import androidx.room.Entity

@Entity
data class Factura(
    val descEstado: String,
    val fecha: String,
    val importeOrdenacion: Double
)