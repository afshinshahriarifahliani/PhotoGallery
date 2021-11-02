package com.afshinshahriarifahliani.photogallery.data.repository.photo

import android.util.Log
import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItem
import com.afshinshahriarifahliani.photogallery.data.repository.photo.datasource.PhotoCacheDataSource
import com.afshinshahriarifahliani.photogallery.domain.repository.PhotoRepository
import com.afshinshahriarifahliani.photogallery.repository.photo.datasource.PhotoLocalDataSource
import com.afshinshahriarifahliani.photogallery.repository.photo.datasource.PhotoRemoteDatasource

class PhotoRepositoryImpl(
    private val photoRemoteDatasource: PhotoRemoteDatasource,
    private val photoLocalDataSource: PhotoLocalDataSource,
    private val photoCacheDataSource: PhotoCacheDataSource
) : PhotoRepository {
    override suspend fun getAllPhotos(): List<PhotoItem>? {
        return getPhotosFromCache()
    }

    override suspend fun updatePhotos(): List<PhotoItem>? {
        val newListOfPhotos = getPhotosFromAPI()
        photoLocalDataSource.clearAll()
        photoLocalDataSource.savePhotosToDB(newListOfPhotos)
        photoCacheDataSource.savePhotosToCache(newListOfPhotos)
        return newListOfPhotos
    }

    suspend fun getPhotosFromAPI(): List<PhotoItem> {
        lateinit var photoItemList: List<PhotoItem>
        try {
            val response = photoRemoteDatasource.getAllPhotos()
            val body = response.body()
            if (body != null) {
                photoItemList = body
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return photoItemList
    }

    suspend fun getPhotosFromDB(): List<PhotoItem> {
        lateinit var photoItemList: List<PhotoItem>
        try {
            photoItemList =photoLocalDataSource.getPhotosFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (photoItemList.size > 0) {
            return photoItemList
        } else {
            photoItemList = getPhotosFromAPI()
            photoLocalDataSource.savePhotosToDB(photoItemList)
        }

        return photoItemList
    }

    suspend fun getPhotosFromCache(): List<PhotoItem> {
        lateinit var photoItemList: List<PhotoItem>
        try {
            photoItemList = photoCacheDataSource.getPhotosFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (photoItemList.size > 0) {
            return photoItemList
        } else {
            photoItemList = getPhotosFromDB()
            photoCacheDataSource.savePhotosToCache(photoItemList)
        }

        return photoItemList
    }


}