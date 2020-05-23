package com.cruxrepublic.calculatorwithmvvm.storage.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CalcHistoryDao{
    @Insert
    fun insert(history: CalculationHistory)

    @Query("SELECT * FROM  calculation_history WHERE calculationId = :key")
    fun get(key: Int): CalculationHistory?

    @Query("DELETE FROM  calculation_history" )
    fun clear()

    @Query("SELECT * FROM calculation_history ORDER BY calculationId DESC LIMIT 1")
    fun getCalculation(): CalculationHistory?

    @Query("SELECT * FROM calculation_history ORDER BY calculationId DESC ")
    fun getAllCalculations(): LiveData<List<CalculationHistory>>


}