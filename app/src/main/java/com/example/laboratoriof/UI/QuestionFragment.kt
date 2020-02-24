@file:Suppress("DEPRECATION")

package com.example.laboratoriof.UI


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.laboratoriof.*
import com.example.laboratoriof.databinding.QuestionFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
@Suppress("DEPRECATION")
class QuestionFragment : Fragment() {

    // Mostrando que variables se utilizaran a continuación
    private lateinit var questionBinding: QuestionFragmentBinding

    // View Models
    private lateinit var viewModelSurvey: SurveyViewModel
    private lateinit var viewModelResult: ResultsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inicializando las variables
        questionBinding = DataBindingUtil.inflate(inflater,
            R.layout.question_fragment, container, false)


        // Inicializando los view models
        viewModelSurvey = ViewModelProviders.of(activity!!).get(SurveyViewModel::class.java)
        viewModelResult = ViewModelProviders.of(activity!!).get(ResultsViewModel::class.java)

        // LifeCycle y Data
        questionBinding.surveyViewModel = viewModelSurvey
        questionBinding.resultsViewModel = viewModelResult

        questionBinding.lifecycleOwner = viewLifecycleOwner

        questionBinding.newtButt.setOnClickListener{view: View ->
                if(viewModelSurvey.questionsLeft.value!! == (viewModelSurvey.getListSize())){
                    viewModelSurvey.restartQuestions()
                    view.findNavController().navigate(R.id.action_questionFragment_to_rateFragment)
                }else{
                    questionUpdate()
                }
        }

        return questionBinding.root
    }

    // Actualizando la pregunta en la que esta
    private fun questionUpdate(){
        viewModelResult.addAnswer()
        viewModelSurvey.changeQuestion()
    }

}
