package com.clakestudio.pc.dzisja.blankfragment

import androidx.lifecycle.ViewModelProvider
import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clakestudio.pc.dzisja.R

import com.clakestudio.pc.dzisja.di.Injectable
import javax.inject.Inject

class BlankFragment : androidx.fragment.app.Fragment(), Injectable {

    @Inject
    lateinit var viemodelFactory: ViewModelProvider.Factory

    lateinit var blankViewModel: BlankViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    fun onButtonPressed(uri: Uri) {
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

}
