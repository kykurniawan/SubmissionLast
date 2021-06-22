package com.rizkykurniawan.jetpackpro.submission.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TVShowResponse(
    var tvShowId: String,
    var title: String,
    var description: String,
    var score: String,
    var season: Int,
    var posterDrawable: String,
):Parcelable
