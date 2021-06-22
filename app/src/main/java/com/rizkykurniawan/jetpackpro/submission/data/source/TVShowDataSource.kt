package com.rizkykurniawan.jetpackpro.submission.data.source

import androidx.lifecycle.LiveData
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.TVShowEntity

interface TVShowDataSource {
    fun getAllTVShows(): LiveData<List<TVShowEntity>>

    fun getDetailTVShow(tvShowId: String): LiveData<TVShowEntity?>
}