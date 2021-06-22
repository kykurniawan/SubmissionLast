package com.rizkykurniawan.jetpackpro.submission.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rizkykurniawan.jetpackpro.submission.data.source.MovieRepository
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.MovieEntity

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getMovies(): LiveData<List<MovieEntity>> = movieRepository.getAllMovies()
    fun getDetailMovie(movieId: String?): LiveData<MovieEntity?> =
        movieRepository.getDetailMovie(movieId)
}