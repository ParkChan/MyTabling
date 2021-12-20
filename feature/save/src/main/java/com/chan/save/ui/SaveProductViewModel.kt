package com.chan.save.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chan.save.domain.Product
import com.chan.save.domain.SaveProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SaveProductViewModel @Inject constructor(
    private val useCase: SaveProductUseCase
) : ViewModel() {
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        Timber.e(">>>> ${exception.message}")
    }

    fun fetchProduct() = viewModelScope.launch(coroutineExceptionHandler) {
        useCase.fetchProduct()
            .onSuccess {
                _products.value = it
            }.onFailure {
                Timber.d("${it.message}")
            }
    }
}