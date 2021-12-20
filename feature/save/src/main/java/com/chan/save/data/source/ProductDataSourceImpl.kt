package com.chan.save.data.source

import com.chan.save.data.ProductsResponse
import javax.inject.Inject

class ProductDataSourceImpl @Inject constructor(
    private val tablingApi: TablingApi
) : ProductDataSource {
    override suspend fun fetchProduct(): ProductsResponse = tablingApi.fetchProduct()
}