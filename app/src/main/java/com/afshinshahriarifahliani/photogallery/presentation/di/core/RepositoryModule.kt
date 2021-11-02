package com.afshinshahriarifahliani.photogallery.presentation.di.core

import com.afshinshahriarifahliani.photogallery.data.repository.photo.PhotoRepositoryImpl
import com.afshinshahriarifahliani.photogallery.data.repository.photo.datasource.PhotoCacheDataSource
import com.afshinshahriarifahliani.photogallery.domain.repository.PhotoRepository
import com.afshinshahriarifahliani.photogallery.repository.photo.datasource.PhotoLocalDataSource
import com.afshinshahriarifahliani.photogallery.repository.photo.datasource.PhotoRemoteDatasource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        photoRemoteDatasource: PhotoRemoteDatasource,
        movieLocalDataSource: PhotoLocalDataSource,
        photoCacheDataSource: PhotoCacheDataSource
    ): PhotoRepository {

        return PhotoRepositoryImpl(
            photoRemoteDatasource,
            movieLocalDataSource,
            photoCacheDataSource
        )


    }

  }