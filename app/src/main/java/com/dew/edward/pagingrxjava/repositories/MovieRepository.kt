package com.dew.edward.pagingrxjava.repositories

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.dew.edward.pagingrxjava.response.MovieResponse


/**
 * Created by Edward on 7/21/2018.
 */

interface MovieRepository {

    fun getMovies(): LiveData<PagedList<MovieResponse.Movie>>

}