package com.clakestudio.pc.dzisja.db.remote

import androidx.lifecycle.LiveData
import com.clakestudio.pc.dzisja.db.DataSource
import com.clakestudio.pc.dzisja.db.Day

class RemoteDataSource() : DataSource {

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