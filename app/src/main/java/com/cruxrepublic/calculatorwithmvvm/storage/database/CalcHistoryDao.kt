package com.cruxrepublic.calculatorwithmvvm.storage.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CalcHistoryDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(history: CalculationHistory)

    @Query("SELECT * FROM  calculation_history WHERE calculationId = :key")
   fun get(key: Int): CalculationHistory?

    @Query("SELECT * FROM calculation_history ORDER BY calculationId DESC LIMIT 1")
    fun getCalculation(): CalculationHistory?

    @Query("SELECT * FROM calculation_history ORDER BY calculationId ASC ")
    fun getAllCalculations(): LiveData<List<CalculationHistory>>
    @Query("DELETE FROM  calculation_history" )
    fun clear()


}