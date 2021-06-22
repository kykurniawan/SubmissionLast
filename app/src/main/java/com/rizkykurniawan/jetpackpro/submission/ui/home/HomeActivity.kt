package com.rizkykurniawan.jetpackpro.submission.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.rizkykurniawan.jetpackpro.submission.R
import com.rizkykurniawan.jetpackpro.submission.databinding.ActivityHomeBinding
import com.rizkykurniawan.jetpackpro.submission.ui.favorite.FavoriteActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityHomeViewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeViewBinding.root)
        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        activityHomeViewBinding.viewPager.adapter = sectionPagerAdapter
        activityHomeViewBinding.tabs.setupWithViewPager(activityHomeViewBinding.viewPager)
        supportActionBar?.elevation = 0f
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_favorite, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_favorite -> {
                val intent = Intent(this, FavoriteActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}