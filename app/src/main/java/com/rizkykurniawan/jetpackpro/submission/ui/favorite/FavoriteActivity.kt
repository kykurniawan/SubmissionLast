package com.rizkykurniawan.jetpackpro.submission.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rizkykurniawan.jetpackpro.submission.R
import com.rizkykurniawan.jetpackpro.submission.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)
        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        activityFavoriteBinding.viewPager.adapter = sectionPagerAdapter
        activityFavoriteBinding.tabs.setupWithViewPager(activityFavoriteBinding.viewPager)
        supportActionBar?.elevation = 0f
        supportActionBar?.title = getString(R.string.action_favorite)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}