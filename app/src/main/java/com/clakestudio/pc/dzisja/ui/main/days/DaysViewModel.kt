package com.clakestudio.pc.dzisja.ui.main.days

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DaysViewModel @Inject constructor() : ViewModel() {

    var days: MutableLiveData<ArrayList<String>> = MutableLiveData<ArrayList<String>>()

    // Testi init
    fun init() {
        days.value = ArrayList<String>()
        days.value!!.add("one")
        days.value!!.add("two")
        days.value!!.add("three")
        days.value!!.add("four")
        days.value!!.add("five")
    }


}