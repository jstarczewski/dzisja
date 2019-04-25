package com.clakestudio.pc.dzisja.ui.main

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
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
    fun checkIfStatsNavigationItemNavigatedToFeelingsFragment() {
        Espresso.onView(withId(R.id.statsFragment)).perform(click())
        Espresso.onView(withId(R.id.statsFragment)).check(matches(isDisplayed()))
    }

    @Test
    fun checkIfDayInfoNavigationItemNavigatedToDayInfoFragment() {
        Espresso.onView(withId(R.id.dayInfoFragment)).perform(click())
        Espresso.onView(withId(R.id.dayInfoFragment)).check(matches(isDisplayed()))
    }

    @Test
    fun checkIfDayInfoIsStartUpNavigationDestination() {
        Espresso.onView(withId(R.id.dayInfoFragment)).check(matches(isDisplayed()))
    }

    @Test
    fun checkIfStatsItemIsSelectedAfterNavigation() {
        Espresso.onView(withId(R.id.statsFragment)).perform(click())
        Espresso.onView(withId(R.id.statsFragment)).check(matches(isSelected()))
    }

    @Test
    fun checkIfDaysItemIsSelectedAfterNavigation() {
        Espresso.onView(withId(R.id.daysFragment)).perform(click())
        Espresso.onView(withId(R.id.daysFragment)).check(matches(isSelected()))
    }

    @Test
    fun checkIfDayInfoItemIsSelectedAfterNavigation() {
        Espresso.onView(withId(R.id.dayInfoFragment)).perform(click())
        Espresso.onView(withId(R.id.dayInfoFragment)).check(matches(isSelected()))
    }

    @Test
    fun checkIfDayInfoItemIsSelectedAtStartup() {
        Espresso.onView(withId(R.id.dayInfoFragment)).check(matches(isSelected()))
    }


}