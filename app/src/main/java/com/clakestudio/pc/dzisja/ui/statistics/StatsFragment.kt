package com.clakestudio.pc.dzisja.ui.statistics

import android.graphics.Color
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.clakestudio.pc.dzisja.databinding.FragmentStatsBinding
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_stats.*

import javax.inject.Inject

class StatsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: FragmentStatsBinding

    private lateinit var viewModel: StatsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * OnViewCreated -> Factory
     * */

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StatsViewModel::class.java)
        // TODO: Use the ViewModel

        /**
         * Base empty chart setup
         * */

        pieChart.setUsePercentValues(true)
        pieChart.description.isEnabled = true
        pieChart.setExtraOffsets(5f,10f,5f,5f)
        pieChart.dragDecelerationFrictionCoef = 0.95f
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.BLACK)
        pieChart.transparentCircleRadius = 61f

        val data = arrayListOf<PieEntry>(
            PieEntry(12f, "Happy"),
            PieEntry(22f, "Sad"),
            PieEntry(18f, "Outline"),
            PieEntry(1f,"Angry"),
            PieEntry(33f, "Neutral")
        )

        val pieDataSet = PieDataSet(data, "Feelings")
        pieDataSet.sliceSpace = 3f
        pieDataSet.selectionShift = 5f
        pieDataSet.colors = ColorTemplate.createColors(ColorTemplate.PASTEL_COLORS)

        val pieData = PieData(pieDataSet)
        pieData.setValueTextSize(10f)
        pieChart.data = pieData


    }

}
