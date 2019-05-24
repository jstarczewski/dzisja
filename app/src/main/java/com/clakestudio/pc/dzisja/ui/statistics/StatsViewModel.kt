package com.clakestudio.pc.dzisja.ui.statistics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.clakestudio.pc.dzisja.data.DataSource
import com.clakestudio.pc.dzisja.data.Day
import javax.inject.Inject

class StatsViewModel @Inject constructor(private val daysRepository: DataSource) : ViewModel() {


    private val _days = MutableLiveData<List<Day>>()
    val days: LiveData<List<Day>> = _days

    private val _feelings = MutableLiveData<List<Pair<String, Int>>>()
    val feelings: LiveData<List<Pair<String, Int>>> = _feelings
    private val rawFeelings = arrayListOf<String>()

    fun init() {
        daysRepository.getAllDays().value!!.forEach {
            rawFeelings.addAll(it.feelings.split(","))
        }
        _feelings.value = rawFeelings.groupingBy { it }.eachCount().toList()
    }

}
