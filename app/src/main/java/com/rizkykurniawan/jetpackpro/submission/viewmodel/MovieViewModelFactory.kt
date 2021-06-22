package com.rizkykurniawan.jetpackpro.submission.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rizkykurniawan.jetpackpro.submission.data.source.MovieRepository
import com.rizkykurniawan.jetpackpro.submission.di.Injection
import com.rizkykurniawan.jetpackpro.submission.ui.movie.MovieViewModel

class MovieViewModelFactory private constructor(private val mMovieRepository: MovieRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: MovieViewModelFactory? = null
        fun getInstance(context: Context): MovieViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: MovieViewModelFactory(Injection.provideMovieRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mMovieRepository) as T
            }
            else -> {
                throw Throwable("Unknown viewModel class: " + modelClass.name)
            }
        }
    }

}