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
import com.example.laboratoriof.R
import com.example.laboratoriof.ResultsViewModel
import com.example.laboratoriof.databinding.RateFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
@Suppress("DEPRECATION")
class RateFragment : Fragment() {

    // Mostrando que variables se utilizaran a continuación
    private lateinit var rateBinding: RateFragmentBinding

    // View Models
    private lateinit var viewModelResult: ResultsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        rateBinding = DataBindingUtil.inflate(inflater,
            R.layout.rate_fragment, container, false)

        viewModelResult = ViewModelProviders.of(activity!!).get(ResultsViewModel::class.java)

        rateBinding.resultsViewModel = viewModelResult

        rateBinding.lifecycleOwner = viewLifecycleOwner

        rateBinding.nextButt.setOnClickListener{view: View ->
            viewModelResult.updateRate(rateBinding.ratingBar.rating)
            view.findNavController().navigate(R.id.action_rateFragment_to_resultFragment)
        }

        return rateBinding.root
    }

}
