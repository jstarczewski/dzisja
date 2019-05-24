package com.clakestudio.pc.dzisja.ui.statistics

import android.graphics.Color
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.clakestudio.pc.dzisja.data.Day
import com.clakestudio.pc.dzisja.databinding.FragmentStatsBinding
import com.clakestudio.pc.dzisja.di.Injectable
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_stats.*

import javax.inject.Inject

class StatsFragment : Fragment(), Injectable {

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
        setupPieChart()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(StatsViewModel::class.java).apply {
            init()
            feelings.observe(viewLifecycleOwner, Observer {
                setupPieChartData(it)
            })
        }
    }

    private fun setupPieChart() {
        pieChart.setUsePercentValues(true)
        pieChart.description.isEnabled = true
        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)
        pieChart.dragDecelerationFrictionCoef = 0.95f
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.BLACK)
        pieChart.transparentCircleRadius = 61f
    }

    private fun setupPieChartData(data: List<Pair<String, Int>>) =
        replaceData(data.map { PieEntry(it.second.toFloat(), it.first) })


    private fun replaceData(data: List<PieEntry>) {
        val pieDataSet = PieDataSet(data, "Feelings")
        pieDataSet.sliceSpace = 3f
        pieDataSet.selectionShift = 5f
        pieDataSet.colors = ColorTemplate.createColors(ColorTemplate.PASTEL_COLORS)

        val pieData = PieData(pieDataSet)
        pieData.setValueTextSize(10f)
        pieChart.data = pieData
    }

}
