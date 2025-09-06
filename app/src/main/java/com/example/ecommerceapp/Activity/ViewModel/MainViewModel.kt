package com.example.ecommerceapp.Activity.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceapp.Activity.Model.BrandModel
import com.example.ecommerceapp.Activity.Model.ItemModel
import com.example.ecommerceapp.Activity.Model.SliderModel
import com.example.ecommerceapp.Activity.Repository.MainRepository

class MainViewModel : ViewModel() {
private  val repository= MainRepository()

    val popular: LiveData<MutableList<ItemModel>> = repository.popular
    val brands: LiveData<MutableList<BrandModel>> = repository.brands
    val banners: LiveData<List<SliderModel>> = repository.banners

    fun loadBrands() =repository.loadBrands()
    fun loadBanners() =repository.loadBanners()
    fun loadPopular() =repository.loadPopular()
}