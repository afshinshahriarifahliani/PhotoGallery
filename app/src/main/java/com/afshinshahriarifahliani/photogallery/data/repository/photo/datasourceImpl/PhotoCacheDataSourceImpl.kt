package com.afshinshahriarifahliani.photogallery.repository.photo.datasourceImpl

import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItem
import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItemList
import com.afshinshahriarifahliani.photogallery.data.repository.photo.datasource.PhotoCacheDataSource


class PhotoCacheDataSourceImpl :
    PhotoCacheDataSource {
    private var photoItemList= ArrayList<PhotoItem>()

    override suspend fun getPhotosFromCache(): List<PhotoItem> {
        return photoItemList
    }

    override suspend fun savePhotosToCache(photoItems: List<PhotoItem>) {
        photoItemList.clear()
        photoItemList = photoItems as ArrayList<PhotoItem>
    }
}