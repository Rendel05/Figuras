package com.example.figuras.Models

import com.example.figuras.Contracts.ContratoCuadrado

class ModeloCuadrado : ContratoCuadrado.CuadradoModel {

    override fun calcularArea(lado: Float): Float {
        return lado * lado
    }

    override fun calcularPerimetro(lado: Float): Float {
        return 4 * lado
    }

    override fun esLadoValido(lado: Float): Boolean {
        return lado > 0
    }
}
