package com.chan.recent.data.source

import com.chan.recent.data.ProductsResponse
import javax.inject.Inject

class RecentProductDataSourceImpl @Inject constructor(
    private val tablingApi: TablingApi
) : RecentProductDataSource {
    override suspend fun fetchProduct(): ProductsResponse = tablingApi.fetchProduct()
}