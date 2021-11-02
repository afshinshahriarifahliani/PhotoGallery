package com.afshinshahriarifahliani.photogallery.presentation.di.photo

import com.afshinshahriarifahliani.photogallery.domain.usecase.GetPhotosUseCase
import com.afshinshahriarifahliani.photogallery.domain.usecase.UpdatePhotosUsecase
import com.afshinshahriarifahliani.photogallery.presentation.photo.PhotoViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PhotoModule {
    @PhotoScope
    @Provides
    fun providePhotoViewModelFactory(
        getPhotosUseCase: GetPhotosUseCase,
        updatePhotosUsecase: UpdatePhotosUsecase
    ): PhotoViewModelFactory {
        return PhotoViewModelFactory(
            getPhotosUseCase,
            updatePhotosUsecase
        )
    }

}