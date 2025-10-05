package com.example.figuras.Presenter

import com.example.figuras.Contracts.ContratoCuadrado
import com.example.figuras.Models.ModeloCuadrado

class PresentadorCuadrado(private val vista: ContratoCuadrado.CuadradoVista) :
    ContratoCuadrado.CuadradoPresenter {

    private val model: ContratoCuadrado.CuadradoModel = ModeloCuadrado()

    override fun calculaArea(lado: Float) {
        if (model.esLadoValido(lado)) {
            val a = model.calcularArea(lado)
            vista.showArea(a)
        } else {
            vista.showError("El lado debe ser mayor que 0")
        }
    }

    override fun calculaPerimetro(lado: Float) {
        if (model.esLadoValido(lado)) {
            val p = model.calcularPerimetro(lado)
            vista.showPerimetro(p)
        } else {
            vista.showError("El lado debe ser mayor que 0")
        }
    }
}
