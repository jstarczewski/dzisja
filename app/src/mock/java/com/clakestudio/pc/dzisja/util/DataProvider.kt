package com.clakestudio.pc.dzisja.util

import com.clakestudio.pc.dzisja.data.Day

object DataProvider {

    private var days = arrayListOf(
        Day("1", "1.01.2019", "Dzisiaj wesoło", "happy,outline"),
        Day("2", "2.01.2019", "Dzisiaj smutno", "sad"),
        Day("3", "3.11.2018", "Dzisiaj sredniawka", "happy,sad"),
        Day("4", "4.05.2011", "Dzisiaj kocham gotowac", "angry,sad"),
        Day("5", "5.02.2017", "Dzisiaj salto", "happy"),
        Day("6", "6.02.2017", "Dzisiaj szpagat", "neutral,sad")//,
        //Day("7", "24.05.2019", "Nowa notka", "happy")
    )

    fun provideTestListOfDays(): List<Day> = days

    fun provideTestDay(): Day = Day("100", "29.04.2019", "Test", "happy")

    fun provideFirstDay(): Day = Day("1", "1.01.2019", "Dzisiaj wesoło", "happy")

    fun addDay(day: Day) = days.add(day)

}