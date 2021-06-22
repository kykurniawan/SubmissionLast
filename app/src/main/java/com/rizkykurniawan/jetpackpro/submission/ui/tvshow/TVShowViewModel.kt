package com.rizkykurniawan.jetpackpro.submission.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rizkykurniawan.jetpackpro.submission.data.source.TVShowRepository
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.TVShowEntity

class TVShowViewModel(private val tvShowRepository: TVShowRepository) : ViewModel() {
    fun getTVShows(): LiveData<List<TVShowEntity>> = tvShowRepository.getAllTVShows()

    fun getDetailTVShow(tvShowId: String): LiveData<TVShowEntity?> =
        tvShowRepository.getDetailTVShow(tvShowId)
}