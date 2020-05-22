package com.cruxrepublic.calculatorwithmvvm.ui

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModel
import net.objecthunter.exp4j.Expression
import java.lang.Exception
import java.text.DecimalFormat


class CalculatorViewModel:ViewModel() {


 private val tag = this::class.simpleName
var digitOnScreen = StringBuilder()
 var operation: Char =' '
 var leftHandSide: Double = 0.0
 var rightHandSide: Double = 0.0


 init {
//  clears the text input

//  digitOnScreen.clear()


     Log.i("tag", "CalculatorViewModel created")
 }

 fun clearDigit() {
  val length = digitOnScreen.length
     if (digitOnScreen.isNotEmpty()) {
             digitOnScreen.deleteCharAt(length - 1)
             leftHandSide = 0.0
             rightHandSide = 0.0
         }
 }

 fun selectOperation(c: Char){
  operation = c
     if (digitOnScreen.isNotEmpty()) {
         leftHandSide = digitOnScreen.toString().toDouble()
         digitOnScreen.clear()
     }
 }

 fun appendToDigit(digit: String){
  digitOnScreen.append(digit)
 }
//fun evaluateExpression(){
//    Expression
//}
 override fun onCleared() {
  super.onCleared()
  Log.i(tag, "CalculatorViewModel destroyed!")
 }

}