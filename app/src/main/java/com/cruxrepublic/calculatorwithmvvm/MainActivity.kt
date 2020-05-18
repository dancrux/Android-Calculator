package com.cruxrepublic.calculatorwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cruxrepublic.calculatorwithmvvm.databinding.ActivityMainBinding
import com.cruxrepublic.calculatorwithmvvm.ui.MainViewModel
import com.cruxrepublic.calculatorwithmvvm.util.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//     for when the user is not done with input
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
//
//    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding :   ActivityMainBinding =  DataBindingUtil.setContentView(this, R.layout.activity_main)
//        val viewModel =ViewModelProviders.of(this).get(MainViewModel::class.java)

    }

//    function for displaying numbers when the numbers buttons are pressed
//    fun numberPressed(view: View) {
//        val button = view as Button
//
//        val number = button.text
//    if (userIsTyping){
//        result.append(number)
//    }else{
//        result.text =button.text
//        userIsTyping = true
//    }
//    }
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
