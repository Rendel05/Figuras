package com.example.figuras.Contracts

interface ContratoCuadrado {

    interface CuadradoModel {
        fun calcularArea(lado: Float): Float
        fun calcularPerimetro(lado: Float): Float
        fun esLadoValido(lado: Float): Boolean // verifica que el lado sea positivo
    }

    interface CuadradoPresenter {
        fun calculaArea(lado: Float)
        fun calculaPerimetro(lado: Float)
    }

    interface CuadradoVista {
        fun showArea(area: Float)
        fun showPerimetro(perimetro: Float)
        fun showError(msg: String)
    }
}
