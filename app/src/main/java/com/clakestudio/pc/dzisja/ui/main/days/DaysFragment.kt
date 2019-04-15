package com.clakestudio.pc.dzisja.ui.main.days

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.clakestudio.pc.dzisja.R
import com.clakestudio.pc.dzisja.di.Injectable
import kotlinx.android.synthetic.main.fragment_days.*
import kotlinx.android.synthetic.main.fragment_days.view.*
import javax.inject.Inject

class DaysFragment : Fragment(), Injectable, MotionLayout.TransitionListener {

    override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
    }

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
        if (p1 == R.id.end) {
            val extras = FragmentNavigatorExtras(circle to "circle")
            navController().navigate(R.id.action_daysFragment_to_dayInfoFragment, null, null, extras)
        }
    }


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
        daysViewModel = ViewModelProviders.of(this, viewmodelFactory).get(DaysViewModel::class.java).apply {
            init()
        }
        binding.root.constrainter.setTransitionListener(this)
        circle.setOnClickListener {
            it.animate()
                .scaleY(4f)
                .scaleX(4f)
                .translationYBy((binding.root.height/2-(it.height/2)).toFloat())
                .withEndAction {
                    val extras = FragmentNavigatorExtras(circle to "circle")
                    navController().navigate(R.id.action_daysFragment_to_dayInfoFragment, null, null, extras)
                }.start()
        }
    }


    private fun navController() = findNavController()


}