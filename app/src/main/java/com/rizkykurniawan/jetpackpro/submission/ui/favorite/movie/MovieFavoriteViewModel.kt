package com.rizkykurniawan.jetpackpro.submission.ui.favorite.movie

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.rizkykurniawan.jetpackpro.submission.data.source.FavoriteRepository
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.MovieEntity

class MovieFavoriteViewModel(application: Application): ViewModel() {
    private val mFavoriteRepository: FavoriteRepository = FavoriteRepository(application)

    fun insert(movieEntity: MovieEntity) {
        mFavoriteRepository.insertMovie(movieEntity)
    }

    fun delete(movieEntity: MovieEntity) {
        mFavoriteRepository.deleteMovie(movieEntity)
    }

    fun getAllMovies(): LiveData<PagedList<MovieEntity>> = LivePagedListBuilder(mFavoriteRepository.getAllMovies(), 20).build()

    fun getDetailMovie(movieId: String?): LiveData<MovieEntity> = mFavoriteRepository.getDetailMovie(movieId)
}