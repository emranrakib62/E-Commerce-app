package com.example.ecommerceapp.Activity.Adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.R
import com.example.ecommerceapp.databinding.ViewholderSizeBinding

class SizeAdapter (val items: MutableList<String>):
RecyclerView.Adapter<SizeAdapter.Viewholder>(){


    private var selectedPosition=-1
    private var lastSelectedPosition=-1
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SizeAdapter.Viewholder {
        val binding= ViewholderSizeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )
        return Viewholder(binding)
    }

    override fun onBindViewHolder(
        holder: SizeAdapter.Viewholder,
        position: Int
    ) {
       holder.binding.sizeTxt.text=items[position]

        holder.binding.root.setOnClickListener {
            lastSelectedPosition=selectedPosition
            selectedPosition=position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }
        if(selectedPosition==position){
            holder.binding.Layoutcolor.setBackgroundResource(R.drawable.blue_bg)
            holder.binding.sizeTxt.setTextColor(holder.itemView.context.resources.getColor(R.color.white))

        }else{
            holder.binding.Layoutcolor.setBackgroundResource(R.drawable.stroke_bg_blue)
            holder.binding.sizeTxt.setTextColor(holder.itemView.context.resources.getColor(R.color.black))
        }
    }

    override fun getItemCount(): Int =items.size

    inner class Viewholder (val binding: ViewholderSizeBinding):
    RecyclerView.ViewHolder(binding.root)


}