package com.rizkykurniawan.jetpackpro.submission.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    var movieId: String,
    var title: String,
    var description: String,
    var score: String,
    var releaseDate: String,
    var posterDrawable: String,
) : Parcelable
