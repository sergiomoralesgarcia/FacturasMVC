package com.example.facturasmvc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.facturasmvc.databinding.ItemFacturaBinding

class FacturaListAdapter(var context: Context, var facturaModelList: MutableList<Factura>):
    RecyclerView.Adapter<FacturaListAdapter.MyViewModel>(){

    var onItemClick : ((Factura) -> Unit)? = null

    inner class MyViewModel(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var importe: TextView
        var date: TextView
        var estado: TextView

        init {
            importe = itemView.findViewById(R.id.importeOrdenacion)
            date = itemView.findViewById(R.id.fecha)
            estado = itemView.findViewById(R.id.descEstado)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        val inflador = LayoutInflater.from(parent.context)
        val binding = ItemFacturaBinding.inflate(inflador,parent,false)
        return MyViewModel(LayoutInflater.from(context).inflate(R.layout.item_factura,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        holder.importe.text = facturaModelList[position].importeOrdenacion.toString()
        holder.estado.text = facturaModelList[position].descEstado
        holder.date.text = facturaModelList[position].fecha

        // presionar en el contenedor del adapter
        val factura = facturaModelList[position]
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(factura)
        }
    }

    override fun getItemCount(): Int = facturaModelList.size
}