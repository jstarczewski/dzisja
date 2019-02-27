package pl.apkabizness.com.dzisja.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.apkabizness.com.dzisja.MainActivity

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

}