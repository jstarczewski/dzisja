package com.clakestudio.pc.dzisja.ui.addday

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.clakestudio.pc.dzisja.data.DataSource
import com.clakestudio.pc.dzisja.data.Day
import com.clakestudio.pc.dzisja.data.DaysRepository
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class AddDayViewModel @Inject constructor(private val daysRepository: DataSource) : ViewModel() {

    private val _day = MutableLiveData<Day>()
    val day: LiveData<Day> = _day

    private val date: String =
        SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Calendar.getInstance().time)

    fun init() {
        _day.value = daysRepository.getDayByDate(date).value
    }

    fun addDay(note: String, feelings: String) =
        MutableLiveData<Day>().apply {
            value = Day(_day.value!!.id, _day.value!!.date, note, feelings)
        }.let {
            daysRepository.addDay(it)
        }

}
