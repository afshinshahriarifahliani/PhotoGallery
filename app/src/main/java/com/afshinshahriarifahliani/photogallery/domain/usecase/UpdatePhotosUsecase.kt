package com.afshinshahriarifahliani.photogallery.domain.usecase

import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItem
import com.afshinshahriarifahliani.photogallery.domain.repository.PhotoRepository


class UpdatePhotosUsecase(private val photoRepository: PhotoRepository) {
    suspend fun execute(): List<PhotoItem>? = photoRepository.updatePhotos()
}