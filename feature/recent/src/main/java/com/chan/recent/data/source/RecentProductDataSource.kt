package com.chan.recent.data.source

import com.chan.recent.data.ProductsResponse

interface RecentProductDataSource {
    suspend fun fetchProduct(): ProductsResponse
}