package com.clakestudio.pc.dzisja.di

import android.app.Application
import android.content.SharedPreferences
import com.clakestudio.pc.dzisja.util.SharedPreferencesProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    /**
     * Here are out retrofit, database and other "components" created
     *
     * */
    @Singleton
    @Provides
    fun provideSharedPreferences(app: Application) : SharedPreferences {
        return SharedPreferencesProvider.getDefaultSharedPreferences(app)
    }


}