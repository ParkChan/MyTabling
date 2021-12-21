package com.chan.recent.data.di

import com.chan.recent.data.source.TablingApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitService {

    @Provides
    @Singleton
    fun providesGoodChoiceApi(retrofit: Retrofit): TablingApi =
        retrofit.create(TablingApi::class.java)
}