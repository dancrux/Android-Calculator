package com.cruxrepublic.calculatorwithmvvm.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController

import com.cruxrepublic.calculatorwithmvvm.R
import com.cruxrepublic.calculatorwithmvvm.databinding.FragmentCalculatorBinding
import kotlinx.android.synthetic.main.fragment_calculator.*

/**
 * A simple [Fragment] subclass.
 */
class CalculatorFragment : Fragment() {
    private lateinit var viewModel: CalculatorViewModel
    private lateinit var binding: FragmentCalculatorBinding

//    private val digits = listOf<>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i(tag, "Called ViewModelProviders.of")
        viewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_calculator, container, false)

        binding.historyButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_calculatorFragment_to_history2)
        }

        binding.oneButton.setOnClickListener { numberPressed() }
        binding.twoButton.setOnClickListener { numberPressed() }
        binding.threeButton.setOnClickListener { numberPressed() }
        binding.fourButton.setOnClickListener { numberPressed() }
        binding.fiveButton.setOnClickListener { numberPressed() }
        binding.sixButton.setOnClickListener { numberPressed() }
        binding.sevenButton.setOnClickListener { numberPressed() }
        binding.eightButton.setOnClickListener { numberPressed() }
        binding.nineButton.setOnClickListener { numberPressed() }
        binding.zeroButton.setOnClickListener { numberPressed() }
        binding.plusButton.setOnClickListener { numberPressed() }
        binding.minusButton.setOnClickListener { numberPressed() }
        binding.divideButton.setOnClickListener { numberPressed() }
        binding.multiplicationButton.setOnClickListener { numberPressed() }
        binding.dotButton.setOnClickListener { numberPressed() }
        binding.equalButton.setOnClickListener { numberPressed() }
        binding.clearButton.setOnClickListener { numberPressed() }


      return  binding.root
    }

    private fun numberPressed() {

      var number = binding.oneButton.text

        inputText.append(number)
//        val button = view as Button
//
//        val number = button.text

//            if (userIsTyping){
//                result.append(number)
//            }else{
//                result.text =button.text
//
////                userIsTyping = true
//            }
    }




}
