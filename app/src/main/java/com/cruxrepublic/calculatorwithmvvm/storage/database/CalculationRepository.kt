package com.cruxrepublic.calculatorwithmvvm.storage.database

import androidx.lifecycle.LiveData

class CalculationRepository(private val calcHistoryDao: CalcHistoryDao) {
    val allCalculationHistory: LiveData<List<CalculationHistory>> =
        calcHistoryDao.getAllCalculations()

    suspend fun insert(calculationHistory: CalculationHistory){
        calcHistoryDao.insert(calculationHistory)
    }
}