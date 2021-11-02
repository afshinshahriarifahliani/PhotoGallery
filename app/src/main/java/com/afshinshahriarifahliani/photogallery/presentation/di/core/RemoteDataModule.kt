package com.afshinshahriarifahliani.photogallery.presentation.di.core

import com.afshinshahriarifahliani.photogallery.data.api.ApiService
import com.afshinshahriarifahliani.photogallery.repository.photo.datasource.PhotoRemoteDatasource
import com.afshinshahriarifahliani.photogallery.repository.photo.datasourceImpl.PhotoRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule() {
    @Singleton
    @Provides
    fun providePhotoRemoteDataSource(apiService: ApiService): PhotoRemoteDatasource {
        return PhotoRemoteDataSourceImpl(
            apiService
        )
    }

}