package com.example.valorant.di

import com.example.valorant.data.api.HenrikDevApi
import com.example.valorant.data.api.MyStoreApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // 나만의 상정 API
    @Provides
    @Singleton
    fun provideStoreApi(): MyStoreApi{
        return Retrofit.Builder()
            .baseUrl("http://192.168.25.41:5000/")
            .addConverterFactory(GsonConverterFactory.create(RetrofitBuilder.gson))
            .build()
            .create(MyStoreApi::class.java)
    }
    // 전적 API
    @Provides
    @Singleton
    fun provideHenrikApi(): HenrikDevApi{
        return Retrofit.Builder()
            .baseUrl("https://api.henrikdev.xyz/")
            .addConverterFactory(GsonConverterFactory.create(RetrofitBuilder.gson))
            .build()
            .create(HenrikDevApi::class.java)
    }
    // Repository
    @Provides
    @Singleton
    fun provideRepository(api: MyStoreApi){

    }
}