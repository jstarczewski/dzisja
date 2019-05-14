package com.clakestudio.pc.dzisja.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.clakestudio.pc.dzisja.data.DataSource
import com.clakestudio.pc.dzisja.data.Day
import com.clakestudio.pc.dzisja.util.DataProvider


object DayLocalDataSourceMock : DataSource {

    private var DAYS = arrayListOf<Day>()
    private lateinit var liveDays: MutableLiveData<List<Day>>

    init {
        DAYS.addAll(DataProvider.provideTestListOfDays())
        liveDays = MutableLiveData()
    }

    override fun getAllDays(): LiveData<List<Day>> {
        liveDays.value = DAYS
        return liveDays
    }

    override fun getDaysByFeelings(feelings: String): LiveData<List<Day>> {
        liveDays.value = null
        liveDays.value = DAYS.filter { it.feelings == feelings }
        return liveDays
    }

    override fun addDay(day: LiveData<Day>) {
        DAYS.add(day.value!!)
    }

    override fun getDayByDate(date: String): LiveData<Day> {
        val day = MutableLiveData<Day>()
        day.value = DAYS.find { it.date == date }
        return day
    }
}