package com.rizkykurniawan.jetpackpro.submission.utils

import androidx.recyclerview.widget.DiffUtil
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.MovieEntity

class MovieFavoriteDiffCallback(private val mOldMovieList: List<MovieEntity>, private val mNewMovieList: List<MovieEntity>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldMovieList.size
    }

    override fun getNewListSize(): Int {
        return mNewMovieList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldMovieList[oldItemPosition].movieId == mNewMovieList[newItemPosition].movieId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldMovie = mOldMovieList[oldItemPosition]
        val newMovie = mNewMovieList[newItemPosition]
        return oldMovie.title == newMovie.title && oldMovie.description == newMovie.description && oldMovie.score == newMovie.score && oldMovie.releaseDate == newMovie.releaseDate && oldMovie.posterDrawable== newMovie.posterDrawable
    }

}