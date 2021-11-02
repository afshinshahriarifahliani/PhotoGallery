package com.afshinshahriarifahliani.photogallery.presentation.di.core

import android.content.Context
import com.afshinshahriarifahliani.photogallery.presentation.di.photo.PhotoSubComponent

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [PhotoSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }


}