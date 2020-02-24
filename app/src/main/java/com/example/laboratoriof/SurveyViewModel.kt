package com.example.laboratoriof

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SurveyViewModel: ViewModel(){

    @Bindable
    var inputText = MutableLiveData<String>()

    // La pregunta que se mostrara al usuario
    private val _questionText = MutableLiveData<String>()
    val questionText: LiveData<String>
        get() = _questionText

    // El número de veces
    private val _questionsLeft = MutableLiveData<Int>()
    val questionsLeft: LiveData<Int>
        get() = _questionsLeft

    private var questionsList = mutableListOf("Do you have any Comments or Suggestions?")

    // Iniciando al menos dos preguntas en la encuesta
    init {
        _questionText.value = questionsList[0]
        _questionsLeft.value = 1
    }

    // Modificando las preguntas
    fun addNewQuestion(){
        questionsList.add(inputText.value.toString())
    }

    fun changeQuestion(){
        _questionText.value = questionsList[questionsLeft.value!! - 1]
        _questionsLeft.value = _questionsLeft.value!!.plus(1)
    }

    fun restartQuestions(){
        _questionsLeft.value = 1
    }


    // Conseguir el largo de la lista
    fun getListSize(): Int {
        return questionsList.size

    }

}