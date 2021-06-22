package com.rizkykurniawan.jetpackpro.submission.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.rizkykurniawan.jetpackpro.submission.data.source.TVShowRepository
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.TVShowEntity
import com.rizkykurniawan.jetpackpro.submission.utils.DummyData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVShowViewModelTest {

    private lateinit var viewModel: TVShowViewModel
    private val dummyTVShow = DummyData.generateDummyTVShows()[0]
    private val tvShowId = dummyTVShow.tvShowId

    @Mock
    private lateinit var tvShowRepository: TVShowRepository

    @Mock
    private lateinit var observer: Observer<List<TVShowEntity>>

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = TVShowViewModel(tvShowRepository)
    }

    @Test
    fun testGetTVShows() {
        val dummyTVShows = DummyData.generateDummyTVShows()
        val tvShows = MutableLiveData<List<TVShowEntity>>()
        tvShows.value = dummyTVShows

        `when`(tvShowRepository.getAllTVShows()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getTVShows().value
        verify(tvShowRepository).getAllTVShows()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities?.size)

        viewModel.getTVShows().observeForever(observer)
        verify(observer).onChanged(dummyTVShows)
    }

    @Test
    fun testGetDetailTVShow() {
        val tvShow = MutableLiveData<TVShowEntity>()
        tvShow.value = dummyTVShow

        `when`(tvShowRepository.getDetailTVShow(tvShowId)).thenReturn(tvShow)
        val tvShowEntity = viewModel.getDetailTVShow(tvShowId).value as TVShowEntity
        verify(tvShowRepository).getDetailTVShow(tvShowId)
        assertNotNull(tvShowEntity)
        assertEquals(dummyTVShow, tvShowEntity)
        assertEquals(dummyTVShow.title, tvShowEntity.title)
        assertEquals(dummyTVShow.season, tvShowEntity.season)
        assertEquals(dummyTVShow.posterDrawable, tvShowEntity.posterDrawable)
        assertEquals(dummyTVShow.score, tvShowEntity.score)
        assertEquals(dummyTVShow.description, tvShowEntity.description)


    }
}