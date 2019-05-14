package com.clakestudio.pc.dzisja.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.clakestudio.pc.dzisja.data.Day
import com.clakestudio.pc.dzisja.util.DataProvider
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DayLocalDataSourceMockTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var DAY: Day
    private lateinit var DAYFIRST: Day

    @Before
    fun setUp() {
        DAY = DataProvider.provideTestDay()
        DAYFIRST = DataProvider.provideFirstDay()
    }

    @Test
    fun getAllDays() {
        val days = DayLocalDataSourceMock.getAllDays()
        assertEquals(days.value, DataProvider.provideTestListOfDays())
    }

    @Test
    fun getDaysByFeelings() {
        assertEquals(
            DayLocalDataSourceMock.getDaysByFeelings("sad").value?.size, 4
        )
    }

    @Test
    fun addDay() {
        DayLocalDataSourceMock.addDay(MutableLiveData<Day>().apply {
            value = DAY
        })
    }

    @Test
    fun getDayByDate() {
        assertEquals(DayLocalDataSourceMock.getDayByDate("01.01.2019").value, DAYFIRST)
    }
}