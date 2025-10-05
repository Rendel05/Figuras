package com.example.figuras.Contracts

interface ContratoRectangulo {

    interface RectanguloModel {
        fun calcularArea(lado1: Float, lado2: Float): Float
        fun calcularPerimetro(lado1: Float, lado2: Float): Float
        fun esRectanguloValido(lado1: Float, lado2: Float): Boolean // verifica que no sea un cuadrado y lados positivos
    }

    interface RectanguloPresenter {
        fun calculaArea(lado1: Float, lado2: Float)
        fun calculaPerimetro(lado1: Float, lado2: Float)
    }

    interface RectanguloVista {
        fun showArea(area: Float)
        fun showPerimetro(perimetro: Float)
        fun showError(msg: String)
    }
}
