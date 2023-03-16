package com.example.facturasmvc.entidades

import java.io.Serializable

data class Filtros(
    val desde: String = " ", val hasta: String = " ", val cantidad: Double = 0.0,
    val pagadas: Boolean = false, val anuladas: Boolean = false, val cuotaFija: Boolean = false,
    val pendientesDePago: Boolean = false, val planDePago: Boolean = false): Serializable
