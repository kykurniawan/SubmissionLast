package com.rizkykurniawan.jetpackpro.submission.ui.tvshow

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rizkykurniawan.jetpackpro.submission.R
import com.rizkykurniawan.jetpackpro.submission.databinding.ActivityTvShowDetailBinding
import com.rizkykurniawan.jetpackpro.submission.ui.favorite.movie.MovieFavoriteViewModel
import com.rizkykurniawan.jetpackpro.submission.ui.favorite.tvshow.TVShowFavoriteViewModel
import com.rizkykurniawan.jetpackpro.submission.viewmodel.MovieFavoriteViewModelFactory
import com.rizkykurniawan.jetpackpro.submission.viewmodel.TVShowFavoriteViewModelFactory
import com.rizkykurniawan.jetpackpro.submission.viewmodel.TVShowViewModelFactory

class TVShowDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOW_ID = "extra_tv_show_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tvShowDetailBinding = ActivityTvShowDetailBinding.inflate(layoutInflater)
        setContentView(tvShowDetailBinding.root)

        val factory = TVShowViewModelFactory.getInstance(this)
        val tvShowViewModel = ViewModelProvider(this, factory)[TVShowViewModel::class.java]
        val tvShowFavoriteViewModel = obtainViewModel(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras
        val tvShowId = extras?.getString(EXTRA_TV_SHOW_ID)

        tvShowDetailBinding.progressBar.visibility = View.VISIBLE
        if (tvShowId != null) {
            tvShowViewModel.getDetailTVShow(tvShowId).observe(this, { tvShow ->
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
                        tvShowFavoriteViewModel.insert(tvShow)
                        Toast.makeText(this, getString(R.string.added_to_favorite), Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }

    private fun obtainViewModel(activity: AppCompatActivity): TVShowFavoriteViewModel {
        val factory = TVShowFavoriteViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(TVShowFavoriteViewModel::class.java)
    }
}