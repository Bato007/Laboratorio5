@file:Suppress("DEPRECATION")

package com.example.laboratoriof.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.laboratoriof.*
import com.example.laboratoriof.databinding.ResultFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
@Suppress("DEPRECATION")
class ResultFragment : Fragment() {

    private lateinit var resultBinding: ResultFragmentBinding

    // Instanciando los view models
    private lateinit var viewModelResult: ResultsViewModel
    private lateinit var viewModelSurvey: SurveyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        resultBinding = DataBindingUtil.inflate(inflater,
            R.layout.result_fragment, container, false)

        // Inicializando los view models
        viewModelSurvey = ViewModelProviders.of(activity!!).get(SurveyViewModel::class.java)
        viewModelResult = ViewModelProviders.of(activity!!).get(ResultsViewModel::class.java)

        // Mostrando los datos obtenidos
        resultBinding.surveyViewModel = viewModelSurvey
        resultBinding.resultsViewModel = viewModelResult

        resultBinding.lifecycleOwner = viewLifecycleOwner

        resultBinding.goBack.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
        }

        resultBinding.watchAnswers.setOnClickListener{view: View ->
            val message = viewModelResult.getResults()
            Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
        }

        return resultBinding.root
    }

}
