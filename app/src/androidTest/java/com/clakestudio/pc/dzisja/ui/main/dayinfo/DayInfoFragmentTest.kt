package com.clakestudio.pc.dzisja.ui.main.dayinfo

import androidx.navigation.NavController
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.clakestudio.pc.dzisja.R
import com.clakestudio.pc.dzisja.util.SingleFragmentActivity
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
        verify(dayInfoFragment.navController).navigate(R.id.action_dayInfoFragment_to_daysFragment)
    }

    class TestDayInfoFragment: DayInfoFragment() {
        val navController = mock<NavController>(NavController::class.java)
        override fun navController() = navController
    }


}