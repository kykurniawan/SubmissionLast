package com.rizkykurniawan.jetpackpro.submission.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tvShowEntities")
data class TVShowEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "tvShowId")
        var tvShowId: String,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "description")
        var description: String,

        @ColumnInfo(name = "score")
        var score: String,

        @ColumnInfo(name = "season")
        var season: Int,

        @ColumnInfo(name = "posterDrawable")
        var posterDrawable: String,
): Parcelable

