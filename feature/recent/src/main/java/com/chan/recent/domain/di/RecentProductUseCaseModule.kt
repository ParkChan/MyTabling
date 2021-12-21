package com.chan.recent.domain.di

import com.chan.recent.domain.RecentProductUseCase
import com.chan.recent.domain.RecentProductUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RecentProductUseCaseModule {
    @Binds
    @Singleton
    abstract fun bindsRecentProductUseCase(useCase: RecentProductUseCaseImpl): RecentProductUseCase
}