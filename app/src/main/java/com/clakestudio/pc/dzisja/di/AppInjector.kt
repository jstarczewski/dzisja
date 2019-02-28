package com.clakestudio.pc.dzisja.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import com.clakestudio.pc.dzisja.DzisjaApp

object AppInjector {

    fun init(dzisjaApp: DzisjaApp) {


        DaggerAppComponent.builder().application(dzisjaApp)
            .build().inject(dzisjaApp)

        dzisjaApp.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {

            override fun onActivityPaused(activity: Activity?) {

            }

            override fun onActivityResumed(activity: Activity?) {
            }

            override fun onActivityStarted(activity: Activity?) {
            }

            override fun onActivityDestroyed(activity: Activity?) {
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
            }

            override fun onActivityStopped(activity: Activity?) {
            }
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                // Not sure whether this is a proper way
                handleActivity(activity)
            }

        })

    }

    private fun handleActivity(activity: Activity) {

        if (activity is HasSupportFragmentInjector)
            AndroidInjection.inject(activity)
        if (activity is androidx.fragment.app.FragmentActivity) {
            activity.supportFragmentManager
                .registerFragmentLifecycleCallbacks(
                    object : androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                            if (f is Injectable)
                                AndroidSupportInjection.inject(f)
                        }
                    }, true
                )

        }
    }


}