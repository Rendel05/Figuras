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
import com.example.figuras.Contracts.ContratoRectangulo
import com.example.figuras.Presenter.PresentadorRectangulo

class RectanguloView : AppCompatActivity(), ContratoRectangulo.RectanguloVista {

    private lateinit var txvResultado: TextView
    private lateinit var presentador: ContratoRectangulo.RectanguloPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rectangulo_view)

        // Referencias a los elementos del layout
        val txtLado1: EditText = findViewById(R.id.edtLado1)
        val txtLado2: EditText = findViewById(R.id.edtLado2)
        val btnArea: Button = findViewById(R.id.btnArea)
        val btnPerimetro: Button = findViewById(R.id.btnPerimetro)
        txvResultado = findViewById(R.id.txvRes)

        // Instanciamos el presentador
        presentador = PresentadorRectangulo(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Listener del botón de área
        btnArea.setOnClickListener {
            val lado1 = txtLado1.text.toString().toFloatOrNull()
            val lado2 = txtLado2.text.toString().toFloatOrNull()
            if (lado1 != null && lado2 != null) {
                presentador.calculaArea(lado1, lado2)
            } else {
                showError("Por favor ingresa valores válidos para ambos lados")
            }
        }

        // Listener del botón de perímetro
        btnPerimetro.setOnClickListener {
            val lado1 = txtLado1.text.toString().toFloatOrNull()
            val lado2 = txtLado2.text.toString().toFloatOrNull()
            if (lado1 != null && lado2 != null) {
                presentador.calculaPerimetro(lado1, lado2)
            } else {
                showError("Por favor ingresa valores válidos para ambos lados")
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
