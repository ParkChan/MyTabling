package com.chan.recent.data.repository

import com.chan.recent.data.ProductResponse
import com.chan.recent.data.source.RecentProductDataSource
import com.chan.recent.domain.Product
import com.chan.recent.domain.repository.RecentProductRepository
import javax.inject.Inject

class RecentProductRepositoryImpl @Inject constructor(
    private val recentProductDataSource: RecentProductDataSource,
) : RecentProductRepository {
    override suspend fun fetchProduct(): List<Product> =
        recentProductDataSource.fetchProduct().list.map(ProductResponse::mapToDomain)

}