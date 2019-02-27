package com.clakestudio.pc.dzisja.di

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import com.clakestudio.pc.dzisja.blankfragment.BlankViewModel

@Module
abstract class ViewModelModule {

    /**
     * Here we bind all ViewModelModules that will be needed later
     * */

    @Binds
    @IntoMap
    @ViewModelKey(BlankViewModel::class)
    abstract fun bindBlankViewModel(blankViewModel: BlankViewModel): ViewModel

}