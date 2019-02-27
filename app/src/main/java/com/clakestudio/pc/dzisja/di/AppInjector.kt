package com.clakestudio.pc.dzisja.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import com.clakestudio.pc.dzisja.DzisjaApp

object AppInjector {

    fun init(dzisjaApp: DzisjaApp) {

        DaggerAppCommponent.builder().application(dzisjaApp).build().inject(dzisjaApp)
        dzisjaApp.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {

            override fun onActivityPaused(activity: Activity?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onActivityResumed(activity: Activity?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onActivityStarted(activity: Activity?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onActivityDestroyed(activity: Activity?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onActivityStopped(activity: Activity?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                // Not sure whether this is a proper way
                if (activity != null)
                    handleActivity(activity)
            }

        })

    }

    private fun handleActivity(activity: Activity) {

        if (activity is HasSupportFragmentInjector)
            AndroidInjection.inject(activity)
        if (activity is FragmentActivity) {
            activity.supportFragmentManager
                .registerFragmentLifecycleCallbacks(
                    object : FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                            if (f is Injectable)
                                AndroidSupportInjection.inject(f)
                        }
                    }, true
                )

        }
    }


}