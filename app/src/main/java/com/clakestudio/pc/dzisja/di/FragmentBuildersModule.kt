package com.clakestudio.pc.dzisja.di

import com.clakestudio.pc.dzisja.ui.main.addday.AddDayFragment
import com.clakestudio.pc.dzisja.ui.main.dayinfo.DayInfoFragment
import com.clakestudio.pc.dzisja.ui.main.statistics.StatsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeDayInfoFragment(): DayInfoFragment

    @ContributesAndroidInjector
    abstract fun contributeAddDayFragment(): AddDayFragment

    @ContributesAndroidInjector
    abstract fun contributeStatsFragment(): StatsFragment
}