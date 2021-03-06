package com.clakestudio.pc.dzisja.ui.dayinfo

import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.clakestudio.pc.dzisja.R
import com.clakestudio.pc.dzisja.adapters.DaysAdapter
import com.clakestudio.pc.dzisja.data.Day
import com.clakestudio.pc.dzisja.di.Injectable
import com.clakestudio.pc.dzisja.util.OpenForTesting
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_day_info.*
import javax.inject.Inject

@OpenForTesting
class DayInfoFragment : Fragment(), View.OnClickListener, Injectable {


    @Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory

    lateinit var dayInfoViewModel: DayInfoViewModel

    private lateinit var binding: com.clakestudio.pc.dzisja.databinding.FragmentDayInfoBinding

    private val daysAdapter =
        DaysAdapter(arrayListOf()) { findNavController().navigate(R.id.action_dayInfoFragment_to_addDayFragment) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = com.clakestudio.pc.dzisja.databinding.FragmentDayInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showBottomNavigationBar()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
        dayInfoViewModel = ViewModelProviders.of(this, viewmodelFactory).get(DayInfoViewModel::class.java).apply {
            init()
            days.observe(viewLifecycleOwner, Observer {
                daysAdapter.replaceData(it as ArrayList<Day>)
            })
        }

    }

    /**
     * Min SDK will be changed
     * */


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fab_add -> navController().navigate(R.id.action_dayInfoFragment_to_addDayFragment)
            else -> {
                changeFabColor(v as FloatingActionButton)
            }
        }
    }

    private fun changeFabColor(fab: FloatingActionButton) {
        val secondary = ColorStateList.valueOf(ContextCompat.getColor(context!!, R.color.colorSecondaryDark))
        val primary = ColorStateList.valueOf(ContextCompat.getColor(context!!, R.color.colorPrimaryDark))
        fab.apply {
            backgroundTintList = if (backgroundTintList!! == secondary) primary else secondary
        }
    }

    private fun setupRecyclerView() = with(rv_days) {
        layoutManager = LinearLayoutManager(this@DayInfoFragment.context)
        setHasFixedSize(true)
        adapter = daysAdapter
    }

    private fun showBottomNavigationBar() {
        activity?.bottom_navigation?.visibility = View.VISIBLE
    }

    fun navController() = findNavController()
}