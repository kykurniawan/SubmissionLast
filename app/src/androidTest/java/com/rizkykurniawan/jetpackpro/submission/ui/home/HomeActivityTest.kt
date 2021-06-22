package com.rizkykurniawan.jetpackpro.submission.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.rizkykurniawan.jetpackpro.submission.R
import com.rizkykurniawan.jetpackpro.submission.utils.DummyData
import com.rizkykurniawan.jetpackpro.submission.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val dummyMovie = DummyData.generateDummyMovies()
    private val dummyTvShow = DummyData.generateDummyTVShows()

    @get:Rule
    val activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.scroll_view_movie)).perform(swipeUp())
        onView(withId(R.id.movie_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_detail_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_detail_release_date)).check(matches(withText(dummyMovie[0].releaseDate)))
        onView(withId(R.id.movie_detail_score)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_detail_score)).check(matches(withText("Score : ${dummyMovie[0].score}")))
        onView(withId(R.id.movie_detail_description)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_detail_description)).check(matches(withText(dummyMovie[0].description)))
    }

    @Test
    fun loadTvShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.scroll_view_tv_show)).perform(swipeUp())
        onView(withId(R.id.tv_show_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_detail_season)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_detail_season)).check(matches(withText("Season : ${dummyTvShow[0].season}")))
        onView(withId(R.id.tv_show_detail_score)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_detail_score)).check(matches(withText("Score : ${dummyTvShow[0].score}")))
        onView(withId(R.id.tv_show_detail_description)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show_detail_description)).check(matches(withText(dummyTvShow[0].description)))
    }
}