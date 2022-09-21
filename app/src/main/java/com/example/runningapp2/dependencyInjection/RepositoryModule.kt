package com.example.runningapp2.dependencyInjection

import com.example.runningapp2.repository.MainRepository
import com.example.runningapp2.repository.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindMainRepository(
        repository: MainRepository // here the class
    ): MainRepositoryImpl // here the interface that the class implements
}
