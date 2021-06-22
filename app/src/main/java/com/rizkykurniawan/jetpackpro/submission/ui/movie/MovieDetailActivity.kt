package com.rizkykurniawan.jetpackpro.submission.ui.movie

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rizkykurniawan.jetpackpro.submission.R
import com.rizkykurniawan.jetpackpro.submission.databinding.ActivityMovieDetailBinding
import com.rizkykurniawan.jetpackpro.submission.ui.favorite.movie.MovieFavoriteViewModel
import com.rizkykurniawan.jetpackpro.submission.viewmodel.MovieFavoriteViewModelFactory
import com.rizkykurniawan.jetpackpro.submission.viewmodel.MovieViewModelFactory

class MovieDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = MovieViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        val movieFavoriteViewModel = obtainViewModel(this)

        val movieDetailBinding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(movieDetailBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras
        val movieId = extras?.getString(EXTRA_MOVIE_ID)

        movieDetailBinding.progressBar.visibility = View.VISIBLE
        viewModel.getDetailMovie(movieId).observe(this, { movie ->
            movieDetailBinding.progressBar.visibility = View.GONE
            Glide
                .with(this)
                .load(movie?.posterDrawable)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
                )
                .into(movieDetailBinding.movieDetailPoster)
            movieDetailBinding.movieDetailTitle.text = movie?.title
            movieDetailBinding.movieDetailReleaseDate.text = movie?.releaseDate
            movieDetailBinding.movieDetailScore.text = getString(R.string.Score_, movie?.score)
            movieDetailBinding.movieDetailDescription.text = movie?.description

            movieDetailBinding.favoriteButton.setOnClickListener {
                if (movie != null) {
                    movieFavoriteViewModel.insert(movie)
                    Toast.makeText(this, getString(R.string.added_to_favorite), Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun obtainViewModel(activity: AppCompatActivity): MovieFavoriteViewModel {
        val factory = MovieFavoriteViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(MovieFavoriteViewModel::class.java)
    }
}