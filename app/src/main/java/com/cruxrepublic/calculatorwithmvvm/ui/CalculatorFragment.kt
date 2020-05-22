package com.cruxrepublic.calculatorwithmvvm.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController

import com.cruxrepublic.calculatorwithmvvm.R
import com.cruxrepublic.calculatorwithmvvm.databinding.FragmentCalculatorBinding
import net.objecthunter.exp4j.Expression
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

        binding.historyButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_calculatorFragment_to_history2)
        }

        initializeButtons()
      return  binding.root
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
//            viewModel.selectOperation('S')
            displayAppendedDigit("-")

        }
        binding.plusButton.setOnClickListener {
//            viewModel.selectOperation('A')
            displayAppendedDigit("+")
        }
        binding.divideButton.setOnClickListener {
//            viewModel.selectOperation('D')
            displayAppendedDigit("/")
        }
        binding.multiplicationButton.setOnClickListener {
//            viewModel.selectOperation('M')
            displayAppendedDigit("x")
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
        binding.inputText.text = viewModel.digitOnScreen.toString()

    }
    private fun performMathOperation(){

//        viewModel.rightHandSide = viewModel.digitOnScreen.toString().toDouble()
//
//    when(viewModel.operation) {
//        'A' -> {
//            val sum = OperationsHelper.add(viewModel.leftHandSide,viewModel.rightHandSide)
//            val df = DecimalFormat(".##")
//            val formattedSum = df.format(sum)
//            binding.result.text = formattedSum.toString()
//            viewModel.digitOnScreen.append(formattedSum)
//
//        }
//        'S' -> {
//            val subtract = OperationsHelper.subtract(viewModel.leftHandSide, viewModel.rightHandSide)
//            binding.result.text = subtract.toString()
//            viewModel.digitOnScreen.append(subtract)
//
//        }
//        'M' -> {
//            val multiply = OperationsHelper.multiply(viewModel.leftHandSide, viewModel.rightHandSide)
//            binding.result.text = multiply.toString()
//            viewModel.digitOnScreen.append(multiply)
//
//        }
//        'D' -> {
//            val divide = OperationsHelper.divide(viewModel.leftHandSide, viewModel.rightHandSide)
//            binding.result.text = divide.toString()
//            viewModel.digitOnScreen.append(divide)
//
//        }
//    }
        val digit = binding.inputText.text.toString()
        val expression = ExpressionBuilder(digit).build()

        val result = expression.evaluate()
        val df = DecimalFormat("#.#")
        val formattedResult = df.format(result)

//        val longResult = result.toLong()
        binding.result.text = formattedResult.toString()
    }

   private fun clear(){
        binding.inputText.text = ""
        binding.result.text = ""
       viewModel.digitOnScreen.clear()
    }


    }





