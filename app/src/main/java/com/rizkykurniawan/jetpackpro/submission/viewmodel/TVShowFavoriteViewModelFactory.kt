package com.rizkykurniawan.jetpackpro.submission.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rizkykurniawan.jetpackpro.submission.ui.favorite.tvshow.TVShowFavoriteViewModel

class TVShowFavoriteViewModelFactory private constructor(private val mApplication: Application) : ViewModelProvider.NewInstanceFactory() {

        companion object {
            @Volatile
            private var INSTANCE: TVShowFavoriteViewModelFactory? = null

            @JvmStatic
            fun getInstance(application: Application): TVShowFavoriteViewModelFactory {
                if (INSTANCE == null) {
                    synchronized(TVShowFavoriteViewModelFactory::class.java) {
                        INSTANCE = TVShowFavoriteViewModelFactory(application)
                    }
                }
                return INSTANCE as TVShowFavoriteViewModelFactory
            }
        }

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TVShowFavoriteViewModel::class.java)) return TVShowFavoriteViewModel(mApplication) as T
            throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
}