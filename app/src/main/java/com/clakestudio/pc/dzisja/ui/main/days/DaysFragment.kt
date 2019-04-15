package com.clakestudio.pc.dzisja.ui.main.days

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.clakestudio.pc.dzisja.di.Injectable
import javax.inject.Inject

class DaysFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewmodelFactory: ViewModelProvider.Factory

    lateinit var daysViewModel: DaysViewModel

    private lateinit var binding: com.clakestudio.pc.dzisja.databinding.FragmentDaysBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = com.clakestudio.pc.dzisja.databinding.FragmentDaysBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        daysViewModel = ViewModelProviders.of(this, viewmodelFactory).get(DaysViewModel::class.java).apply{
            init()
        }
    }


    private fun navController() = findNavController()


}