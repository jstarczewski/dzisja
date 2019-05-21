package com.clakestudio.pc.dzisja.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clakestudio.pc.dzisja.databinding.DayBinding

class DaysAdapter(private var days: ArrayList<String>,
                  private val onDayClickCallback: (Unit) -> Unit) : RecyclerView.Adapter<DaysAdapter.DaysViewHolder>() {

    class DaysViewHolder(private val binding: DayBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(text: String) {
            binding.tvTitle.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DaysViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = com.clakestudio.pc.dzisja.databinding.DayBinding.inflate(inflater, parent, false)
        binding.root.setOnClickListener {
            onDayClickCallback.invoke(Unit)
        }
        return DaysViewHolder(binding)
    }

    override fun getItemCount(): Int = days.size

    override fun onBindViewHolder(holder: DaysViewHolder, position: Int) {
        holder.bind(days[position])
    }


    private fun setDays(days: ArrayList<String>) {
        this.days = days
        notifyDataSetChanged()
    }

    fun replaceData(days: ArrayList<String>) {
        setDays(days)
    }

}