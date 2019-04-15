package com.clakestudio.pc.dzisja.di

import androidx.annotation.ColorInt
import com.clakestudio.pc.dzisja.blankfragment.BlankFragment
import com.clakestudio.pc.dzisja.ui.main.dayinfo.DayInfoFragment
import com.clakestudio.pc.dzisja.ui.main.days.DaysFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeBlankFragment(): BlankFragment

    @ContributesAndroidInjector
    abstract fun contributeDaysFragment(): DaysFragment

    @ContributesAndroidInjector
    abstract fun contributeDayInfoFragment(): DayInfoFragment


}