package com.dew.edward.pagingrxjava.models

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.dew.edward.pagingrxjava.repositories.MovieRepositoryImp
import javax.inject.Inject

/**
 * Created by Edward on 7/21/2018.
 */

class MovieModel @Inject constructor(app: Application,
                                     private val movieRepositoryImp: MovieRepositoryImp) : AndroidViewModel(app) {

    fun getMoviesObserver() = movieRepositoryImp.getMovies()
}
