package com.afshinshahriarifahliani.photogallery.data.api

import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItem
import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItemList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/v2/list")
    suspend fun getAllPhotos(): Response<PhotoItemList>

}