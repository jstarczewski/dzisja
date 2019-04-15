package com.clakestudio.pc.dzisja.ui.main.days

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DaysViewModel @Inject constructor() : ViewModel() {

    var days: MutableLiveData<ArrayList<String>> = MutableLiveData<ArrayList<String>>()

    // Testi init
    fun init() {
        days.value = ArrayList<String>()
        days.value!!.add("1")
        days.value!!.add("2")
        days.value!!.add("3")
        days.value!!.add("4")
        days.value!!.add("5")
        days.value!!.add("6")
        days.value!!.add("7")
        days.value!!.add("8")
        days.value!!.add("9")
        days.value!!.add("10")
    }


}