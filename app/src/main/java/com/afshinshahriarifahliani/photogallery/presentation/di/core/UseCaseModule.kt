package com.afshinshahriarifahliani.photogallery.presentation.di.core

import com.afshinshahriarifahliani.photogallery.domain.repository.PhotoRepository
import com.afshinshahriarifahliani.photogallery.domain.usecase.GetPhotosUseCase
import com.afshinshahriarifahliani.photogallery.domain.usecase.UpdatePhotosUsecase

import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetPhotoUseCase(photoRepository: PhotoRepository): GetPhotosUseCase {
        return GetPhotosUseCase(photoRepository)
    }

    @Provides
    fun provideUpdatePhotoUseCase(photoRepository: PhotoRepository): UpdatePhotosUsecase {
        return UpdatePhotosUsecase(photoRepository)
    }


}