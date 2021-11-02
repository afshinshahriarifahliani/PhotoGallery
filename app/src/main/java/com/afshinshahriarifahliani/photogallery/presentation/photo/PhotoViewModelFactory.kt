package com.afshinshahriarifahliani.photogallery.presentation.photo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.afshinshahriarifahliani.photogallery.domain.usecase.GetPhotosUseCase
import com.afshinshahriarifahliani.photogallery.domain.usecase.UpdatePhotosUsecase


class PhotoViewModelFactory(
    private val getPhotosUseCase: GetPhotosUseCase,
    private val updatePhotosUsecase: UpdatePhotosUsecase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PhotoViewModel(getPhotosUseCase, updatePhotosUsecase) as T
    }



}

