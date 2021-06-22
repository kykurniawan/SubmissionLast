package com.rizkykurniawan.jetpackpro.submission.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.rizkykurniawan.jetpackpro.submission.data.source.remote.RemoteDataSource
import com.rizkykurniawan.jetpackpro.submission.utils.DummyData
import com.rizkykurniawan.jetpackpro.submission.utils.LiveDataTestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val moviesResponse = DummyData.generateRemoteDummyMovies()
    private val movieDetailResponse = moviesResponse[0]
    private val movieId = movieDetailResponse.movieId

    @Test
    fun getAllMovies() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.LoadMoviesCallBack)
                .onAllMoviesReceived(moviesResponse)
            null
        }.`when`(remote).getAllMovies(any())

        val movieEntities = LiveDataTestUtil.getValue(movieRepository.getAllMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertEquals(moviesResponse.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[1] as RemoteDataSource.LoadMovieCallBack)
                .onMovieReceived(movieDetailResponse)
            null
        }.`when`(remote).getDetailMovie(eq(movieId), any())

        val movieEntity = LiveDataTestUtil.getValue(movieRepository.getDetailMovie(movieId))
        verify(remote).getDetailMovie(eq(movieId), any())
        assertNotNull(movieEntity)
        assertEquals(movieDetailResponse.title, movieEntity?.title)
        assertEquals(movieDetailResponse.description, movieEntity?.description)
        assertEquals(movieDetailResponse.score, movieEntity?.score)
        assertEquals(movieDetailResponse.releaseDate, movieEntity?.releaseDate)
        assertEquals(movieDetailResponse.posterDrawable, movieEntity?.posterDrawable)
    }
}