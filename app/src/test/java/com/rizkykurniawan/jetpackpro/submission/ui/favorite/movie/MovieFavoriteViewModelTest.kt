package com.rizkykurniawan.jetpackpro.submission.ui.favorite.movie

import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.MovieEntity
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieFavoriteViewModelTest {

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Test
    fun insert() {
    }

    @Test
    fun delete() {
    }

    @Test
    fun getAllMovies() {
    }

    @Test
    fun getDetailMovie() {
    }
}