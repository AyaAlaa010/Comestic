package com.aya.comestic.ui.favourite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aya.comestic.R
import com.aya.comestic.databinding.FragmentFavouritesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouritesFragment : Fragment() {
    lateinit var binding:FragmentFavouritesBinding
    lateinit var adapter:FavouriteAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_favourites, container, false)
        return binding .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setAdapterToRecyclerView()
    }

    private fun init(){

        adapter= FavouriteAdapter()

    }

    private fun setAdapterToRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext(),  RecyclerView.VERTICAL, false)
        binding.recFavourite.adapter = adapter
        binding.recFavourite.layoutManager = layoutManager
    }
}