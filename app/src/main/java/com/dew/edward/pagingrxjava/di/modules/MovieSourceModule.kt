package com.dew.edward.pagingrxjava.di.modules

import android.app.Application
import android.content.Context
import com.dew.edward.pagingrxjava.backend.ServiceApi
import com.dew.edward.pagingrxjava.dataSource.MovieDataSourceFactory
import com.dew.edward.pagingrxjava.di.qualifiers.ApplicationContextQualifier
import com.dew.edward.pagingrxjava.di.scope.CustomApplicationScope
import com.dew.edward.pagingrxjava.models.MovieModel
import com.dew.edward.pagingrxjava.repositories.MovieRepositoryImp
import dagger.Module
import dagger.Provides


/**
 * Created by Edward on 7/21/2018.
 */

@Module(includes = [ServiceUtilModule::class])
class MovieSourceModule {

    @CustomApplicationScope
    @Provides
    fun provideMovieSourceFactory(serviceApi: ServiceApi) = MovieDataSourceFactory(serviceApi)

    @CustomApplicationScope
    @Provides
    fun provideMovieRepositoryImp(dataSourceFactory: MovieDataSourceFactory) = MovieRepositoryImp(dataSourceFactory)

    @CustomApplicationScope
    @Provides
    fun provideMovieModel(@ApplicationContextQualifier context: Context, movieRepositoryImp: MovieRepositoryImp) = MovieModel(context as Application, movieRepositoryImp)
}
