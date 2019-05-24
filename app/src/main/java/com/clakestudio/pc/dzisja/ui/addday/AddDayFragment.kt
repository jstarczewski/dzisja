package com.clakestudio.pc.dzisja.ui.addday

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.clakestudio.pc.dzisja.util.OpenForTesting
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@OpenForTesting
class AddDayFragment : Fragment() {

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
        // TODO: Use the ViewModel

        //fab_add.setOnClickListener {
            // TODO: Save note
         //   navController().popBackStack()
        //}

        hideBottomNavigationBar()

    }

    fun hideBottomNavigationBar() {
        activity?.bottom_navigation?.visibility = View.GONE
    }

    fun navController() = findNavController()
}
