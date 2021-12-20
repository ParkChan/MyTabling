package com.chan.save.data.repository

import com.chan.save.data.ProductResponse
import com.chan.save.data.source.SaveProductDataSource
import com.chan.save.domain.Product
import com.chan.save.domain.repository.SaveProductRepository
import javax.inject.Inject

class SaveProductRepositoryImpl @Inject constructor(
    private val saveProductDataSource: SaveProductDataSource,
) : SaveProductRepository {
    override suspend fun fetchProduct(): List<Product> =
        saveProductDataSource.fetchProduct().list.map(ProductResponse::mapToDomain)

}