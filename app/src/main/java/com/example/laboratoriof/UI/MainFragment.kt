@file:Suppress("DEPRECATION")

package com.example.laboratoriof.UI


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.laboratoriof.R
import com.example.laboratoriof.ResultsViewModel
import com.example.laboratoriof.SurveyViewModel
import com.example.laboratoriof.databinding.MainFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
@Suppress("DEPRECATION")
class MainFragment : Fragment(){

    private lateinit var mainBinding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        mainBinding = DataBindingUtil.inflate(inflater,
            R.layout.main_fragment, container, false)

        mainBinding.lifecycleOwner = viewLifecycleOwner

        mainBinding.surveyButt.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_questionFragment)
        }

        mainBinding.floatingActionButton.setOnClickListener{view: View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_addQuestionFragment)
        }

        setHasOptionsMenu(true)
        return mainBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.drawable_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        view!!.findNavController().navigate(R.id.action_mainFragment_to_aboutFragment3)
        return super.onOptionsItemSelected(item)
    }

}
