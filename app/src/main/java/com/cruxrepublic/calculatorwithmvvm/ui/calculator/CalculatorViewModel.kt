package com.cruxrepublic.calculatorwithmvvm.ui.calculator

import android.util.Log
import androidx.lifecycle.ViewModel


class CalculatorViewModel:ViewModel() {


 private val tag = this::class.simpleName
var digitOnScreen = StringBuilder()
 var operation: Char =' '



 init {
//  clears the text input

//  digitOnScreen.clear()


     Log.i("tag", "CalculatorViewModel created")
 }

 fun clearDigit() {
  val length = digitOnScreen.length
     if (digitOnScreen.isNotEmpty()) {
             digitOnScreen.deleteCharAt(length - 1)

         }
 }

    fun appendToDigit(digit: String){
        digitOnScreen.append(digit)
    }

 override fun onCleared() {
  super.onCleared()
  Log.i(tag, "CalculatorViewModel destroyed!")
 }

}