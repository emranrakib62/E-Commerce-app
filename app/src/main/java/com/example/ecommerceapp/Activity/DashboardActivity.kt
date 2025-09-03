package com.example.ecommerceapp.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerceapp.Activity.Adapter.BrandsAdapter
import com.example.ecommerceapp.Activity.Model.BrandModel
import com.example.ecommerceapp.Activity.Repository.MainRepository
import com.example.ecommerceapp.Activity.ViewModel.MainViewModel
import com.example.ecommerceapp.databinding.ActivityMainBinding



class DashboardActivity : AppCompatActivity() {

    class MainViewModel : ViewModel() {  // ✅ Extend ViewModel
        private val repository = MainRepository()
        val brands: LiveData<MutableList<BrandModel>> = repository.brands

        fun loadBrands() = repository.loadBrands()
    }


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
viewModel.loadBrands()


    }
}