package com.afshinshahriarifahliani.photogallery.repository.photo.datasourceImpl

import com.afshinshahriarifahliani.photogallery.data.api.ApiService
import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItem
import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItemList
import com.afshinshahriarifahliani.photogallery.repository.photo.datasource.PhotoRemoteDatasource
import retrofit2.Response

class PhotoRemoteDataSourceImpl(
    private val apiService: ApiService,
) : PhotoRemoteDatasource {
    override suspend fun getAllPhotos(): Response<PhotoItemList> = apiService.getAllPhotos()

}

