package com.rizkykurniawan.jetpackpro.submission.data.source

import androidx.lifecycle.LiveData
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.MovieEntity

interface MovieDataSource {
    fun getAllMovies(): LiveData<List<MovieEntity>>

    fun getDetailMovie(movieId: String?): LiveData<MovieEntity?>
}