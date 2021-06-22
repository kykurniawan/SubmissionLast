package com.rizkykurniawan.jetpackpro.submission.di

import android.content.Context
import com.rizkykurniawan.jetpackpro.submission.data.source.MovieRepository
import com.rizkykurniawan.jetpackpro.submission.data.source.TVShowRepository
import com.rizkykurniawan.jetpackpro.submission.data.source.remote.RemoteDataSource
import com.rizkykurniawan.jetpackpro.submission.utils.JsonHelper

object Injection {
    fun provideMovieRepository(context: Context): MovieRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return MovieRepository.getInstance(remoteDataSource)
    }

    fun provideTVShowRepository(context: Context): TVShowRepository {
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return TVShowRepository.getInstance(remoteDataSource)
    }
}