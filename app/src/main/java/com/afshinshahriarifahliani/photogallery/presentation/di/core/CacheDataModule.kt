package com.afshinshahriarifahliani.photogallery.presentation.di.core

import com.afshinshahriarifahliani.photogallery.data.repository.photo.datasource.PhotoCacheDataSource
import com.afshinshahriarifahliani.photogallery.repository.photo.datasourceImpl.PhotoCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun providePhotoCacheDataSource(): PhotoCacheDataSource {
        return PhotoCacheDataSourceImpl()
    }

}