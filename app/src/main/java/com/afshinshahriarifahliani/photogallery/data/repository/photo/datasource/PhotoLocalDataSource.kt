package com.afshinshahriarifahliani.photogallery.repository.photo.datasource

import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItem
import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItemList

interface PhotoLocalDataSource {
    suspend fun getPhotosFromDB(): List<PhotoItem>
    suspend fun savePhotosToDB(photoItems: List<PhotoItem>)
    suspend fun clearAll()
}