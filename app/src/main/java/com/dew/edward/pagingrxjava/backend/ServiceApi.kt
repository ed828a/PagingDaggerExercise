package com.dew.edward.pagingrxjava.backend

import com.dew.edward.pagingrxjava.response.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Edward on 7/21/2018.
 */
interface ServiceApi {

    @GET(value = "popular")
    fun getPopular(@Query(value = "api_key", encoded = false) apiKey: String, @Query(value = "page", encoded = false) page: Int): Call<MovieResponse>
}