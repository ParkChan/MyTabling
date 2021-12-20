package com.chan.save.domain

import com.chan.save.domain.repository.SaveProductRepository
import javax.inject.Inject

class SaveProductUseCaseImpl @Inject constructor(
    private val repository: SaveProductRepository
) : SaveProductUseCase {
    override suspend  fun fetchProduct(): Result<List<Product>> =
        runCatching {
            repository.fetchProduct()
        }

}