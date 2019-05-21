package com.clakestudio.pc.dzisja.data.local

import androidx.lifecycle.LiveData
import com.clakestudio.pc.dzisja.data.DataSource
import com.clakestudio.pc.dzisja.data.Day

class LocalDataSource : DataSource {

    override fun getAllDays(): LiveData<List<Day>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDaysByFeelings(feelings: String): LiveData<List<Day>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addDay(day: LiveData<Day>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDayByDate(date: String): LiveData<Day> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}