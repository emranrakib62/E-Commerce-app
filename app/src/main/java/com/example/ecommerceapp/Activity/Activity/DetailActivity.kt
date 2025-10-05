package com.example.ecommerceapp.Activity.Activity

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.ecommerceapp.Activity.Helper.ManagmentCart
import com.example.ecommerceapp.Activity.Model.ItemModel
import com.example.ecommerceapp.R
import com.example.ecommerceapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
private lateinit var binding: ActivityDetailBinding
private lateinit var item: ItemModel
private lateinit var managmentCart:ManagmentCart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managmentCart = ManagmentCart(context = this)


        item = intent.getSerializableExtra("object")!! as ItemModel

        setupViews()

    }


    private fun setupViews() = with(receiver = binding) {
        titleTxt.text = item.title
        descriptiontext.text = item.description
        priceTxt.text = "$${item.price}"
        oldPriceTxt.text = "$${item.oldprice}"
        oldPriceTxt.paintFlags = priceTxt.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        ratingTxt.text = "${item.rating} Rating"
        numberItemTxt.text = item.numberInCart.toString()


        updateTotalPrice()

        Glide.with(this@DetailActivity)
            .load(item.picUrl.firstOrNull())
            .into(picMain)



        backBtn.setOnClickListener{finish()}

        plusBtn.setOnClickListener{
            item.numberInCart++
            numberItemTxt.text=item.numberInCart.toString()
                 updateTotalPrice()
        }
        minusBtn.setOnClickListener{
if (item.numberInCart>1){
    item.numberInCart--
    numberItemTxt.text=item.numberInCart.toString()
    updateTotalPrice()
}
        }
        button.setOnClickListener {
            managmentCart.insertFood(item)
        }



    }

    private fun updateTotalPrice()=with(binding) {
        totalpricetext.text="$${item.price*item.numberInCart}"
    }

}
