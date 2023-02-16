package com.example.facturasmvc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.facturasmvc.databinding.ItemFacturaBinding

class AppAdapter(var context: Context, var datos: MutableList<Factura>):
    RecyclerView.Adapter<AppAdapter.AppHolder>(){

    var onItemClick : ((Factura) -> Unit)? = null

    inner class AppHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var importe: TextView
        var date: TextView
        var estado: TextView

        init {
            importe = itemView.findViewById(R.id.importeOrdenacion)
            date = itemView.findViewById(R.id.fecha)
            estado = itemView.findViewById(R.id.descEstado)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppHolder {
        val inflador = LayoutInflater.from(parent.context)
        val binding = ItemFacturaBinding.inflate(inflador,parent,false)
        return AppHolder(LayoutInflater.from(context).inflate(R.layout.item_factura,parent,false))
    }

    override fun onBindViewHolder(holder: AppHolder, position: Int) {
        holder.importe.text = datos[position].importeOrdenacion.toString()
        holder.estado.text = datos[position].descEstado
        holder.date.text = datos[position].fecha

        // presionar en el contenedor del adapter
        val factura = datos[position]
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(factura)
        }
    }

    override fun getItemCount(): Int = datos.size
}