package com.example.ecommerceapp.Activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.ecommerceapp.Activity.Adapter.BrandsAdapter
import com.example.ecommerceapp.Activity.Adapter.PopularAdpater
import com.example.ecommerceapp.Activity.Adapter.SliderAdapter
import com.example.ecommerceapp.Activity.Model.BrandModel
import com.example.ecommerceapp.Activity.Model.SliderModel
import com.example.ecommerceapp.Activity.Repository.MainRepository
import com.example.ecommerceapp.Activity.ViewModel.MainViewModel
import com.example.ecommerceapp.databinding.ActivityMainBinding




class DashboardActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }


    private lateinit var binding: ActivityMainBinding
    private val brandsAdapter = BrandsAdapter(mutableListOf())
private val popularAdpater= PopularAdpater(mutableListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }
    private fun initUI(){
        initBrands()
        initBanner()
        initRecommended()
    }

    private fun initRecommended() {
binding.recyclerViewRecommendation.layoutManager= GridLayoutManager(this,2)
   binding.recyclerViewRecommendation.adapter=popularAdpater
        binding.recyclerViewRecommendation.visibility= View.VISIBLE

        viewModel.popular.observe(this){
            data->

            for (item in data) {
                Log.d("DashboardActivity", "Item title: ${item.title}, picurl: ${item.picUrl}")
            }

            popularAdpater.updateDate(data)
            binding.progressBarRecommmendation.visibility= View.GONE
        }
        viewModel.loadPopular()

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
    private fun setupBanners(image: List<SliderModel>){
      binding.viewpagerSlider.apply {
          adapter= SliderAdapter(image,this)
          clipToPadding=false
          clipChildren=false
          offscreenPageLimit=3
          (getChildAt(0) as? RecyclerView)?.overScrollMode=
              RecyclerView.OVER_SCROLL_NEVER
          setPageTransformer(CompositePageTransformer().apply {
              addTransformer(MarginPageTransformer(40))
          })
      }
       binding.dotsindicator.apply {
           visibility=if (image.size >1) View.VISIBLE else View.GONE
       if(image.size>1)attachTo(binding.viewpagerSlider)
       }
    }

    private fun initBanner(){
        binding.progressBarBanner.visibility= View.VISIBLE
        viewModel.banners.observe(this) { items-> setupBanners(items)
            binding.progressBarBanner.visibility= View.GONE
        }
        viewModel.loadBanners()
    }


}