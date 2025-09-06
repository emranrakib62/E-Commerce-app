package com.example.ecommerceapp.Activity.Model

import java.io.Serializable

data class ItemModel(
   var title: String="",
    var description: String="",
 var picurl: ArrayList<String> = ArrayList(),
   var size: ArrayList<String> = ArrayList(),
    var price : Double=0.0,
   var oldprice : Double=0.0,
   var rating: Double=0.0,
   var numberIncart: Int=1,




): Serializable
