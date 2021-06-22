package com.rizkykurniawan.jetpackpro.submission.ui.favorite.tvshow

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.rizkykurniawan.jetpackpro.submission.data.source.FavoriteRepository
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.TVShowEntity

class TVShowFavoriteViewModel(application: Application): ViewModel() {
    private val mFavoriteRepository: FavoriteRepository = FavoriteRepository(application)

    fun insert(tvShowEntity: TVShowEntity) {
        mFavoriteRepository.insertTVShow(tvShowEntity)
    }

    fun delete(tvShowEntity: TVShowEntity) {
        mFavoriteRepository.deleteTVShow(tvShowEntity)
    }

    fun getAllTVShows(): LiveData<PagedList<TVShowEntity>> = LivePagedListBuilder(mFavoriteRepository.getAllTVShows(), 20).build()

    fun getDetailTVShow(tvShowId: String?): LiveData<TVShowEntity> = mFavoriteRepository.getDetailTVShow(tvShowId)
}