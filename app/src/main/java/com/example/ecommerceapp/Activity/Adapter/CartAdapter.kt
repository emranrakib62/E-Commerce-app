package com.example.ecommerceapp.Activity.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.ecommerceapp.Activity.Helper.ChangeNumberItemsListener
import com.example.ecommerceapp.Activity.Helper.ManagmentCart
import com.example.ecommerceapp.Activity.Model.ItemModel
import com.example.ecommerceapp.databinding.ViewholderCartBinding


class CartAdapter (
    private  val listItemSelected: ArrayList<ItemModel>, context: Context,
    var changeNumberItemsListener: ChangeNumberItemsListener?=null
): RecyclerView.Adapter<CartAdapter.Viewholder>() {

    private val managmentCar = ManagmentCart(context)

    class Viewholder(val binding: ViewholderCartBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartAdapter.Viewholder {

        val binding =
            ViewholderCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: CartAdapter.Viewholder, position: Int) {
        val item = listItemSelected[position]
        holder.binding.titleTxt.text = item.title
        holder.binding.feeEachItemTxt.text = "$${item.price}"
        holder.binding.totalEachitem.text = "$${Math.round(item.numberInCart * item.price)}"
        holder.binding.numbercartItemTxt.text = item.numberInCart.toString()


        Glide.with(holder.itemView.context)
            .load(item.picUrl[0])
            .apply(RequestOptions().transform(CenterCrop()))
            .into(holder.binding.pic)


        holder.binding.pluscartBtn.setOnClickListener {
            managmentCar.plusItem(
                listItemSelected,
                position,
                object : ChangeNumberItemsListener {
                    override fun onChanged() {
                        notifyDataSetChanged()
                        changeNumberItemsListener?.onChanged()
                    }
                }
            )
        }


        holder.binding.minuscartBtn.setOnClickListener {
            managmentCar.minusItem(listItemSelected, position, object : ChangeNumberItemsListener {
                override fun onChanged() {
                    notifyDataSetChanged()
                    changeNumberItemsListener?.onChanged()
                }
            })

        }
    }
        override fun getItemCount(): Int = listItemSelected.size


}