package com.clakestudio.pc.dzisja.ui.main.dayinfo

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.clakestudio.pc.dzisja.di.Injectable
import javax.inject.Inject

class DayInfoFragment : Fragment(), Injectable, MotionLa {


    @Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory

    lateinit var dayInfoViewModel: DayInfoViewModel

    private lateinit var binding : com.clakestudio.pc.dzisja.databinding.FragmentDayInfoBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = com.clakestudio.pc.dzisja.databinding.FragmentDayInfoBinding.inflate(inflater, container, false)
        return binding.root
    }
}