package com.rizkykurniawan.jetpackpro.submission.ui.favorite.tvshow

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
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.TVShowEntity
import com.rizkykurniawan.jetpackpro.submission.databinding.ItemsMovieBinding
import com.rizkykurniawan.jetpackpro.submission.databinding.ItemsTvShowBinding
import com.rizkykurniawan.jetpackpro.submission.ui.favorite.movie.MovieFavoritePagedListAdapter
import com.rizkykurniawan.jetpackpro.submission.ui.tvshow.TVShowDetailActivity

class TVShowFavoritePagedListAdapter(private val activity: Activity): PagedListAdapter<TVShowEntity, TVShowFavoritePagedListAdapter.TVShowViewHolder>(
    DIFF_CALLBACK
) {

    inner class TVShowViewHolder(private val binding: ItemsTvShowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShowEntity: TVShowEntity) {
            with(binding) {
                tvItemTitle.text = tvShowEntity.title
                tvItemSeason.text = itemView.context.getString(R.string.Season_, tvShowEntity.season)
                itemView.setOnClickListener {
                    Snackbar.make(this.root, tvShowEntity.title, Snackbar.LENGTH_SHORT).show()
                    val intent = Intent(itemView.context, TVShowFavoriteDetailActivity::class.java)
                    intent.putExtra(TVShowDetailActivity.EXTRA_TV_SHOW_ID, tvShowEntity.tvShowId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(tvShowEntity.posterDrawable)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }
    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<TVShowEntity> = object : DiffUtil.ItemCallback<TVShowEntity>() {
            override fun areItemsTheSame(oldTVShow: TVShowEntity, newTVShow: TVShowEntity): Boolean {
                return oldTVShow.title == newTVShow.title && oldTVShow.description == newTVShow.description
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldTVShow: TVShowEntity, newTVShow: TVShowEntity): Boolean {
                return oldTVShow == newTVShow
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val binding = ItemsTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        holder.bind(getItem(position) as TVShowEntity)
    }
}