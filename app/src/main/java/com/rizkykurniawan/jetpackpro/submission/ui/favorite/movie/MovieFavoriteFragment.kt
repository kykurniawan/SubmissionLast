package com.rizkykurniawan.jetpackpro.submission.ui.favorite.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.rizkykurniawan.jetpackpro.submission.databinding.FragmentMovieFavoriteBinding
import com.rizkykurniawan.jetpackpro.submission.viewmodel.MovieFavoriteViewModelFactory

class MovieFavoriteFragment : Fragment() {
    private lateinit var fragmentMovieFavoriteBinding: FragmentMovieFavoriteBinding
    private lateinit var movieFavoritePagedListAdapter: MovieFavoritePagedListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMovieFavoriteBinding = FragmentMovieFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentMovieFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = MovieFavoriteViewModelFactory.getInstance(requireActivity().application)
            val viewModel = ViewModelProvider(this, factory)[MovieFavoriteViewModel::class.java]
            movieFavoritePagedListAdapter = MovieFavoritePagedListAdapter(requireActivity())

            fragmentMovieFavoriteBinding.progressBar.visibility = View.VISIBLE
            viewModel.getAllMovies().observe(viewLifecycleOwner, { movies ->
                fragmentMovieFavoriteBinding.progressBar.visibility = View.GONE
                movieFavoritePagedListAdapter.submitList(movies)
            })
            with(fragmentMovieFavoriteBinding.rvMovie) {
                layoutManager = GridLayoutManager(context, 2)
                adapter = movieFavoritePagedListAdapter
            }
        }
    }
}