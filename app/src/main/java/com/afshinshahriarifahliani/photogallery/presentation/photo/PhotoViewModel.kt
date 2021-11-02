package com.afshinshahriarifahliani.photogallery.presentation.photo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.afshinshahriarifahliani.photogallery.domain.usecase.GetPhotosUseCase
import com.afshinshahriarifahliani.photogallery.domain.usecase.UpdatePhotosUsecase


class PhotoViewModel(
    private val getPhotosUseCase: GetPhotosUseCase,
    private val updatePhotosUsecase: UpdatePhotosUsecase
) : ViewModel() {

    fun getAllPhotos() = liveData {
        val photoList = getPhotosUseCase.execute()
        emit(photoList)
    }

    fun updatePhotos() = liveData {
        val photoList = updatePhotosUsecase.execute()
        emit(photoList)
    }

}





