package com.afshinshahriarifahliani.photogallery.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.afshinshahriarifahliani.photogallery.data.db.PhotoDao
import com.afshinshahriarifahliani.photogallery.data.db.PhotoDatabase

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun providePhotoDataBase(context: Context): PhotoDatabase {
        return Room.databaseBuilder(context, PhotoDatabase::class.java, "photo_database")
            .build()
    }

    @Singleton
    @Provides
    fun providePhotoDao(photoDatabase: PhotoDatabase): PhotoDao {
        return photoDatabase.photoDao()
    }
}