package com.chan.recent.domain

interface RecentProductUseCase {
    suspend fun fetchProduct(): Result<List<Product>>
}