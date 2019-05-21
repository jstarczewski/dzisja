package com.clakestudio.pc.dzisja.ui.main.addday

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

class AddDayFragmentTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(SingleFragmentActivity::class.java, true, true)

    val addDayFragment: TestAddDayFragment = TestAddDayFragment()

    @Before
    fun init() {
        activityTestRule.activity.setFragment(addDayFragment
        )
    }

    @Test
    fun checkIfAddButtonNavigatesBackToDayInfoFragment() {
        Espresso.onView(withId(R.id.fab_add)).perform(click())
        verify(addDayFragment.navController).popBackStack()
    }

    @Test
    fun checkIfBackNavigationNavigatesToDayInfoFragment() {
        Espresso.onView(withId(R.id.fab_add)).perform(click())
        verify(addDayFragment.navController).popBackStack()
    }

    class TestAddDayFragment : AddDayFragment() {
        val navController = mock<NavController>(NavController::class.java)
        override fun navController() = navController
    }


}