package com.example.ecommerceapp.Activity.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.Layer
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceapp.Activity.Model.ItemModel
import com.example.ecommerceapp.databinding.ViewholderRecommendedBinding

class PopularAdpater (
    private val items: MutableList<ItemModel>
): RecyclerView.Adapter<PopularAdpater.ViewHolder>(){

    fun updateDate(newData: List<ItemModel>){
        items.clear()
        items.addAll(newData)
        notifyDataSetChanged()
    }


    inner class ViewHolder(val binding: ViewholderRecommendedBinding): RecyclerView.ViewHolder(binding.root)




    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularAdpater.ViewHolder {
        val binding= ViewholderRecommendedBinding.inflate(
            LayoutInflater.from(parent.context),parent,
        )
    }

    override fun onBindViewHolder(holder: PopularAdpater.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}

