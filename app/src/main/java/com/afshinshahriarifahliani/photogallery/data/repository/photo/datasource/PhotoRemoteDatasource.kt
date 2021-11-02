package com.afshinshahriarifahliani.photogallery.repository.photo.datasource

import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItemList
import retrofit2.Response

interface PhotoRemoteDatasource {
    suspend fun getAllPhotos(): Response<PhotoItemList>
}
