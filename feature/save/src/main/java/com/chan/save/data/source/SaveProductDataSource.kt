package com.chan.save.data.source

import com.chan.save.data.ProductsResponse

interface SaveProductDataSource {
    suspend fun fetchProduct(): ProductsResponse
}