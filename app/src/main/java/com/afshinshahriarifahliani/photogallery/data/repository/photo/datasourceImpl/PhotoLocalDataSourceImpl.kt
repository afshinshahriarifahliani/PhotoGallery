package com.afshinshahriarifahliani.photogallery.repository.photo.datasourceImpl


import com.afshinshahriarifahliani.photogallery.data.db.PhotoDao
import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItem
import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItemList
import com.afshinshahriarifahliani.photogallery.repository.photo.datasource.PhotoLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhotoLocalDataSourceImpl(private val photoDao: PhotoDao) :
    PhotoLocalDataSource {
    override suspend fun getPhotosFromDB(): List<PhotoItem> {
        return photoDao.getAllPhotos()
    }

    override suspend fun savePhotosToDB(photoItems: List<PhotoItem>) {
        CoroutineScope(Dispatchers.IO).launch {
            photoDao.savePhotos(photoItems)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            photoDao.deleteAllPhotos()
        }
    }
}