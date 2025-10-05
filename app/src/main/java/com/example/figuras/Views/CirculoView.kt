package com.example.figuras.Views

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.figuras.R
import com.example.figuras.Contracts.ContratoCirculo
import com.example.figuras.Presenter.PresentadorCirculo

class CirculoView : AppCompatActivity(), ContratoCirculo.Vista {

    private lateinit var txvResultado: TextView
    private lateinit var presentador: ContratoCirculo.Presentador

    fun setPresentador(presentador: ContratoCirculo.Presentador) {
        this.presentador = presentador
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_circulo_view)

        // Referencias a los elementos del layout
        val txtRadio: EditText = findViewById(R.id.edtRadio)
        val btnArea: Button = findViewById(R.id.btnArea)
        val btnPerimetro: Button = findViewById(R.id.btnPerimetro)
        txvResultado = findViewById(R.id.txvRes)

        // Instanciamos el presentador
        presentador = PresentadorCirculo(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Listener del botón de área
        btnArea.setOnClickListener {
            val radio = txtRadio.text.toString().toFloatOrNull()
            if (radio != null) {
                presentador.area(radio)
            } else {
                showError("Por favor ingresa un valor válido para el radio")
            }
        }

        // Listener del botón de perímetro
        btnPerimetro.setOnClickListener {
            val radio = txtRadio.text.toString().toFloatOrNull()
            if (radio != null) {
                presentador.perimetro(radio)
            } else {
                showError("Por favor ingresa un valor válido para el radio")
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
