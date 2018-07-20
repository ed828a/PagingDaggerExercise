package com.dew.edward.pagingrxjava.activity

import android.arch.lifecycle.Observer
import android.arch.paging.PagedList
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.dew.edward.pagingrxjava.R
import com.dew.edward.pagingrxjava.adapter.MovieAdapter
import com.dew.edward.pagingrxjava.models.MovieModel
import com.dew.edward.pagingrxjava.response.MovieResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var movieModel: MovieModel
    @Inject
    lateinit var picasso: Picasso
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getComponent().inject(this)
        setAdapter()
        movieModel.getMoviesObserver()
                .observe(this, Observer<PagedList<MovieResponse.Movie>> {
                    movieAdapter.submitList(it)
                })
    }

    private fun setAdapter() {
        movieRecyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        movieRecyclerView.setHasFixedSize(true)
        movieAdapter = MovieAdapter(this, picasso)
        movieRecyclerView.adapter = movieAdapter
    }

    override fun onStop() {
        super.onStop()
        movieModel
                .getMoviesObserver()
                .removeObservers(this)
    }
}
