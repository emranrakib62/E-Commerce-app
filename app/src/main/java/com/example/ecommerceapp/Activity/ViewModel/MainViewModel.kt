package com.example.ecommerceapp.Activity.ViewModel

import androidx.lifecycle.LiveData
import com.example.ecommerceapp.Activity.Model.BrandModel
import com.example.ecommerceapp.Activity.Model.SliderModel
import com.example.ecommerceapp.Activity.Repository.MainRepository

class MainViewModel {
private  val repository= MainRepository()
    val brands: LiveData<MutableList<BrandModel>> = repository.brands
    val banners: LiveData<List<SliderModel>> = repository.banners
    fun loadBrands() =repository.loadBrands()
    fun loadBanners() =repository.loadBanners()
}