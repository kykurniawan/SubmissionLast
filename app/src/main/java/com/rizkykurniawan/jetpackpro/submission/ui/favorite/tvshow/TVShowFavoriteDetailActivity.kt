package com.rizkykurniawan.jetpackpro.submission.ui.favorite.tvshow

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rizkykurniawan.jetpackpro.submission.R
import com.rizkykurniawan.jetpackpro.submission.databinding.ActivityTvshowFavoriteDetailBinding
import com.rizkykurniawan.jetpackpro.submission.ui.favorite.FavoriteActivity
import com.rizkykurniawan.jetpackpro.submission.viewmodel.TVShowFavoriteViewModelFactory

class TVShowFavoriteDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TV_SHOW_ID = "extra_tv_show_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tvShowFavoriteViewModel = obtainViewModel(this)

        val tvShowDetailBinding = ActivityTvshowFavoriteDetailBinding.inflate(layoutInflater)
        setContentView(tvShowDetailBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras
        val tvShowId = extras?.getString(EXTRA_TV_SHOW_ID)

        tvShowDetailBinding.progressBar.visibility = View.VISIBLE
        tvShowFavoriteViewModel.getDetailTVShow(tvShowId).observe(this, { tvShow ->
            tvShowDetailBinding.progressBar.visibility = View.GONE
            Glide
                .with(this)
                .load(tvShow?.posterDrawable)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(tvShowDetailBinding.tvShowDetailPoster)
            tvShowDetailBinding.tvShowDetailTitle.text = tvShow?.title
            tvShowDetailBinding.tvShowDetailSeason.text =
                getString(R.string.Season_, tvShow?.season)
            tvShowDetailBinding.tvShowDetailScore.text =
                getString(R.string.Score_, tvShow?.score)
            tvShowDetailBinding.tvShowDetailDescription.text = tvShow?.description

            tvShowDetailBinding.favoriteButton.setOnClickListener {
                if (tvShow != null) {
                    tvShowFavoriteViewModel.delete(tvShow)
                    Toast.makeText(this, getString(R.string.deleted_from_favorite), Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, FavoriteActivity::class.java))
                }
            }
        })

    }

    private fun obtainViewModel(activity: AppCompatActivity): TVShowFavoriteViewModel {
        val factory = TVShowFavoriteViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(TVShowFavoriteViewModel::class.java)
    }
}