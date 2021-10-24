package com.strink.apirequest.api

import com.strink.apirequest.BuildConfig
import com.strink.apirequest.data.Result
import com.strink.apirequest.data.TheMovieDB
import retrofit2.Call
import retrofit2.http.GET

interface MovieRequest {

    @GET("3/movie/popular?api_key="+BuildConfig.TMDB_API_KEY)
    fun getMovies() : Call<TheMovieDB>
}