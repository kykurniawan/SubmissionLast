package com.rizkykurniawan.jetpackpro.submission.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rizkykurniawan.jetpackpro.submission.ui.favorite.movie.MovieFavoriteViewModel

class MovieFavoriteViewModelFactory private constructor(private val mApplication: Application) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var INSTANCE: MovieFavoriteViewModelFactory? = null

        @JvmStatic
        fun getInstance(application: Application): MovieFavoriteViewModelFactory {
            if (INSTANCE == null) {
                synchronized(MovieFavoriteViewModelFactory::class.java) {
                    INSTANCE = MovieFavoriteViewModelFactory(application)
                }
            }
            return INSTANCE as MovieFavoriteViewModelFactory
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieFavoriteViewModel::class.java)) return MovieFavoriteViewModel(mApplication) as T
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}