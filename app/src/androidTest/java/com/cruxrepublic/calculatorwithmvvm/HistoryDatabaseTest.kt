package com.cruxrepublic.calculatorwithmvvm

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.cruxrepublic.calculatorwithmvvm.storage.database.CalcHistoryDao
import com.cruxrepublic.calculatorwithmvvm.storage.database.CalculationHistory
import com.cruxrepublic.calculatorwithmvvm.storage.database.HistoryDatabase
import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.lang.Exception

@RunWith(AndroidJUnit4:: class)
class HistoryDatabaseTest {
    private lateinit var historyDao: CalcHistoryDao
    private lateinit var db: HistoryDatabase

    @Before
    fun createDb(){
        val context = InstrumentationRegistry.getInstrumentation().targetContext

//        an In-memory database used here so information stored disappears when process is killed
        db = Room.inMemoryDatabaseBuilder(context, HistoryDatabase::class.java)
//                main thread queries are allowed only for testing
            .allowMainThreadQueries()
            .build()
        historyDao = db.getCalcHistoryDao()

    }

    @After
    @Throws(IOException::class)
    fun closeDb(){
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetCalculation(){
        val history = CalculationHistory()
        historyDao.insert(history)
        val recentcalculation = historyDao.getCalculation()
        assertEquals(recentcalculation?.calculationResult, null)
    }
}