package com.example.figuras.Models

import com.example.figuras.Contracts.ContratoRectangulo

class ModeloRectangulo: ContratoRectangulo.RectanguloModel {

    override fun calcularArea(lado1: Float, lado2: Float): Float {
        return lado1 * lado2
    }

    override fun calcularPerimetro(lado1: Float, lado2: Float): Float {
        return 2 * (lado1 + lado2)
    }

    override fun esRectanguloValido(lado1: Float, lado2: Float): Boolean {
        return lado1 != lado2 && lado1 > 0 && lado2 > 0
    }
}
