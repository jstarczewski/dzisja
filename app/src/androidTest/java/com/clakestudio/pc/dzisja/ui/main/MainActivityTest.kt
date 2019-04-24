package com.clakestudio.pc.dzisja.ui.main

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.clakestudio.pc.dzisja.R
import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test

class MainActivityTest {


    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun checkIfDaysNavigationItemNavigatedToDaysFragment() {
        Espresso.onView(withId(R.id.daysFragment)).perform(click())
        Espresso.onView(withId(R.id.daysFragment)).check(matches(isDisplayed()))
    }

    @Test
    fun checkIfFeelingsNavigationItemNavigatedToFeelingsFragment() {
        fail()
    }

    @Test
    fun checkIfDayInfoNavigationItemNavigatedToDayInfoFragment() {
        Espresso.onView(withId(R.id.dayInfoFragment)).perform(click())
        Espresso.onView(withId(R.id.dayInfoFragment)).check(matches(isDisplayed()))
    }

    @Test
    fun checkIfDayInfoIsStartUpNavigationDestination() {
        fail()
    }

    @Test
    fun checkIfFeelingsItemIsSelectedAfterNavigation() {
        fail()
    }

    @Test
    fun checkIfDaysItemIsSelectedAfterNavigation() {
        fail()
    }

    @Test
    fun checkIfDayInfoItemIsSelectedAfterNavigation() {
        fail()
    }

    @Test
    fun checkIfDayInfoItemIsSelectedAtStartup() {
        fail()
    }


}