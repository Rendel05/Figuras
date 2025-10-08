package com.example.figuras.Views

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.figuras.R
import com.example.figuras.Contracts.ContratoCuadrado
import com.example.figuras.Presenter.PresentadorCuadrado

class CuadradoView : AppCompatActivity(), ContratoCuadrado.CuadradoVista {

    private lateinit var txvResultado: TextView
    private lateinit var presentador: ContratoCuadrado.CuadradoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cuadrado_view)

        val txtLado: EditText = findViewById(R.id.edtLado)
        val btnArea: Button = findViewById(R.id.btnArea)
        val btnPerimetro: Button = findViewById(R.id.btnPerimetro)
        txvResultado = findViewById(R.id.txvRes)

        presentador = PresentadorCuadrado(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnArea.setOnClickListener {
            val lado = txtLado.text.toString().toFloatOrNull()
            if (lado != null) {
                presentador.calculaArea(lado)
            } else {
                showError("Por favor ingresa un valor válido para el lado")
            }
        }

        findViewById<ImageButton>(R.id.btnBack).setOnClickListener {
            finish()
        }

        btnPerimetro.setOnClickListener {
            val lado = txtLado.text.toString().toFloatOrNull()
            if (lado != null) {
                presentador.calculaPerimetro(lado)
            } else {
                showError("Por favor ingresa un valor válido para el lado")
            }
        }
    }

    override fun showArea(area: Float) {
        txvResultado.text = "El área es $area"
    }

    override fun showPerimetro(perimetro: Float) {
        txvResultado.text = "El perímetro es $perimetro"
    }

    override fun showError(msg: String) {
        txvResultado.text = msg
    }
}
