package com.chan.recent.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chan.recent.domain.Product
import com.chan.recent.domain.RecentProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RecentProductViewModel @Inject constructor(
    private val useCase: RecentProductUseCase
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
                Timber.e("${it.message}")
            }
    }
}