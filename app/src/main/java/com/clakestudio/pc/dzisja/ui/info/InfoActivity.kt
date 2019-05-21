package com.clakestudio.pc.dzisja.ui.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.clakestudio.pc.dzisja.R
import com.clakestudio.pc.dzisja.ui.info.fragments.SlidingFragment
import com.clakestudio.pc.dzisja.ui.info.fragments.SlidingFragmentInfo

private const val PAGE_NUM = 4

class InfoActivity : FragmentActivity() {

    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        viewPager = findViewById(R.id.pager)

        val pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        viewPager.adapter = pagerAdapter

    }

    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return when(position) {
                0 -> SlidingFragment()
                1 -> SlidingFragmentInfo()
                2 -> SlidingFragment()
                3 -> SlidingFragmentInfo()
                4 -> SlidingFragmentInfo()
                else -> SlidingFragment()
            }
        }


        override fun getCount(): Int = PAGE_NUM

    }


}
