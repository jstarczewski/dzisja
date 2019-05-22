package com.clakestudio.pc.dzisja.adapters

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.clakestudio.pc.dzisja.R
import com.clakestudio.pc.dzisja.data.Day
import com.clakestudio.pc.dzisja.databinding.DayBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DaysAdapter(
    private var days: ArrayList<Day>,
    private val onDayClickCallback: () -> Unit
) : RecyclerView.Adapter<DaysAdapter.DaysViewHolder>() {

    private lateinit var context: Context

    inner class DaysViewHolder(private val binding: DayBinding) :
        RecyclerView.ViewHolder(binding.root) {

        //private val fabs: List<FloatingActionButton> =
        //    listOf(binding.fabAngry, binding.fabHappy, binding.fabNeutral, binding.fabSad, binding.fabOutline)

        fun bind(textDayInfo: String, textDay: String, emojis: List<String>) {
            binding.tvDay.text = textDay
            binding.tvDayInfo.text = textDayInfo
            emojis.forEach {
                changeFabColor(binding.root.findViewWithTag(it))
            }
        }

        private fun changeFabColor(fab: FloatingActionButton) {
            val secondary = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.colorSecondaryDark))
            val primary = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.colorPrimaryDark))
            fab.apply {
                backgroundTintList = if (backgroundTintList!! == secondary) primary else secondary
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaysViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DayBinding.inflate(inflater, parent, false)
        binding.root.setOnClickListener {
            onDayClickCallback.invoke()
        }
        context = parent.context
        return DaysViewHolder(binding)
    }

    override fun getItemCount(): Int = days.size

    override fun onBindViewHolder(holder: DaysViewHolder, position: Int) {
        holder.bind(
            days[position].date,
            days[position].note,
            days[position].feelings.split(",")
        )
    }


    private fun setDays(days: ArrayList<Day>) {
        this.days = days
        notifyDataSetChanged()
    }

    fun replaceData(days: ArrayList<Day>) {
        setDays(days)
    }

}