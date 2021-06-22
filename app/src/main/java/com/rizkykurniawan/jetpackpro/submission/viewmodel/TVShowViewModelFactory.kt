package com.rizkykurniawan.jetpackpro.submission.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rizkykurniawan.jetpackpro.submission.data.source.TVShowRepository
import com.rizkykurniawan.jetpackpro.submission.di.Injection
import com.rizkykurniawan.jetpackpro.submission.ui.tvshow.TVShowViewModel

class TVShowViewModelFactory private constructor(private val mTVShowRepository: TVShowRepository): ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: TVShowViewModelFactory? = null
        fun getInstance(context: Context): TVShowViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: TVShowViewModelFactory(Injection.provideTVShowRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(TVShowViewModel::class.java) -> {
                return TVShowViewModel(mTVShowRepository) as T
            }
            else -> {
                throw Throwable("Unknown viewModel class: " + modelClass.name)
            }
        }
    }
}