package com.clakestudio.pc.dzisja.di

import com.clakestudio.pc.dzisja.blankfragment.BlankFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeBlankFragment(): BlankFragment


}