package com.dew.edward.pagingrxjava.activity


/**
 * Created by Edward on 7/21/2018.
 */

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dew.edward.pagingrxjava.backend.MyCustomApplicationClass
import com.dew.edward.pagingrxjava.di.components.ActivityComponent
import com.dew.edward.pagingrxjava.di.components.DaggerActivityComponent


@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    private lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerActivityComponent
                .builder()
                .myApplicationComponent(getApp().getService())
                .build()
    }

    protected fun getComponent() = activityComponent

    private fun getApp() = application.applicationContext as MyCustomApplicationClass
}