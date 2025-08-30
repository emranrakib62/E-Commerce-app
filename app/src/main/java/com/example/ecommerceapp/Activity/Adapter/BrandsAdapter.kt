package com.example.ecommerceapp.Activity.Adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.Activity.Model.BrandModel

class BrandsAdapter(private val items: MutableList<BrandModel>):
    RecyclerView.Adapter<BrandsAdapter.Viewholder>() {

        private var selectedPosition = -1
    private var lastSelectedPosition = -1
    fun updateData(newData : List<BrandModel>){
        items.clear()
        items.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BrandsAdapter.Viewholder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BrandsAdapter.Viewholder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}