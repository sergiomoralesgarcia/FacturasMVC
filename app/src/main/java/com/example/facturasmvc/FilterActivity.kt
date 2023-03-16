package com.example.facturasmvc

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.SeekBar
import android.widget.TextView
import com.example.facturasmvc.entidades.Factura
import com.example.facturasmvc.databinding.ActivityFilterBinding
import com.example.facturasmvc.entidades.Filtros
import java.util.*

@Suppress("DEPRECATION")
class FilterActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private lateinit var binding: ActivityFilterBinding
    private lateinit var adapter: AppAdapter

   /*
    // Pruebas Filtrado

    private var btnDesde: DatePickerDialog? = null
    private var btnHasta: DatePickerDialog? = null
    private var seekBarImporte: Double? = null
    private var cbxPagadas: CheckBox? = null
    private var cbxAnuladas: CheckBox? = null
    private var cbxCuotaFija: CheckBox? = null
    private var cbxPendientesPago: CheckBox? = null
    private var cbxPlanPago: CheckBox? = null


    private var botonAplicar = null
    private var buttonDate1: DatePickerDialog? = null*/

    private var datos: MutableList<Factura> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Botón de cancelar los filtros
        binding.cancelButton.setOnClickListener {
            onBackPressed()
        }

        // Calendario
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        binding.buttonDate1.setOnClickListener() {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                    binding.buttonDate1.setText("" + mDay + "/" + (mMonth + 1) + "/" + mYear)
                },
                year,
                month,
                day
            )
            dpd.show()
            // fecha máxima que puedes seleccionar
            dpd.datePicker.maxDate = c.timeInMillis
        }

        binding.buttonDate2.setOnClickListener() {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                    binding.buttonDate2.setText("" + mDay + "/" + (mMonth + 1) + "/" + mYear)
                },
                year,
                month,
                day
            )
            dpd.show()
            // fecha máxima que puedes seleccionar
            dpd.datePicker.maxDate = c.timeInMillis
        }

        // Cambio progresivo de la cantidad del SeekBar
        var progressView: TextView? = null
        var seekBar: SeekBar? = null

        progressView = this.binding.cantidad2
        seekBar = this.binding.seekBar
        seekBar!!.setOnSeekBarChangeListener(this)

        // Botón de aplicar los filtros
        binding.botonAplicar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        /*
        // Pruebas Filtrado

        cbxPagadas = findViewById(R.id.checkBox)
        cbxAnuladas = findViewById(R.id.checkBox2)
        cbxCuotaFija = findViewById(R.id.checkBox3)
        cbxPendientesPago = findViewById(R.id.checkBox4)
        cbxPlanPago = findViewById(R.id.checkBox5)

        // Botón de aplicar los filtros
        botonAplicar = findViewById(R.id.botonAplicar)
        binding.botonAplicar.setOnClickListener {
            val data = Intent()
            data.putExtra("filtros",
                Filtros(btnDesde?.searchEvent.toString(), btnDesde?.searchEvent.toString(), seekBarImporte?.prog!!.toString(), cbxPagadas!!.isChecked, cbxAnuladas!!.isChecked, cbxCuotaFija!!.isChecked, cbxPendientesPago!!.isChecked, cbxPlanPago!!.isChecked,))
            setResult(RESULT_OK, data)
            finish()

            //startActivity(Intent(this, MainActivity::class.java))
        }*/

        // Botón de eliminar los filtros
        binding.botonEliminar.setOnClickListener {
            startActivity(Intent(this, FilterActivity::class.java))
        }
    }

    // importaciones del SeekBar
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        binding.cantidad2!!.text = progress.toString()
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {}
    override fun onStopTrackingTouch(p0: SeekBar?) {}
}