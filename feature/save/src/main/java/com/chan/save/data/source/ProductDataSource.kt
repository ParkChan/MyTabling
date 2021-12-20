package com.chan.save.data.source

import com.chan.save.data.ProductsResponse

interface ProductDataSource {
    suspend fun fetchProduct(): ProductsResponse
}