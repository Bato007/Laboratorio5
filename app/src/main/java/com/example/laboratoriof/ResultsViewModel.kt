package com.example.laboratoriof

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultsViewModel: ViewModel(){

    // Two way data binding
    @Bindable
    val inputAnswer = MutableLiveData<String>()

    // App Score
    private val _appScore = MutableLiveData<Float>()
    val appScore: LiveData<Float>
        get() = _appScore

    // Numero de encuestas realizadas
    private val _surveyNumber = MutableLiveData<Int>()
    val surveyNumber: LiveData<Int>
        get() = _surveyNumber

    // Se guardan los datos que
    private var answers: MutableList<String>? = null

    // Para llevar el control del promedio
    private var container = 0F

    // Dandole valor inicial
    init {
        _appScore.value = 0F
        _surveyNumber.value = 0
    }

    // Agregando respuestas a la lista y reseteando el valor de input
    fun addAnswer(){
        answers?.add(inputAnswer.value.toString())
        inputAnswer.value = ""
    }

    // Haciendo los calculos para conseguir el promedio
    fun updateRate(rate: Float){
        // Dandole valor al contenedor
        container += rate

        _surveyNumber.value = (_surveyNumber.value)?.plus(1)

        // Cambiando al promedio
        _appScore.value = (container/((_surveyNumber.value)?.toFloat()!!))
    }

    // Consiguiendo los resultados
    fun getResults(): String{
        val mensaje: String

        // Consiguiendo todas las respuestas

        mensaje = "Hola"

        return mensaje
    }

}