package com.clakestudio.pc.dzisja.ui.main.days

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DaysViewModel @Inject constructor() : ViewModel() {

    var days : MutableLiveData<ArrayList<String>> = MutableLiveData<ArrayList<String>>()

    // Testi init
    fun init() = days.value!!.addAll(listOf("One", "Two", "Three", "Four"))


}