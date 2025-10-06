package com.example.ecommerceapp.Activity.Adapter

import android.R
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.databinding.ViewholderColorBinding

class ColorAdapter (
    private val items: ArrayList<String>
): RecyclerView.Adapter<ColorAdapter.ViewHolder>(){

private var selectedPosition=-1
    private var lastSelectedPosition=-1
    inner class ViewHolder (val binding: ViewholderColorBinding):
    RecyclerView.ViewHolder(binding.root)




    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ColorAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ColorAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}

