package com.cruxrepublic.calculatorwithmvvm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.cruxrepublic.calculatorwithmvvm.R
import com.cruxrepublic.calculatorwithmvvm.databinding.FragmentCalculatorBinding

/**
 * A simple [Fragment] subclass.
 */
class CalculatorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCalculatorBinding>(inflater,
            R.layout.fragment_calculator, container, false)

        binding.historyButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_calculatorFragment_to_history2)

        }
        // Inflate the layout for this fragment
      return  binding.root
    }

}
