@file:Suppress("DEPRECATION")

package com.example.laboratoriof.UI


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.laboratoriof.R
import com.example.laboratoriof.SurveyViewModel
import com.example.laboratoriof.databinding.AddQuestionFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
@Suppress("DEPRECATION")
class AddQuestionFragment : Fragment() {

    private lateinit var addFragment: AddQuestionFragmentBinding

    // View models
    private lateinit var viewModelSurvey: SurveyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        addFragment = DataBindingUtil.inflate(inflater,
            R.layout.add_question_fragment, container, false)

        // Inicializando models
        viewModelSurvey = ViewModelProviders.of(activity!!).get(SurveyViewModel::class.java)

        addFragment.questionViewModel = viewModelSurvey
        addFragment.lifecycleOwner = viewLifecycleOwner

        setHasOptionsMenu(true)
        return addFragment.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.add_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModelSurvey.addNewQuestion()
        view!!.findNavController().navigate(R.id.action_addQuestionFragment_to_mainFragment)
        return super.onOptionsItemSelected(item)
    }


}
