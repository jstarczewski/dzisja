package com.clakestudio.pc.dzisja.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.clakestudio.pc.dzisja.ui.main.addday.AddDayViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.clakestudio.pc.dzisja.ui.main.dayinfo.DayInfoViewModel
import com.clakestudio.pc.dzisja.ui.main.statistics.StatsViewModel
import com.clakestudio.pc.dzisja.viewmodel.DzisjaViewModelFactory

@Module
abstract class ViewModelModule {

    /**
     * Here we bind all ViewModelModules that will be needed later
     * */

    @Binds
    @IntoMap
    @ViewModelKey(DayInfoViewModel::class)
    abstract fun bindDayInfoViewModel(dayInfoViewModel: DayInfoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddDayViewModel::class)
    abstract fun bindAddDayViewModel(addDayViewModel: AddDayViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(StatsViewModel::class)
    abstract fun bindStatsViewModel(statsViewModel: StatsViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: DzisjaViewModelFactory): ViewModelProvider.Factory

}