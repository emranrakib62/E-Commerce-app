package com.example.ecommerceapp.Activity.Adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.ecommerceapp.Activity.Model.SliderModel

class SliderAdapter (

    private var sliderItems: List<SliderModel>,
    private val viewPager2: ViewPager2
): RecyclerView.Adapter<SliderAdapter.SliderViewholder>(){
    class SliderViewholder {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SliderAdapter.SliderViewholder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: SliderAdapter.SliderViewholder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}

