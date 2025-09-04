package com.example.ecommerceapp.Activity.Adapter

import android.R
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.request.RequestOptions
import com.example.ecommerceapp.Activity.Model.SliderModel


class SliderAdapter (

    private var sliderItems: List<SliderModel>,
    private val viewPager2: ViewPager2
): RecyclerView.Adapter<SliderAdapter.SliderViewholder>(){
    class SliderViewholder (itemView: View): RecyclerView.ViewHolder(itemView){
private val imageView: ImageView=itemView.findViewById(R.id.imag)

        fun setImage(sliderItems: SliderModel,context: Context){
            val requestOption= RequestOptions().transform(CenterInside())
            Glide.with(context)
                .load(sliderItems.url)
                .apply(requestOption)
                .into(imageView)
        }

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

    override fun getItemCount()=sliderItems.size

}

