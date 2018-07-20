package com.dew.edward.pagingrxjava.repositories

import android.arch.lifecycle.LiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.arch.paging.PagedList.Config.Builder
import android.support.annotation.MainThread
import com.dew.edward.pagingrxjava.dataSource.MovieDataSourceFactory
import com.dew.edward.pagingrxjava.response.MovieResponse
import java.util.concurrent.Executors


/**
 * Created by Edward on 7/21/2018.
 */

class MovieRepositoryImp(private val movieDataSourceFactory: MovieDataSourceFactory) : MovieRepository {

    companion object {
        const val PAGE_SIZE = 15
    }

    @MainThread
    override fun getMovies(): LiveData<PagedList<MovieResponse.Movie>> {
        val config = Builder()
                .setInitialLoadSizeHint(PAGE_SIZE)
                .setPageSize(PAGE_SIZE)
                .build()
        return LivePagedListBuilder(movieDataSourceFactory, config)
                .setInitialLoadKey(1)
                .setFetchExecutor(Executors.newFixedThreadPool(3))
                .build()
    }
}
