package com.afshinshahriarifahliani.photogallery.presentation.di.photo

import com.afshinshahriarifahliani.photogallery.presentation.ui.dashboard.DashboardFragment
import com.afshinshahriarifahliani.photogallery.presentation.ui.home.HomeFragment
import dagger.Subcomponent

@PhotoScope
@Subcomponent(modules = [PhotoModule::class])
interface PhotoSubComponent {
    fun inject(homeFragment: HomeFragment)
    fun inject(dashboardFragment: DashboardFragment)
    @Subcomponent.Factory
    interface Factory {
        fun create(): PhotoSubComponent
    }

}

