package com.clakestudio.pc.dzisja.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.clakestudio.pc.dzisja.blankfragment.BlankViewModel
import com.clakestudio.pc.dzisja.ui.main.days.DaysViewModel
import com.clakestudio.pc.dzisja.viewmodel.DzisjaViewModelFactory

@Module
abstract class ViewModelModule {

    /**
     * Here we bind all ViewModelModules that will be needed later
     * */

    @Binds
    @IntoMap
    @ViewModelKey(BlankViewModel::class)
    abstract fun bindBlankViewModel(blankViewModel: BlankViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DaysViewModel::class)
    abstract fun bindDaysViewModel(daysViewModel: DaysViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: DzisjaViewModelFactory): ViewModelProvider.Factory

}