package com.chan.save.domain.repository

import com.chan.save.domain.Product

interface SaveProductRepository {
    suspend fun fetchProduct(): List<Product>
}