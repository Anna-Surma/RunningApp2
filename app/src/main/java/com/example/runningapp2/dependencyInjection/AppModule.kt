package com.example.runningapp2.dependencyInjection

import android.content.Context
import androidx.room.Room
import com.example.runningapp2.database.RunDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRunningDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RunDatabase::class.java,
        "run_database"
    ).build()

    @Singleton
    @Provides
    fun provideRunDao(db: RunDatabase) = db.getRunDao()

//    @Provides
//    @Singleton
//    fun provideMainRepository(runDao: RunDAO): MainRepositoryImpl {
//        return MainRepository(runDao)
//    }
}