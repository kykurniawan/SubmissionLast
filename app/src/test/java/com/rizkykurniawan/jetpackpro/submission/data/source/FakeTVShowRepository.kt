package com.rizkykurniawan.jetpackpro.submission.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.TVShowEntity
import com.rizkykurniawan.jetpackpro.submission.data.source.remote.RemoteDataSource
import com.rizkykurniawan.jetpackpro.submission.data.source.remote.response.TVShowResponse

class FakeTVShowRepository (private val remoteDataSource: RemoteDataSource): TVShowDataSource {
    override fun getAllTVShows(): LiveData<List<TVShowEntity>> {
        val tvShowResults = MutableLiveData<List<TVShowEntity>>()
        remoteDataSource.getAllTVShows(object : RemoteDataSource.LoadTVShowsCallBack {
            override fun onAllTVShowsReceived(tvShowResponses: List<TVShowResponse>) {
                val tvShowList = ArrayList<TVShowEntity>()
                for (response in tvShowResponses) {
                    val tvShow = TVShowEntity(
                        response.tvShowId,
                        response.title,
                        response.description,
                        response.score,
                        response.season,
                        response.posterDrawable
                    )
                    tvShowList.add(tvShow)
                }
                tvShowResults.postValue(tvShowList)
            }
        })

        return tvShowResults
    }

    override fun getDetailTVShow(tvShowId: String): LiveData<TVShowEntity?> {
        val tvShowResult = MutableLiveData<TVShowEntity?>()
        remoteDataSource.getDetailTVShow(tvShowId, object : RemoteDataSource.LoadTVShowCallBack {
            override fun onTVShowReceived(tvShowResponse: TVShowResponse?) {
                if (tvShowResponse != null) {
                    tvShowResult.postValue(
                        TVShowEntity(
                            tvShowResponse.tvShowId,
                            tvShowResponse.title,
                            tvShowResponse.description,
                            tvShowResponse.score,
                            tvShowResponse.season,
                            tvShowResponse.posterDrawable
                        )
                    )
                } else {
                    tvShowResult.postValue(null)
                }
            }
        })
        return tvShowResult
    }
}