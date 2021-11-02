package com.afshinshahriarifahliani.photogallery.presentation.di.core

import com.afshinshahriarifahliani.photogallery.data.db.PhotoDao
import com.afshinshahriarifahliani.photogallery.repository.photo.datasource.PhotoLocalDataSource
import com.afshinshahriarifahliani.photogallery.repository.photo.datasourceImpl.PhotoLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providePhotoLocalDataSource(photoDao: PhotoDao): PhotoLocalDataSource {
        return PhotoLocalDataSourceImpl(photoDao)
    }

}