package com.rizkykurniawan.jetpackpro.submission.ui.favorite.movie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rizkykurniawan.jetpackpro.submission.R
import com.rizkykurniawan.jetpackpro.submission.databinding.ActivityMovieDetailBinding
import com.rizkykurniawan.jetpackpro.submission.databinding.ActivityMovieFavoriteDetailBinding
import com.rizkykurniawan.jetpackpro.submission.ui.favorite.FavoriteActivity
import com.rizkykurniawan.jetpackpro.submission.ui.movie.MovieViewModel
import com.rizkykurniawan.jetpackpro.submission.viewmodel.MovieFavoriteViewModelFactory
import com.rizkykurniawan.jetpackpro.submission.viewmodel.MovieViewModelFactory

class MovieFavoriteDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movieFavoriteViewModel = obtainViewModel(this)

        val movieFavoriteDetailBinding = ActivityMovieFavoriteDetailBinding.inflate(layoutInflater)
        setContentView(movieFavoriteDetailBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras
        val movieId = extras?.getString(EXTRA_MOVIE_ID)

        movieFavoriteDetailBinding.progressBar.visibility = View.VISIBLE
        movieFavoriteViewModel.getDetailMovie(movieId).observe(this, { movie ->
            movieFavoriteDetailBinding.progressBar.visibility = View.GONE
            Glide
                .with(this)
                .load(movie?.posterDrawable)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
                )
                .into(movieFavoriteDetailBinding.movieDetailPoster)
            movieFavoriteDetailBinding.movieDetailTitle.text = movie?.title
            movieFavoriteDetailBinding.movieDetailReleaseDate.text = movie?.releaseDate
            movieFavoriteDetailBinding.movieDetailScore.text = getString(R.string.Score_, movie?.score)
            movieFavoriteDetailBinding.movieDetailDescription.text = movie?.description

            movieFavoriteDetailBinding.favoriteButton.setOnClickListener {
                if (movie != null) {
                    movieFavoriteViewModel.delete(movie)
                    Toast.makeText(this, getString(R.string.deleted_from_favorite), Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, FavoriteActivity::class.java))
                }
            }
        })
    }

    private fun obtainViewModel(activity: AppCompatActivity): MovieFavoriteViewModel {
        val factory = MovieFavoriteViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(MovieFavoriteViewModel::class.java)
    }
}