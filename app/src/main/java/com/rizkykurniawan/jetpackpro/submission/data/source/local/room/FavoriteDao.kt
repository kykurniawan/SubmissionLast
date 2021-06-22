package com.rizkykurniawan.jetpackpro.submission.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.MovieEntity
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.TVShowEntity

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovie(movieEntity: MovieEntity)
    @Delete
    fun deleteMovie(movieEntity: MovieEntity)
    @Query("SELECT * FROM movieEntities ORDER BY movieId DESC")
    fun getAllMovies(): DataSource.Factory<Int, MovieEntity>
    @RawQuery(observedEntities = [MovieEntity::class])
    fun getDetailMovie(query: SupportSQLiteQuery): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTVShow(tvShowEntity: TVShowEntity)
    @Delete
    fun deleteTVShow(tvShowEntity: TVShowEntity)
    @Query("SELECT * FROM tvShowEntities ORDER BY tvShowId DESC")
    fun getAllTVShows(): DataSource.Factory<Int, TVShowEntity>
    @RawQuery(observedEntities = [TVShowEntity::class])
    fun getDetailTVShow(query: SupportSQLiteQuery): LiveData<TVShowEntity>
}