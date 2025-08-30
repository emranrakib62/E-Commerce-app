package com.example.ecommerceapp.Activity.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.R
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommerceapp.Activity.Model.BrandModel
import com.example.ecommerceapp.databinding.ViewholderBrandBinding

class BrandsAdapter(private val items: MutableList<BrandModel>):
    RecyclerView.Adapter<BrandsAdapter.Viewholder>() {

        private var selectedPosition = -1
    private var lastSelectedPosition = -1
    fun updateData(newData : List<BrandModel>){
        items.clear()
        items.addAll(newData)
        notifyDataSetChanged()
    }
    inner class Viewholder(val binding: ViewholderBrandBinding):
    RecyclerView.ViewHolder(binding.root)
    

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BrandsAdapter.Viewholder {
       val binding= ViewholderBrandBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: BrandsAdapter.Viewholder, position: Int) {
        val item=items[position]

        Glide.with(holder.itemView.context)
            .load(item.picUrl)
            .into(holder.binding.pic)

        holder.binding.root.setOnClickListener{

            if(selectedPosition !=position){
                lastSelectedPosition=selectedPosition
                selectedPosition=position

                if(lastSelectedPosition != -1)notifyItemChanged(lastSelectedPosition)
                notifyItemChanged(selectedPosition)
            }

        }
       val isSelected=selectedPosition==position
        holder.binding.pic.setBackgroundResource(
            if(isSelected)0 else
        )

    }

    override fun getItemCount()= items.size



}