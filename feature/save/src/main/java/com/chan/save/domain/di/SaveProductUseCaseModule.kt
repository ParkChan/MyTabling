package com.chan.save.domain.di

import com.chan.save.domain.SaveProductUseCase
import com.chan.save.domain.SaveProductUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SaveProductUseCaseModule {
    @Binds
    @Singleton
    abstract fun bindsSaveProductUseCase(useCase: SaveProductUseCaseImpl): SaveProductUseCase
}