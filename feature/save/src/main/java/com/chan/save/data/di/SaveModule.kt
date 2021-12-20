package com.chan.save.data.di

import com.chan.save.data.repository.SaveProductRepositoryImpl
import com.chan.save.data.source.SaveProductDataSource
import com.chan.save.data.source.SaveProductDataSourceImpl
import com.chan.save.domain.repository.SaveProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SaveModule {

    @Binds
    @Singleton
    abstract fun bindsProductDataSource(
        movieDataSource: SaveProductDataSourceImpl
    ): SaveProductDataSource

    @Binds
    @Singleton
    abstract fun bindsSaveProductRepository(
        saveProductRepositoryImpl: SaveProductRepositoryImpl
    ): SaveProductRepository
}