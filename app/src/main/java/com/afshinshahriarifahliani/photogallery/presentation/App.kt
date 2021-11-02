package com.afshinshahriarifahliani.photogallery.presentation

import android.app.Application
import com.afshinshahriarifahliani.photogallery.BuildConfig
import com.afshinshahriarifahliani.photogallery.presentation.di.Injector
import com.afshinshahriarifahliani.photogallery.presentation.di.core.*
import com.afshinshahriarifahliani.photogallery.presentation.di.photo.PhotoSubComponent


class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule())
            .build()

    }

    override fun createPhotoSubComponent(): PhotoSubComponent {
        return appComponent.photoSubComponent().create()
    }


}