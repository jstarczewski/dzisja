package com.clakestudio.pc.dzisja.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.clakestudio.pc.dzisja.data.Day

object DaysBindingAdapter {

    @JvmStatic
    @BindingAdapter("app:days")
    fun setDays(recyclerView: RecyclerView, days: ArrayList<Day>) {
        with(recyclerView.adapter as DaysAdapter) {
            replaceData(days)
        }

    }

}