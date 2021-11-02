package com.afshinshahriarifahliani.photogallery.presentation.di

import com.afshinshahriarifahliani.photogallery.presentation.di.photo.PhotoSubComponent

interface Injector {
    fun createPhotoSubComponent(): PhotoSubComponent

}