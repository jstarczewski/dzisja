package com.clakestudio.pc.dzisja.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.clakestudio.pc.dzisja.data.DataSource
import com.clakestudio.pc.dzisja.data.Day
import com.clakestudio.pc.dzisja.util.DataProvider


object FakeDaysRepository : DataSource {

    override fun getAllDays(): LiveData<List<Day>> {
        val data = MutableLiveData<List<Day>>()
        data.value = DataProvider.provideTestListOfDays()
        return data
    }

    override fun getDaysByFeelings(feelings: String): LiveData<List<Day>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addDay(day: LiveData<Day>) {
        DataProvider.addDay(day.value!!)
    }

    override fun getDayByDate(date: String): LiveData<Day> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}