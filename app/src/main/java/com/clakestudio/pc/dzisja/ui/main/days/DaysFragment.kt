package com.clakestudio.pc.dzisja.ui.main.days

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.clakestudio.pc.dzisja.R
import com.clakestudio.pc.dzisja.di.Injectable
import javax.inject.Inject

class DaysFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewmodelFactory : ViewModelProvider.Factory

    lateinit var DaysViewModel: DaysViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_days, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}