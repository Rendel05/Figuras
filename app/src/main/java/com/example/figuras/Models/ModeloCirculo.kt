package com.example.figuras.Models
import com.example.figuras.Contracts.ContratoCirculo

class ModeloCirculo: ContratoCirculo.Modelo
{
    override fun area(radio: Float): Float
    {
        val pi=3.1416f
        return pi*radio*radio
    }

    override fun perimetro(radio: Float): Float
    {
        val pi=3.1416f
        return 2*pi*radio
    }

    override fun valida(radio: Float): Boolean
    {
        return (radio>0)
    }
}