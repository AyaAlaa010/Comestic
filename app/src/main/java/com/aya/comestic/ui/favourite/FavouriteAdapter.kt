package com.aya.comestic.ui.favourite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aya.comestic.R
import com.aya.comestic.databinding.FavouriteItemBinding

class FavouriteAdapter ():
    RecyclerView.Adapter<FavouriteAdapter.ListHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteAdapter.ListHolder {
        return FavouriteAdapter.ListHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.favourite_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavouriteAdapter.ListHolder, position: Int) {

    }

    override fun getItemCount(): Int {
      return 10;

    }



    class ListHolder(itemBinding: FavouriteItemBinding) : RecyclerView.ViewHolder(itemBinding.getRoot()) {
        var itemBinding: FavouriteItemBinding
        init {
            this.itemBinding = itemBinding
        }
    }}