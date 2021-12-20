package com.chan.save.domain

interface SaveProductUseCase {
    suspend fun fetchProduct(): Result<List<Product>>
}