package com.chan.recent.domain.repository

import com.chan.recent.domain.Product

interface RecentProductRepository {
    suspend fun fetchProduct(): List<Product>
}