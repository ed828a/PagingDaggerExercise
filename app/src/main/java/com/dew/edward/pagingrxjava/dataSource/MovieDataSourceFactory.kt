package com.dew.edward.pagingrxjava.dataSource

import android.arch.lifecycle.MutableLiveData
import com.dew.edward.pagingrxjava.backend.ServiceApi
import com.dew.edward.pagingrxjava.response.MovieResponse
import android.arch.paging.DataSource

/**
 * Created by Edward on 7/21/2018.
 */

class MovieDataSourceFactory(private val serviceApi: ServiceApi) : DataSource.Factory<Int, MovieResponse.Movie> (){

    private val mutableDataSource = MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, MovieResponse.Movie> {
        val dataSource = MovieDataSource(serviceApi)
        mutableDataSource.postValue(dataSource)
        return dataSource
    }
}
