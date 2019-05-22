package com.clakestudio.pc.dzisja.ui.main.dayinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.clakestudio.pc.dzisja.data.DataSource
import com.clakestudio.pc.dzisja.data.Day
import com.clakestudio.pc.dzisja.data.DaysRepository
import javax.inject.Inject

class DayInfoViewModel @Inject constructor(private val daysRepository: DataSource) : ViewModel() {

    private val _days = MutableLiveData<List<Day>>()
    val days: LiveData<List<Day>> = _days

    fun init() {
        _days.value = daysRepository.getAllDays().value
    }

}