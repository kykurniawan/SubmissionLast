package com.rizkykurniawan.jetpackpro.submission.ui.favorite.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.rizkykurniawan.jetpackpro.submission.databinding.FragmentTvShowFavoriteBinding
import com.rizkykurniawan.jetpackpro.submission.viewmodel.TVShowFavoriteViewModelFactory

class TVShowFavoriteFragment: Fragment() {
    private lateinit var fragmentTVShowFavoriteBinding: FragmentTvShowFavoriteBinding
    private lateinit var tvShowFavoritePagedListAdapter: TVShowFavoritePagedListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTVShowFavoriteBinding = FragmentTvShowFavoriteBinding.inflate(layoutInflater, container, false)
        return fragmentTVShowFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = TVShowFavoriteViewModelFactory.getInstance(requireActivity().application)
            val viewModel = ViewModelProvider(this, factory)[TVShowFavoriteViewModel::class.java]
            tvShowFavoritePagedListAdapter = TVShowFavoritePagedListAdapter(requireActivity())

            fragmentTVShowFavoriteBinding.progressBar.visibility = View.VISIBLE
            viewModel.getAllTVShows().observe(viewLifecycleOwner, { tvShows ->
                fragmentTVShowFavoriteBinding.progressBar.visibility = View.GONE
                tvShowFavoritePagedListAdapter.submitList(tvShows)
            })
            with(fragmentTVShowFavoriteBinding.rvTvShow) {
                layoutManager = GridLayoutManager(context, 2)
                adapter = tvShowFavoritePagedListAdapter
            }
        }
    }
}