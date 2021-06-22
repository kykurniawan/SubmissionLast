package com.rizkykurniawan.jetpackpro.submission.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.snackbar.Snackbar
import com.rizkykurniawan.jetpackpro.submission.R
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.TVShowEntity
import com.rizkykurniawan.jetpackpro.submission.databinding.ItemsTvShowBinding

class TVShowAdapter : RecyclerView.Adapter<TVShowAdapter.TVShowViewHolder>() {
    private var listTVShows = ArrayList<TVShowEntity>()

    fun setTVShows(tvShows: List<TVShowEntity>) {
        this.listTVShows.clear()
        this.listTVShows.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
        val itemsTvShowBinding =
            ItemsTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        holder.bind(listTVShows[position])
    }

    override fun getItemCount(): Int = listTVShows.size

    class TVShowViewHolder(private val binding: ItemsTvShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TVShowEntity) {
            with(binding) {
                tvItemTitle.text = tvShow.title
                tvItemSeason.text = itemView.context.getString(R.string.Season_, tvShow.season)
                itemView.setOnClickListener {
                    Snackbar.make(this.root, tvShow.title, Snackbar.LENGTH_SHORT).show()
                    val intent = Intent(itemView.context, TVShowDetailActivity::class.java)
                    intent.putExtra(TVShowDetailActivity.EXTRA_TV_SHOW_ID, tvShow.tvShowId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(tvShow.posterDrawable)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }

}