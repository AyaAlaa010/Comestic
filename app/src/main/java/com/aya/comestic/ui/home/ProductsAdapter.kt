package com.aya.comestic.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.aya.comestic.R
import com.aya.comestic.beans.ProductsBeans
import com.aya.comestic.beans.toProductsModels
import com.aya.comestic.common_used.AppConst.PRODUCT_DETAILS
import com.aya.comestic.common_used.Common.showImage
import com.aya.comestic.databinding.ItemProductsBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

class ProductsAdapter  constructor(
    var productsList: ArrayList<ProductsBeans>,
    val navController: NavController,
    val context: Context
) : RecyclerView.Adapter<ProductsAdapter.ListHolder>() {


    fun setData(productsList: ArrayList<ProductsBeans>){
        this.productsList=productsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        return ListHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_products,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ListHolder, position: Int) {
         val product=productsList.get(position)
        holder.itemBinding.tvProductName.text= product.name
        holder.itemBinding.tvPrice.text= product.brand
        showImage(product.image_link,holder.itemBinding.productImg,context)
        holder.itemView.setOnClickListener {
            val bundle=Bundle()
            bundle.putParcelable(PRODUCT_DETAILS,product.toProductsModels())
            navController.navigate(R.id.action_homeFragment_to_productDetailsFragment,bundle)
        }
    }




    override fun getItemCount(): Int {
        return productsList.size
    }

    class ListHolder(itemBinding: ItemProductsBinding) : RecyclerView.ViewHolder(itemBinding.getRoot()) {
        var itemBinding: ItemProductsBinding
        init {
            this.itemBinding = itemBinding
        }
    }

}