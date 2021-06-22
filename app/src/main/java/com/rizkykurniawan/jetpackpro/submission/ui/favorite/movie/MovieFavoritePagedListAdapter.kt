package com.rizkykurniawan.jetpackpro.submission.ui.favorite.movie

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.snackbar.Snackbar
import com.rizkykurniawan.jetpackpro.submission.R
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.MovieEntity
import com.rizkykurniawan.jetpackpro.submission.databinding.ItemsMovieBinding
import com.rizkykurniawan.jetpackpro.submission.ui.movie.MovieDetailActivity
import com.rizkykurniawan.jetpackpro.submission.utils.MovieFavoriteDiffCallback

class MovieFavoritePagedListAdapter(private val activity: Activity): PagedListAdapter<MovieEntity, MovieFavoritePagedListAdapter.MovieViewHolder>(DIFF_CALLBACK)  {

    inner class MovieViewHolder(private val binding: ItemsMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movieEntity: MovieEntity) {
            with(binding) {
                tvItemTitle.text = movieEntity.title
                tvItemReleaseDate.text = movieEntity.releaseDate
                itemView.setOnClickListener {
                    Snackbar.make(this.root, movieEntity.title, Snackbar.LENGTH_SHORT).show()
                    val intent = Intent(itemView.context, MovieFavoriteDetailActivity::class.java)
                    intent.putExtra(MovieDetailActivity.EXTRA_MOVIE_ID, movieEntity.movieId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(movieEntity.posterDrawable)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<MovieEntity> = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldMovie: MovieEntity, newMovie: MovieEntity): Boolean {
                return oldMovie.title == newMovie.title && oldMovie.description == newMovie.description
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldMovie: MovieEntity, newMovie: MovieEntity): Boolean {
                return oldMovie == newMovie
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position) as MovieEntity)
    }
}