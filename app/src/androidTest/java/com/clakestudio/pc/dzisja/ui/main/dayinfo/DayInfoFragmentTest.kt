package com.clakestudio.pc.dzisja.ui.main.dayinfo

import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.clakestudio.pc.dzisja.R
import com.clakestudio.pc.dzisja.util.SingleFragmentActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class DayInfoFragmentTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(SingleFragmentActivity::class.java, true, true)

    private val dayInfoFragment = TestDayInfoFragment()

    @Before
    fun init() {
        activityRule.activity.setFragment(dayInfoFragment)
    }

    @Test
    fun navigateToAddFragment() {
        Espresso.onView(withId(R.id.fab_add)).perform(click())
        verify(dayInfoFragment.navController).navigate(R.id.action_dayInfoFragment_to_addDayFragment)
    }


    @Test
    fun checkIfFeelingsAngryFabColorWasChangedAfterClicking() {
        Espresso.onView(withId(R.id.fab_angry)).perform(click())
        val color = activityRule.activity.findViewById<FloatingActionButton>(R.id.fab_angry).backgroundTintList
        val c = ColorStateList.valueOf(ContextCompat.getColor(activityRule.activity, R.color.colorSecondaryDark))
        assertEquals(color, c)
    }

    @Test
    fun checkIfFeelingsSadFabColorWasChangedAfterClicking() {
        Espresso.onView(withId(R.id.fab_sad)).perform(click())
        val color = activityRule.activity.findViewById<FloatingActionButton>(R.id.fab_sad).backgroundTintList
        val c = ColorStateList.valueOf(ContextCompat.getColor(activityRule.activity, R.color.colorSecondaryDark))
        assertEquals(color, c)
    }

    @Test
    fun checkIfFeelingsHappyFabColorWasChangedAfterClicking() {
        Espresso.onView(withId(R.id.fab_happy)).perform(click())
        val color = activityRule.activity.findViewById<FloatingActionButton>(R.id.fab_happy).backgroundTintList
        val c = ColorStateList.valueOf(ContextCompat.getColor(activityRule.activity, R.color.colorSecondaryDark))
        assertEquals(color, c)
    }

    @Test
    fun checkIfFeelingsOutlinedFabColorWasChangedAfterClicking() {
        Espresso.onView(withId(R.id.fab_outline)).perform(click())
        val color = activityRule.activity.findViewById<FloatingActionButton>(R.id.fab_outline).backgroundTintList
        val c = ColorStateList.valueOf(ContextCompat.getColor(activityRule.activity, R.color.colorSecondaryDark))
        assertEquals(color, c)
    }

    @Test
    fun checkIfFeelingsNeutralFabColorWasChangedAfterClicking() {
        Espresso.onView(withId(R.id.fab_neutral)).perform(click())
        Espresso.onView(withId(R.id.fab_neutral)).perform(click())
        val color = activityRule.activity.findViewById<FloatingActionButton>(R.id.fab_neutral).backgroundTintList
        val c = ColorStateList.valueOf(ContextCompat.getColor(activityRule.activity, R.color.colorPrimaryDark))
        assertEquals(color, c)
    }


    @Test
    fun checkIfFeelingsAngryFabColorWasChangedBackAfterClickingSecondTime() {
        Espresso.onView(withId(R.id.fab_angry)).perform(click())
        Espresso.onView(withId(R.id.fab_angry)).perform(click())
        val color = activityRule.activity.findViewById<FloatingActionButton>(R.id.fab_angry).backgroundTintList
        val c = ColorStateList.valueOf(ContextCompat.getColor(activityRule.activity, R.color.colorPrimaryDark))
        assertEquals(color, c)
    }

    @Test
    fun checkIfFeelingsSadFabColorWasChangedBackAfterClickingSecondTime() {
        Espresso.onView(withId(R.id.fab_sad)).perform(click())
        Espresso.onView(withId(R.id.fab_sad)).perform(click())
        val color = activityRule.activity.findViewById<FloatingActionButton>(R.id.fab_sad).backgroundTintList
        val c = ColorStateList.valueOf(ContextCompat.getColor(activityRule.activity, R.color.colorPrimaryDark))
        assertEquals(color, c)
    }

    @Test
    fun checkIfFeelingsHappyFabColorWasChangedBackAfterClickingSecondTime() {
        Espresso.onView(withId(R.id.fab_happy)).perform(click())
        Espresso.onView(withId(R.id.fab_happy)).perform(click())
        val color = activityRule.activity.findViewById<FloatingActionButton>(R.id.fab_happy).backgroundTintList
        val c = ColorStateList.valueOf(ContextCompat.getColor(activityRule.activity, R.color.colorPrimaryDark))
        assertEquals(color, c)
    }

    @Test
    fun checkIfFeelingsOutlinedFabColorWasChangedBackAfterClickingSecondTime() {
        Espresso.onView(withId(R.id.fab_outline)).perform(click())
        Espresso.onView(withId(R.id.fab_outline)).perform(click())
        val color = activityRule.activity.findViewById<FloatingActionButton>(R.id.fab_outline).backgroundTintList
        val c = ColorStateList.valueOf(ContextCompat.getColor(activityRule.activity, R.color.colorPrimaryDark))
        assertEquals(color, c)
    }

    @Test
    fun checkIfFeelingsNeutralFabColorWasChangedBackAfterClickingSecondTime() {
        Espresso.onView(withId(R.id.fab_neutral)).perform(click())
        Espresso.onView(withId(R.id.fab_neutral)).perform(click())
        val color = activityRule.activity.findViewById<FloatingActionButton>(R.id.fab_neutral).backgroundTintList
        val c = ColorStateList.valueOf(ContextCompat.getColor(activityRule.activity, R.color.colorPrimaryDark))
        assertEquals(color, c)
    }

    class TestDayInfoFragment : DayInfoFragment() {
        val navController = mock<NavController>(NavController::class.java)
        override fun navController() = navController
    }


}