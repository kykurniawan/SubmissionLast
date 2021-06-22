package com.rizkykurniawan.jetpackpro.submission.utils

import android.content.Context
import com.rizkykurniawan.jetpackpro.submission.data.source.remote.response.MovieResponse
import com.rizkykurniawan.jetpackpro.submission.data.source.remote.response.TVShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponse.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)
                val movieId = movie.getString("movieId")
                val title = movie.getString("title")
                val description = movie.getString("description")
                val score = movie.getString("score")
                val releaseDate = movie.getString("releaseDate")
                val posterDrawable = movie.getString("posterDrawable")

                list.add(MovieResponse(movieId, title, description, score, releaseDate, posterDrawable))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return  list
    }

    fun loadDetailMovie(id: String?): MovieResponse? {
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponse.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for(i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)
                if (movie.getString("movieId") == id) {
                    val movieId = movie.getString("movieId")
                    val title = movie.getString("title")
                    val description = movie.getString("description")
                    val score = movie.getString("score")
                    val releaseDate = movie.getString("releaseDate")
                    val posterDrawable = movie.getString("posterDrawable")

                    return MovieResponse(movieId, title, description, score, releaseDate, posterDrawable)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return null
    }

    fun loadTVShows(): List<TVShowResponse> {
        val list = ArrayList<TVShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TVShowResponse.json").toString())
            val listArray = responseObject.getJSONArray("tvShows")
            for(i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)
                val tvShowId = tvShow.getString("tvShowId")
                val title = tvShow.getString("title")
                val description = tvShow.getString("description")
                val score = tvShow.getString("score")
                val season = tvShow.getInt("season")
                val posterDrawable = tvShow.getString("posterDrawable")

                list.add(TVShowResponse(tvShowId, title, description, score, season, posterDrawable))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadDetailTVShow(id: String?): TVShowResponse? {
        try {
            val responseObject = JSONObject(parsingFileToString("TVShowResponse.json").toString())
            val listArray = responseObject.getJSONArray("tvShows")
            for(i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)
                if (tvShow.getString("tvShowId") == id) {
                    val tvShowId = tvShow.getString("tvShowId")
                    val title = tvShow.getString("title")
                    val description = tvShow.getString("description")
                    val score = tvShow.getString("score")
                    val season = tvShow.getInt("season")
                    val posterDrawable = tvShow.getString("posterDrawable")

                    return TVShowResponse(tvShowId, title, description, score, season, posterDrawable)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return null
    }
}