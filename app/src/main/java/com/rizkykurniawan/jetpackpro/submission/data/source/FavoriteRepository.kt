package com.rizkykurniawan.jetpackpro.submission.data.source

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.sqlite.db.SimpleSQLiteQuery
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.MovieEntity
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.TVShowEntity
import com.rizkykurniawan.jetpackpro.submission.data.source.local.room.FavoriteDao
import com.rizkykurniawan.jetpackpro.submission.data.source.local.room.FavoriteDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoriteRepository(application: Application) {
    private val mFavoriteDao: FavoriteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = FavoriteDatabase.getDatabase(application)
        mFavoriteDao = db.favoriteDao()
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity>  = mFavoriteDao.getAllMovies()

    fun getDetailMovie(movieId: String?): LiveData<MovieEntity> {
        val query = SimpleSQLiteQuery("SELECT * FROM movieEntities WHERE movieId = '${movieId}'")
        return mFavoriteDao.getDetailMovie(query)
    }

    fun insertMovie(movie: MovieEntity) {
        executorService.execute{
            mFavoriteDao.insertMovie(movie)
        }
    }

    fun deleteMovie(movie: MovieEntity) {
        executorService.execute {
            mFavoriteDao.deleteMovie(movie)
        }
    }

    fun getAllTVShows(): DataSource.Factory<Int, TVShowEntity> = mFavoriteDao.getAllTVShows()

    fun insertTVShow(tvShow: TVShowEntity) {
        executorService.execute {
            mFavoriteDao.insertTVShow(tvShow)
        }
    }

    fun deleteTVShow(tvShow: TVShowEntity) {
        executorService.execute {
            mFavoriteDao.deleteTVShow(tvShow)
        }
    }

    fun getDetailTVShow(tvShowId: String?): LiveData<TVShowEntity> {
        val query = SimpleSQLiteQuery("SELECT * FROM tvShowEntities WHERE tvShowID = '${tvShowId}'")
        return mFavoriteDao.getDetailTVShow(query)
    }

}