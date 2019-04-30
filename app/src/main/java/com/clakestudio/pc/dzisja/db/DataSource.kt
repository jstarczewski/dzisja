package com.clakestudio.pc.dzisja.db

import androidx.lifecycle.LiveData

interface DataSource {

    fun getAllDays(): LiveData<List<Day>>

    fun getDaysByFeelings(feelings: String) : LiveData<List<Day>>

    fun addDay(day: LiveData<Day>)

    fun getDayByDate(date: String) : LiveData<Day>


}