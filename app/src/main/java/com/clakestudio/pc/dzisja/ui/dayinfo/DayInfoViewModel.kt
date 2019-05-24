package com.clakestudio.pc.dzisja.ui.dayinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.clakestudio.pc.dzisja.data.DataSource
import com.clakestudio.pc.dzisja.data.Day
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DayInfoViewModel @Inject constructor(private val daysRepository: DataSource) : ViewModel() {

    private val _days = MutableLiveData<List<Day>>()
    val days: LiveData<List<Day>> = _days

    private val date: String =
        SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Calendar.getInstance().time)

    fun init() {
        addDayIfTodayNotPresent(daysRepository.getAllDays().value!!)
    }

    private fun containsToday(days: List<Day>) = days.map { it.date }.contains(date)

    private fun addDayIfTodayNotPresent(days: List<Day>) {
        if (!containsToday(days))
            addToday()
        _days.value = daysRepository.getAllDays().value?.reversed()
    }

    private fun addToday() =
        MutableLiveData<Day>().apply {
            value = Day("7", "24.05.2019", "Jak tam dzisiaj?", "")
        }.let {
            daysRepository.addDay(it)
        }

}