package com.afshinshahriarifahliani.photogallery.domain.usecase

import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItem
import com.afshinshahriarifahliani.photogallery.domain.repository.PhotoRepository


class GetPhotosUseCase(private val photoRepository: PhotoRepository) {
    suspend fun execute(): List<PhotoItem>? = photoRepository.getAllPhotos()
}