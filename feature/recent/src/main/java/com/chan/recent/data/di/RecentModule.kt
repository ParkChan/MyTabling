package com.chan.recent.data.di

import com.chan.recent.data.repository.RecentProductRepositoryImpl
import com.chan.recent.data.source.RecentProductDataSource
import com.chan.recent.data.source.RecentProductDataSourceImpl
import com.chan.recent.domain.repository.RecentProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RecentModule {

    @Binds
    @Singleton
    abstract fun bindsProductDataSource(
        movieDataSource: RecentProductDataSourceImpl
    ): RecentProductDataSource

    @Binds
    @Singleton
    abstract fun bindsRecentProductRepository(
        recentProductRepositoryImpl: RecentProductRepositoryImpl
    ): RecentProductRepository
}