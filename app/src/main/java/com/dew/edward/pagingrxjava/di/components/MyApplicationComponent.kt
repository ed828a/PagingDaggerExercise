package com.dew.edward.pagingrxjava.di.components

import com.dew.edward.pagingrxjava.backend.ServiceApi
import com.dew.edward.pagingrxjava.di.modules.MovieSourceModule
import com.dew.edward.pagingrxjava.di.modules.PicassoModule
import com.dew.edward.pagingrxjava.di.scope.CustomApplicationScope
import com.dew.edward.pagingrxjava.models.MovieModel
import com.squareup.picasso.Picasso
import dagger.Component


/**
 * Created by Edward on 7/21/2018.
 */


@CustomApplicationScope
@Component(modules = [MovieSourceModule::class, PicassoModule::class])
interface MyApplicationComponent {

    fun serviceApi(): ServiceApi

    fun movieModel(): MovieModel

    fun picasso() : Picasso
}