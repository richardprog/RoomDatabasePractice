package com.example.roomdatabasepractice.di

import android.app.Application
import androidx.room.Room
import com.example.roomdatabasepractice.data.MainDatabase
import com.example.roomdatabasepractice.data.repository.OwnerRepository
import com.example.roomdatabasepractice.data.repository.ProductRepository
import com.example.roomdatabasepractice.data.repository_impl.OwnerRepositoryImpl
import com.example.roomdatabasepractice.data.repository_impl.ProductRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMainDatabase(app: Application) : MainDatabase {
        return Room.databaseBuilder(
            app,
            MainDatabase::class.java,
            "simple_db"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideProductRepository(db : MainDatabase) : ProductRepository {
        return ProductRepositoryImpl(db.productDao())
    }

    @Provides
    @Singleton
    fun provideOwnerRepository(db : MainDatabase) : OwnerRepository {
        return OwnerRepositoryImpl(db.ownerDao())
    }


}