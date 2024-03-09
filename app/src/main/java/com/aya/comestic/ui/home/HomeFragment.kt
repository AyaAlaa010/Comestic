package com.aya.comestic.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aya.comestic.R
import com.aya.comestic.beans.ProductsBeans
import com.aya.comestic.databinding.FragmentHomeBinding
import com.aya.comestic.states.ProductsState
import com.aya.comestic.viewmodels.ProductsViewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var adapter: ProductsAdapter
    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController
    private val viewModel by viewModels<ProductsViewModels>()
    private lateinit var productsList:ArrayList<ProductsBeans>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setAdapterToRecyclerView()
        observeViewModel()
        makeRequestForProducts()

    }

    private fun observeViewModel() {
        viewModel.productsLiveData.observe(viewLifecycleOwner) {
            Log.i("Homeeeeeeeee", "observer")

            handleStates(it)
        }
    }

    private fun handleStates(it: ProductsState?) {

        when (it) {
            is ProductsState.Idle -> {}

            is ProductsState.ProductInProgress -> {
                binding.progressBar.visibility = View.VISIBLE
                Log.i("Homeeeeeeeee", "handleStates:  in progress")
            }

            is ProductsState.ProductsInSuccessful -> {
                binding.progressBar.visibility = View.GONE
                //set data to adapter
                productsList= it.products!!
                adapter.setData(productsList)
                clearState()
            }

            is ProductsState.ProductsInFailure -> {
                binding.progressBar.visibility = View.GONE
                clearState()
            }

            else -> {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(context, "Some Thing Went Wrong", Toast.LENGTH_LONG).show()

            }
        }

    }


    private fun clearState() {
        viewModel.changeScreenState(ProductsState.Idle)
    }

    private fun makeRequestForProducts() {
        viewModel.changeScreenState(ProductsState.ProductsInRequestSend)

    }

    private fun init() {
        navController = requireParentFragment().requireView().findNavController()
        productsList= ArrayList()
        adapter = ProductsAdapter(productsList,navController, requireContext())


    }

    private fun setAdapterToRecyclerView() {
        val layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        binding.recProducts.adapter = adapter
        binding.recProducts.layoutManager = layoutManager
    }

}