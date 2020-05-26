package com.cruxrepublic.calculatorwithmvvm.ui.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cruxrepublic.calculatorwithmvvm.storage.database.CalcHistoryDao
import com.cruxrepublic.calculatorwithmvvm.storage.database.CalculationHistory
import kotlinx.coroutines.*

class HistoryViewModel(
    val database: CalcHistoryDao, application: Application) : AndroidViewModel(application) {
    private var viewModelJOb = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJOb)
    private var calculation = MutableLiveData<CalculationHistory?>()

    init {
        initializeCalculation()
    }

    private fun initializeCalculation() {
        uiScope.launch {
            getAllCalculations()
            calculation.value
        }
    }

    private suspend fun getAllCalculations(): LiveData<List<CalculationHistory>>{
        return withContext(Dispatchers.IO){
            return@withContext database.getAllCalculations()

//            var calculation = database.getCalculation()
//            return@withContext calculation
        }


    }

    override fun onCleared() {
        super.onCleared()
        viewModelJOb.cancel()
    }
}
