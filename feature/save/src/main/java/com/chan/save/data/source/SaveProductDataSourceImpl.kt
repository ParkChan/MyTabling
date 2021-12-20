package com.chan.save.data.source

import com.chan.save.data.ProductsResponse
import javax.inject.Inject

class SaveProductDataSourceImpl @Inject constructor(
    private val tablingApi: TablingApi
) : SaveProductDataSource {
    override suspend fun fetchProduct(): ProductsResponse = tablingApi.fetchProduct()
}