package com.clakestudio.pc.dzisja.ui.addday

import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.clakestudio.pc.dzisja.R
import com.clakestudio.pc.dzisja.di.Injectable
import com.clakestudio.pc.dzisja.util.OpenForTesting
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_add_day.*
import javax.inject.Inject

@OpenForTesting
class AddDayFragment : Fragment(), Injectable, View.OnClickListener {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fab_add -> {
                navController().popBackStack()
                addViewModel.addDay(et_note.text.toString(), createFeelingsStringFromFabs())
            }
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

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var addViewModel: AddDayViewModel

    private lateinit var binding: com.clakestudio.pc.dzisja.databinding.FragmentAddDayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = com.clakestudio.pc.dzisja.databinding.FragmentAddDayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        addViewModel = ViewModelProviders.of(this, viewModelFactory).get(AddDayViewModel::class.java).apply {
            init()
            day.observe(viewLifecycleOwner, Observer {
                et_note.setText(it.note)
                day_number.text = it.date
            })
        }

        binding.fabAngry.setOnClickListener(this)
        binding.fabHappy.setOnClickListener(this)
        binding.fabSad.setOnClickListener(this)
        binding.fabNeutral.setOnClickListener(this)
        binding.fabOutline.setOnClickListener(this)
        fab_add.setOnClickListener(this)
        hideBottomNavigationBar()

    }

    private fun createFeelingsStringFromFabs(): String {
        var feelings = ""
        val fabs = listOf<FloatingActionButton>(
            binding.fabAngry,
            binding.fabHappy,
            binding.fabNeutral,
            binding.fabOutline,
            binding.fabSad
        )

        val secondary = ColorStateList.valueOf(ContextCompat.getColor(context!!, R.color.colorSecondaryDark))
        fabs.forEach {

            if (it.backgroundTintList == secondary)
                feelings = feelings + it.tag + ","
        }
        feelings.substring(0, feelings.length-2)
        return feelings
    }

    fun hideBottomNavigationBar() {
        activity?.bottom_navigation?.visibility = View.GONE
    }

    fun navController() = findNavController()
}
