package com.afshinshahriarifahliani.photogallery.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.afshinshahriarifahliani.photogallery.data.model.photo.PhotoItem


@Database(
    entities = [PhotoItem::class],
    version = 1,
    exportSchema = false
)
abstract class PhotoDatabase : RoomDatabase() {
    abstract fun photoDao(): PhotoDao

}