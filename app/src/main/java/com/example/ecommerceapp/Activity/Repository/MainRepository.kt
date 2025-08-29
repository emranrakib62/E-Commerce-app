package com.example.ecommerceapp.Activity.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ecommerceapp.Activity.Model.BrandModel
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainRepository {
    private val firebaseDatabase= FirebaseDatabase.getInstance()
    private  val _brands= MutableLiveData<MutableList<BrandModel>>()
    val brands: LiveData<MutableList<BrandModel>> get() = _brands

    fun loadBrands(){
        val ref=firebaseDatabase.getReference("Category")
        ref.addValueEventListener(object : ValueEventListener{

        })
    }

}