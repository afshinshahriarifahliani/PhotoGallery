package com.afshinshahriarifahliani.photogallery.data.model.photo


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "photo_table")
data class PhotoItem(
    @SerializedName("author")
    val author: String,
    @SerializedName("download_url")
    val downloadUrl: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
){
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}