package com.afshinshahriarifahliani.photogallery.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItem


@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePhotos(photoItems: List<PhotoItem>)

    @Query("DELETE FROM photo_table")
    suspend fun deleteAllPhotos()

    @Query("SELECT * FROM photo_table")
    suspend fun getAllPhotos(): List<PhotoItem>
}