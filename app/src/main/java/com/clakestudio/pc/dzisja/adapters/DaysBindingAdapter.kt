package com.clakestudio.pc.dzisja.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object DaysBindingAdapter {

    @JvmStatic
    @BindingAdapter("app:days")
    fun setDays(recyclerView: RecyclerView, days: ArrayList<String>) {
        with(recyclerView.adapter as DaysAdapter) {
            replaceData(days)
        }

    }

}