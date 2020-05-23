package com.cruxrepublic.calculatorwithmvvm.ui.calculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment

import com.cruxrepublic.calculatorwithmvvm.R
import com.cruxrepublic.calculatorwithmvvm.databinding.FragmentCalculatorBinding
import kotlinx.android.synthetic.main.fragment_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.DecimalFormat

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

        binding.historyButton.setOnClickListener { openHistory()}
//            view.findNavController()
//                .navigate(CalculatorFragmentDirections
//                    .actionCalculatorFragmentToHistory2("2=2", "4"))


        initializeButtons()
      return  binding.root
    }

    private fun openHistory() {
       val action = CalculatorFragmentDirections
           .actionCalculatorFragmentToHistory2(binding.inputText.text.toString(),
               binding.result.text.toString())
        NavHostFragment.findNavController(this).navigate(action)

    }


    private fun initializeButtons(){
        functionalButtons()
        operationalButtons()
        numericalButtons()

    }

    private fun numericalButtons() {
        //number Buttons
        binding.oneButton.setOnClickListener {    displayAppendedDigit("1") }
        binding.twoButton.setOnClickListener {  displayAppendedDigit("2")  }
        binding.threeButton.setOnClickListener {  displayAppendedDigit("3") }
        binding.fourButton.setOnClickListener {    displayAppendedDigit("4")  }
        binding.fiveButton.setOnClickListener {   displayAppendedDigit("5")  }
        binding.sixButton.setOnClickListener {   displayAppendedDigit("6")  }
        binding.sevenButton.setOnClickListener {    displayAppendedDigit("7")  }
        binding.eightButton.setOnClickListener {   displayAppendedDigit("8")  }
        binding.nineButton.setOnClickListener {   displayAppendedDigit("9")  }
        binding.zeroButton.setOnClickListener {  displayAppendedDigit("0")  }
        binding.dotButton.setOnClickListener {    displayAppendedDigit(".") }

    }

    private fun operationalButtons() {
        //        operation Buttons
        binding.minusButton.setOnClickListener {
            displayAppendedDigit("-")

        }
        binding.plusButton.setOnClickListener {
            displayAppendedDigit("+")
        }
        binding.divideButton.setOnClickListener {
            displayAppendedDigit("/")
        }
        binding.multiplicationButton.setOnClickListener {
            displayAppendedDigit("*")
        }

    }

    private fun functionalButtons() {
//        handles the clear, backspace and equals button click
        binding.clearButton.setOnClickListener { clear() }
        binding.backSpaceButton.setOnClickListener { displayAfterClearDigit() }
        binding.equalButton.setOnClickListener { performMathOperation() }

    }

    private fun displayAfterClearDigit(){
        viewModel.clearDigit()
        binding.inputText.text = viewModel.digitOnScreen.toString()
        if (binding.result.text.isNotEmpty()){
            clear()
        }
    }

    private fun displayAppendedDigit(number: String){
        viewModel.appendToDigit(number)
        if (binding.inputText.text.isNotEmpty() && binding.result.text.isNotEmpty()) {
            clear()
        }else{
            binding.inputText.text = viewModel.digitOnScreen.toString()
        }
    }


    private fun performMathOperation(){
        val digit = binding.inputText.text.toString()
        val expression = ExpressionBuilder(digit).build()

        val result = expression.evaluate()

        val longResult = result.toLong()
        if(result == longResult.toDouble()){

            binding.result.text = longResult.toString()
        }else{

            binding.result.text = result.toString()
        }

    }

   private fun clear(){
        binding.inputText.text = ""
        binding.result.text = ""
       viewModel.digitOnScreen.clear()
    }


    }





