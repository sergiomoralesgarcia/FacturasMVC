package com.example.facturasmvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facturasmvc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptador: FacturaListAdapter

    lateinit var llContenedor: LinearLayout
    lateinit var llCargando: LinearLayout

    var mainActivityViewModel: MainViewModel? = null
    var recyclerView: RecyclerView? = null
    var adapter: FacturaListAdapter? = null
    var layoutManager: LinearLayoutManager? = null
    var dialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Valores de la animación de carga
        llContenedor = findViewById(R.id.llContenedor)
        llCargando = findViewById(R.id.llCargando)

        // A los 9 segundos quita la animación de carga y muestra los datos
        Handler(Looper.getMainLooper()).postDelayed({
            llCargando.isVisible = false
            llContenedor.isVisible = true
        }, 9000)

        mainActivityViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        recyclerView = findViewById(R.id.FacturaList)
        recyclerView!!.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager

        mainActivityViewModel!!.getFacturaList.observe(this){ facturaModels ->
            Log.e("MainActivity", "FacturaList: " +  facturaModels.get(0).fecha)

            if (facturaModels != null){
                adapter = FacturaListAdapter(this, facturaModels)
                adapter!!.notifyDataSetChanged()
                recyclerView!!.adapter = adapter
            }
        }

        // abrir popup presionando en el contenedor del recycler
        adapter?.onItemClick = {
            val dialog = DetailActivity()
            dialog.show(supportFragmentManager, "customDialog")
        }
    }
}