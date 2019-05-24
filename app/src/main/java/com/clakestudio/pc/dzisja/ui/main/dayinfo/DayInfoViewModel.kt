package com.clakestudio.pc.dzisja.ui.main.dayinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.clakestudio.pc.dzisja.data.DataSource
import com.clakestudio.pc.dzisja.data.Day
import com.clakestudio.pc.dzisja.data.DaysRepository
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DayInfoViewModel @Inject constructor(private val daysRepository: DataSource) : ViewModel() {

    private val _days = MutableLiveData<List<Day>>()
    val days: LiveData<List<Day>> = _days
    private val date: String =
        SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Calendar.getInstance().time)

    fun init() {
        addDayIfTodaysDayNotPresent(daysRepository.getAllDays().value!!)
    }

    private fun containsTodaysDay(days: List<Day>) = days.map { it.date }.contains(date)

    fun addDayIfTodaysDayNotPresent(days: List<Day>) {
        if (!containsTodaysDay(days)) {
            val day = MutableLiveData<Day>()
            day.value = Day("7", "24.05.2019", "Jak tam dzisiaj?", "happy")
            daysRepository.addDay(day)
        }
        _days.value = daysRepository.getAllDays().value?.reversed()
    }

}