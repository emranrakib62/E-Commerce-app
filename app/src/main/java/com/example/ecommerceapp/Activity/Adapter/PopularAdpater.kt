package com.example.ecommerceapp.Activity.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.helper.widget.Layer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
            LayoutInflater.from(parent.context),parent,false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularAdpater.ViewHolder, position: Int) {
        val item=items[position]
        holder.binding.apply {
            titleTxt.text=item.title
            pricetxt.text="$${item.price}"
            ratingTxt.text=item.rating.toString()

            Glide.with(holder.itemView.context)
        }
    }

    override fun getItemCount(): Int =items.size

}

