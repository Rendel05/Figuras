package com.example.figuras.Views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.figuras.R

class MainActivityMenu : AppCompatActivity() {

    private lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        spinner = findViewById(R.id.spinnerFiguras)

        val figuras = arrayOf(
            "Selecciona una figura",
            "Triángulo",
            "Cuadrado",
            "Círculo",
            "Rectángulo"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            figuras
        )

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                when (position) {
                    1 -> startActivity(Intent(this@MainActivityMenu, TrianguloView::class.java))
                    2 -> startActivity(Intent(this@MainActivityMenu, CuadradoView::class.java))
                    3 -> startActivity(Intent(this@MainActivityMenu, CirculoView::class.java))
                    4 -> startActivity(Intent(this@MainActivityMenu, RectanguloView::class.java))
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // No hacer nada
            }
        }
    }

    override fun onResume() {
        super.onResume()
        spinner.setSelection(0)
    }
}
