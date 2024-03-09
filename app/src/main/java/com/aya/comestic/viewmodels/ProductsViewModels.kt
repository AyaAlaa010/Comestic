package com.aya.comestic.viewmodels

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aya.comestic.repositories.ProductsRepository
import com.aya.comestic.retrofit.DataState
import com.aya.comestic.states.ProductsState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModels @Inject constructor( val repository: ProductsRepository,  @ApplicationContext val context : Context) : ViewModel(),
    LifecycleObserver {

    private var productsMutableData: MutableLiveData<ProductsState> =
        MutableLiveData<ProductsState>(ProductsState.Idle)

    val productsLiveData: LiveData<ProductsState>
        get() = productsMutableData





    fun changeScreenState(state: ProductsState) {
        when (state) {
            is ProductsState.ProductsInRequestSend -> {
                Log.i("Homeeeeeeeee", "view model:  in  method")

                viewModelScope.launch {
                    Log.i("Homeeeeeeeee", "view model: it   ")
                    Log.i("Homeeeeeeeee", "view model: repo value ${repository.sayHello()}  ")

                    repository.getProducts().onEach {
                        Log.i("Homeeeeeeeee", "view model:responsssssssssssssssss   ")

                        when (it) {
                                    is DataState.Loading -> {
                                this@ProductsViewModels.productsMutableData.value =
                                    ProductsState.ProductInProgress
                                Log.i("Homeeeeeeeee", "view model:  loading")

                            }

                            is DataState.Success -> {
                                this@ProductsViewModels.productsMutableData.value =
                                    ProductsState.ProductsInSuccessful(it.data!!)
                                Log.i("Homeeeeeeeee", "view model:  success")

                            }

                            is DataState.Error -> {
                                this@ProductsViewModels.productsMutableData.value =
                                    ProductsState.ProductsInFailure(it.message!!)
                                Log.i("Homeeeeeeeee", "view model:  error")

                            }
                            else->{
                                Log.i("Homeeeeeeeee", "view model:  elseeeeeeeee")


                            }
                        }
                    }.catch {
                        Log.i("Homeeeeeeeee", "view model:  exception")
                        Toast.makeText(context ,"Some Thing Went Wrong",Toast.LENGTH_LONG).show() }.launchIn(viewModelScope)
                }

            }

            else ->{
                Log.i("Homeeeeeeeee", "view model:  exception else ")

            return}

        }

    }


}