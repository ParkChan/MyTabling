package com.chan.recent.data.source

import com.chan.recent.data.ProductsResponse
import retrofit2.http.GET

interface TablingApi {
    @GET("recent")
    suspend fun fetchProduct(
    ): ProductsResponse
}