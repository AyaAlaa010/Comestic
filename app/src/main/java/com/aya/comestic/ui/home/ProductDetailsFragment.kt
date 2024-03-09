package com.aya.comestic.ui.home

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.aya.comestic.ProductsModel
import com.aya.comestic.R
import com.aya.comestic.common_used.AppConst.PRODUCT_DETAILS
import com.aya.comestic.common_used.Common.showImage
import com.aya.comestic.databinding.FragmentProductDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {

lateinit var binding:FragmentProductDetailsBinding
lateinit var product:ProductsModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
        ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments?.containsKey(PRODUCT_DETAILS)!!){
            product= arguments?.get(PRODUCT_DETAILS) as ProductsModel
            setDataToViews()
        }




    }
    fun <T : Parcelable?> Bundle.tryGetParcelable(key: String): T? =
        // getParcelable would return null anyway, but this is a general example
        if (containsKey(key)) getParcelable<T>(key) else null

    private fun setDataToViews() {
        showImage(product.image_link.toString(),binding.productImg, requireContext())
        binding.productName.text=product.name
        binding.productDescription.text=product.description
    }


}
