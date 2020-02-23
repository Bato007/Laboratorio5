package com.example.laboratoriof.UI


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.laboratoriof.R
import com.example.laboratoriof.databinding.AboutFragmentBinding

/**
 * A simple [Fragment] subclass.
 */
class AboutFragment : Fragment() {

    private lateinit var aboutBinding: AboutFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        aboutBinding = DataBindingUtil.inflate(inflater,
            R.layout.about_fragment, container, false)

        return aboutBinding.root
    }


}
