package com.rizkykurniawan.jetpackpro.submission.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.rizkykurniawan.jetpackpro.submission.data.source.remote.RemoteDataSource
import com.rizkykurniawan.jetpackpro.submission.utils.DummyData
import com.rizkykurniawan.jetpackpro.submission.utils.LiveDataTestUtil
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito

class TVShowRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val tvShowRepository = FakeTVShowRepository(remote)

    private val tvShowsResponse = DummyData.generateRemoteDummyTVShows()
    private val tvShowDetailResponse = tvShowsResponse[0]
    private val tvShowId = tvShowDetailResponse.tvShowId

    @Test
    fun getAllTVShows() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.LoadTVShowsCallBack)
                .onAllTVShowsReceived(tvShowsResponse)
            null
        }.`when`(remote).getAllTVShows(any())

        val tvShowEntities = LiveDataTestUtil.getValue(tvShowRepository.getAllTVShows())
        verify(remote).getAllTVShows(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvShowsResponse.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getDetailTVShow() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[1] as RemoteDataSource.LoadTVShowCallBack)
                .onTVShowReceived(tvShowDetailResponse)
            null
        }.`when`(remote).getDetailTVShow(eq(tvShowId), any())

        val tvShowEntity = LiveDataTestUtil.getValue(tvShowRepository.getDetailTVShow(tvShowId))
        verify(remote).getDetailTVShow(eq(tvShowId), any())
        assertNotNull(tvShowEntity)
        assertEquals(tvShowDetailResponse.title, tvShowEntity?.title)
        assertEquals(tvShowDetailResponse.description, tvShowEntity?.description)
        assertEquals(tvShowDetailResponse.score, tvShowEntity?.score)
        assertEquals(tvShowDetailResponse.season, tvShowEntity?.season)
        assertEquals(tvShowDetailResponse.posterDrawable, tvShowEntity?.posterDrawable)
    }
}