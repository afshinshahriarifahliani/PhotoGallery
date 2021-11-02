package com.afshinshahriarifahliani.photogallery.data.repository.photo.datasource

import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItem
import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItemList

interface PhotoCacheDataSource {
    suspend fun getPhotosFromCache(): List<PhotoItem>
    suspend fun savePhotosToCache(photoItems: List<PhotoItem>)

}