package com.example.figuras.Presenter

import com.example.figuras.Contracts.ContratoRectangulo
import com.example.figuras.Models.ModeloRectangulo

class PresentadorRectangulo(private val vista: ContratoRectangulo.RectanguloVista) :
    ContratoRectangulo.RectanguloPresenter {

    private val model: ContratoRectangulo.RectanguloModel = ModeloRectangulo()

    override fun calculaArea(lado1: Float, lado2: Float) {
        if (model.esRectanguloValido(lado1, lado2)) {
            val a = model.calcularArea(lado1, lado2)
            vista.showArea(a)
        } else {
            vista.showError("Los lados no forman un rectángulo válido")
        }
    }

    override fun calculaPerimetro(lado1: Float, lado2: Float) {
        if (model.esRectanguloValido(lado1, lado2)) {
            val p = model.calcularPerimetro(lado1, lado2)
            vista.showPerimetro(p)
        } else {
            vista.showError("Los lados no forman un rectángulo válido")
        }
    }
}
