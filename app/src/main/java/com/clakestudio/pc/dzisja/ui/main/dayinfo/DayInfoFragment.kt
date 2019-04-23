package com.clakestudio.pc.dzisja.ui.main.dayinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.clakestudio.pc.dzisja.R
import com.clakestudio.pc.dzisja.util.OpenForTesting
import kotlinx.android.synthetic.main.fragment_add.*
import javax.inject.Inject

@OpenForTesting
class DayInfoFragment : Fragment() {

    @Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory

    lateinit var dayInfoViewModel: DayInfoViewModel

    private lateinit var binding: com.clakestudio.pc.dzisja.databinding.FragmentDayInfoBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = com.clakestudio.pc.dzisja.databinding.FragmentDayInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab_add.setOnClickListener { navController().navigate(R.id.action_dayInfoFragment_to_daysFragment) }

    }

    fun navController() = findNavController()
}