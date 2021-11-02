package com.afshinshahriarifahliani.photogallery.presentation.di.core

import com.afshinshahriarifahliani.photogallery.presentation.di.photo.PhotoSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DataBaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {

    fun photoSubComponent(): PhotoSubComponent.Factory


}