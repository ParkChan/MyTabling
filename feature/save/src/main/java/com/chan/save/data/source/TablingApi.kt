package com.chan.save.data.source

import com.chan.save.data.ProductsResponse
import retrofit2.http.GET

interface TablingApi {
    @GET("save")
    suspend fun fetchProduct(
    ): ProductsResponse
}