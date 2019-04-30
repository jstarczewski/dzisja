package com.clakestudio.pc.dzisja.data

import androidx.lifecycle.LiveData

class DaysRepository(localDataSource: DataSource, remoteDataSource: DataSource) : DataSource {

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