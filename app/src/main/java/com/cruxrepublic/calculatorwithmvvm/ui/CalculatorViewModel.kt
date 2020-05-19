package com.cruxrepublic.calculatorwithmvvm.ui

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModel

class CalculatorViewModel:ViewModel() {


 private val tag = this::class.simpleName

 init {
//  clearNumbers()
     Log.i("tag", "CalculatorViewModel created")
 }

 override fun onCleared() {
  super.onCleared()
  Log.i(tag, "CalculatorViewModel destroyed!")
 }

//      for when the user is not done with input
//    var userIsTyping = false
//
//    val operations = mapOf<String, (Double, Double) ->Double>(
//        "+" to {a,b -> a + b},
//        "-" to {a,b -> a - b},
//        "/" to {a,b -> a / b},
//        "x" to {a,b -> a * b}
//    )
//    data class PendingOperation(val firstNumber: Double ,val operation:(Double,Double) ->Double)
//    var pendingOperation: PendingOperation? = null
//    fun performPendingOperation(secondNumber: Double): Double{
//        return pendingOperation?.operation!!.invoke(pendingOperation!!.firstNumber, secondNumber)
//    }
//
////     function for displaying numbers when the numbers buttons are pressed
//
//    fun operationPerformed(view: View) {
//        val button = view as Button
//        if (result.text != ""){
//            if (button.text != "="){
//                pendingOperation = PendingOperation(result.text.toString().toDouble(), operations[button.text]!!)
//                result.text =""
//            }
//        }else{
////            handles the pending operation
//            result.text = performPendingOperation(result.text.toString().toDouble()).toString()
////            pendingOperation = null
//
//
//        }
//    }
////   clears the text in the display
//    fun clearNumbers(view: View) {
//        if (userIsTyping){
//            result.text =""
//        }
//
//    }



}