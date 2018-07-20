package com.dew.edward.pagingrxjava.backend

import android.app.Application
import com.dew.edward.pagingrxjava.di.components.DaggerMyApplicationComponent
import com.dew.edward.pagingrxjava.di.components.MyApplicationComponent
import com.dew.edward.pagingrxjava.di.modules.ApplicationContextModule


/**
 * Created by Edward on 7/21/2018.
 */

class MyCustomApplicationClass : Application() {

    private lateinit var applicationComponent: MyApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerMyApplicationComponent
                .builder()
                .applicationContextModule(ApplicationContextModule(this))
                .build()
    }

    fun getService() = applicationComponent
}