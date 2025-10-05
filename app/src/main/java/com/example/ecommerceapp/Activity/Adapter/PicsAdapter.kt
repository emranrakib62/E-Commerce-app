package com.example.ecommerceapp.Activity.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommerceapp.R
import com.example.ecommerceapp.databinding.ViewholderBrandBinding
import com.example.ecommerceapp.databinding.ViewholderPicsBinding

class PicsAdapter(val items: MutableList<String>,private val onImageSelected:(String)-> Unit):
RecyclerView.Adapter<PicsAdapter.Viewholder>()

{

    private var selectedPosition=-1
    private var lastSelectedPosition=-1
    private lateinit var context: Context
    inner class Viewholder(val binding: ViewholderPicsBinding):
    RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PicsAdapter.Viewholder {
       context=parent.context
        val binding= ViewholderPicsBinding.inflate(LayoutInflater.from(context),parent,false)
    return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: PicsAdapter.Viewholder, position: Int) {
        Glide.with(context)
            .load(items[position])
            .into( holder.binding.pic)


        holder.binding.root.setOnClickListener {

            lastSelectedPosition = selectedPosition
            selectedPosition = position


            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)

            onImageSelected(items[position])
        }

        if(selectedPosition==position){
            holder.binding.colorlayout.setBackgroundResource(R.drawable.grey_bg_selected)
        }else{
            holder.binding.colorlayout.setBackgroundResource(R.drawable.grey_bg)
        }
    }

    override fun getItemCount(): Int=items.size




}