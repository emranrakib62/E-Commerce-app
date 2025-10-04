package com.example.ecommerceapp.Activity.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ecommerceapp.Activity.Model.ItemModel
import com.example.ecommerceapp.R
import com.example.ecommerceapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
private lateinit var binding: ActivityDetailBinding
private lateinit var item: ItemModel
private lateinit var managmentCart:

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

    }
}