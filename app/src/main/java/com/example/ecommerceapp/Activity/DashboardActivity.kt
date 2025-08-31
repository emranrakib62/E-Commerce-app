package com.example.ecommerceapp.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerceapp.Activity.Adapter.BrandsAdapter
import com.example.ecommerceapp.Activity.ViewModel.MainViewModel
import com.example.ecommerceapp.databinding.ActivityMainBinding

class DashboardActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }


    private lateinit var binding: ActivityMainBinding
    private val brandsAdapter = BrandsAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
          initUI()
    }
    private fun initUI(){
initBrands()

    }
    private fun initBrands(){
      binding.recyclerViewBrands.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        binding.recyclerViewBrands.adapter=brandsAdapter
        binding.progressBarBrands.visibility=View.VISIBLE


        viewModel.brands.observe(this){
           data ->
         brandsAdapter.updateData(newData = data)
            binding.progressBarBrands.visibility= View.GONE
        }

    }


}
