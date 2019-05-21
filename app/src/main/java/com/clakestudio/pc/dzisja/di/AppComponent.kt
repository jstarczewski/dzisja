package com.clakestudio.pc.dzisja.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import com.clakestudio.pc.dzisja.DzisjaApp
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        MainActivityModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(dzisjaApp: DzisjaApp)

}