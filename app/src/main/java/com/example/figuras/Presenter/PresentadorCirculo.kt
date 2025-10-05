package com.example.figuras.Presenter
import com.example.figuras.Models.ModeloCirculo
import com.example.figuras.Contracts.ContratoCirculo

class PresentadorCirculo(val vista: ContratoCirculo.Vista): ContratoCirculo.Presentador{
    private val modelo: ContratoCirculo.Modelo= ModeloCirculo()

    override fun area(radio: Float) {
        if(modelo.valida(radio)){
            val a=modelo.area(radio)
            vista.showArea(a)
        }else{
            vista.showError("Datos incorrectos")
        }
    }

    override fun perimetro(radio: Float) {
        if(modelo.valida(radio)){
            val p=modelo.perimetro(radio)
            vista.showPerimetro(p)
        }else{
            vista.showError("Datos incorrectos")
        }

    }

}