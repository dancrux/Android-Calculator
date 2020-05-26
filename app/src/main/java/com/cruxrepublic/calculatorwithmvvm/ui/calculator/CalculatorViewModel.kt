package com.cruxrepublic.calculatorwithmvvm.ui.calculator

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cruxrepublic.calculatorwithmvvm.storage.database.CalcHistoryDao
import com.cruxrepublic.calculatorwithmvvm.storage.database.CalculationHistory
import com.cruxrepublic.calculatorwithmvvm.storage.database.HistoryDatabase
import kotlinx.coroutines.*
import net.objecthunter.exp4j.ExpressionBuilder


class CalculatorViewModel(val database: CalcHistoryDao,
                          application: Application): AndroidViewModel(application) {


 private val tag = this::class.simpleName
var digitOnScreen = StringBuilder()
 var operation: Char =' '
    var result = ""

private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val calculation = MutableLiveData<CalculationHistory?>()

    var savedValue = "$digitOnScreen \n $result"


 init {
         initializeCalculation()

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
fun calculation(){
    val digit = digitOnScreen.toString()
    val expression = ExpressionBuilder(digit).build()
    val answer = expression.evaluate()
    val longAnswer = answer.toLong()
    result = if (answer == longAnswer.toDouble()){
        longAnswer.toString()
    }else{
        answer.toString()
    }

//    if (answer == longAnswer.toDouble()){
//        result = longAnswer.toString()
//    }else{
//        result = answer.toString()
//
//    }
}
    private fun initializeCalculation() {

    }
fun save(){
    uiScope.launch {
        val newCalculationHistory = CalculationHistory(calculationExpression = savedValue)
        insert(newCalculationHistory)
        calculation.value

    }
}

    private suspend fun insert(history: CalculationHistory){
        withContext(Dispatchers.IO){
            database.insert(history)
        }
    }
 override fun onCleared() {
  super.onCleared()
     viewModelJob.cancel()
  Log.i(tag, "CalculatorViewModel destroyed!")
 }

}