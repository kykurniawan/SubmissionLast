package com.rizkykurniawan.jetpackpro.submission.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.MovieEntity
import com.rizkykurniawan.jetpackpro.submission.data.source.remote.RemoteDataSource
import com.rizkykurniawan.jetpackpro.submission.data.source.remote.response.MovieResponse

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteData: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData).apply { instance = this }
            }
    }

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val movieResults = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallBack {
            override fun onAllMoviesReceived(movieResponses: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieResponses) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.title,
                        response.description,
                        response.score,
                        response.releaseDate,
                        response.posterDrawable
                    )
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }
        })

        return movieResults
    }

    override fun getDetailMovie(movieId: String?): LiveData<MovieEntity?> {
        val movieResult = MutableLiveData<MovieEntity?>()
        remoteDataSource.getDetailMovie(movieId, object : RemoteDataSource.LoadMovieCallBack {
            override fun onMovieReceived(movieResponse: MovieResponse?) {
                if (movieResponse != null) {
                    movieResult.postValue(
                        MovieEntity(
                            movieResponse.movieId,
                            movieResponse.title,
                            movieResponse.description,
                            movieResponse.score,
                            movieResponse.releaseDate,
                            movieResponse.posterDrawable
                        )
                    )
                } else {
                    movieResult.postValue(null)
                }
            }
        })
        return movieResult
    }
}