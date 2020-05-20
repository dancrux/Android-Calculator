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
//number Buttons
        binding.oneButton.setOnClickListener {    buttonPressed(true, "1") }
        binding.twoButton.setOnClickListener {  buttonPressed(true, "2") }
        binding.threeButton.setOnClickListener {   buttonPressed(true, "3") }
        binding.fourButton.setOnClickListener {    buttonPressed(true, "4") }
        binding.fiveButton.setOnClickListener {    buttonPressed(true, "5") }
        binding.sixButton.setOnClickListener {   buttonPressed(true, "6") }
        binding.sevenButton.setOnClickListener {     buttonPressed(true, "7") }
        binding.eightButton.setOnClickListener {   buttonPressed(true, "8") }
        binding.nineButton.setOnClickListener {   buttonPressed(true, "9") }
        binding.zeroButton.setOnClickListener {  buttonPressed(true, "0") }
        binding.dotButton.setOnClickListener {     buttonPressed(true, ".") }
//        operation Buttons
        binding.plusButton.setOnClickListener {    buttonPressed(true, "+") }
        binding.minusButton.setOnClickListener {    buttonPressed(true, "-") }
        binding.divideButton.setOnClickListener {     buttonPressed(true, "/") }
        binding.multiplicationButton.setOnClickListener {   buttonPressed(true, "x") }

        binding.clearButton.setOnClickListener { clear() }

        binding.equalButton.setOnClickListener {    clear() }




      return  binding.root
    }

    fun buttonPressed(clear: Boolean, string: String){
        if (clear){
            binding.result.text = ""
            binding.inputText.append(string)
        }else{
            binding.inputText.append(binding.result.text)
            binding.inputText.append(string)
            binding.result.text = ""
        }
        }

    fun clear(){
        binding.inputText.text = ""
        binding.result.text = ""
    }

//    private fun numberPressed() {
//
//      var number = binding.oneButton.text
//
//        inputText.append(number)
////        val button = view as Button
////
////        val number = button.text
//
////            if (userIsTyping){
////                result.append(number)
////            }else{
////                result.text =button.text
////
//////                userIsTyping = true
////            }
    }





