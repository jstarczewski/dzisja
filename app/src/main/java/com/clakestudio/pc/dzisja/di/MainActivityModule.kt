package com.clakestudio.pc.dzisja.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.clakestudio.pc.dzisja.ui.main.MainActivity


@Suppress("unused")
@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

}