package com.chan.recent.domain

import com.chan.recent.domain.repository.RecentProductRepository
import javax.inject.Inject

class RecentProductUseCaseImpl @Inject constructor(
    private val repository: RecentProductRepository
) : RecentProductUseCase {
    override suspend  fun fetchProduct(): Result<List<Product>> =
        runCatching {
            repository.fetchProduct()
        }

}