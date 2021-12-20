package com.chan.save.data.di

import com.chan.save.data.source.ProductDataSource
import com.chan.save.data.source.ProductDataSourceImpl
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
        movieDataSource: ProductDataSourceImpl
    ): ProductDataSource
}