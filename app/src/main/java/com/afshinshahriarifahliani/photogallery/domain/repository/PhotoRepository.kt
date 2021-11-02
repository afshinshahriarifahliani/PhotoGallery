package com.afshinshahriarifahliani.photogallery.domain.repository

import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItem

interface PhotoRepository {

    suspend fun getAllPhotos(): List<PhotoItem>?
    suspend fun updatePhotos(): List<PhotoItem>?

}