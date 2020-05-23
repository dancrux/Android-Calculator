package com.cruxrepublic.calculatorwithmvvm.ui.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.cruxrepublic.calculatorwithmvvm.storage.database.CalcHistoryDao
import com.cruxrepublic.calculatorwithmvvm.storage.database.CalculationHistory

class HistoryViewModel(
    val database: CalcHistoryDao, application: Application) : AndroidViewModel(application) {


}
