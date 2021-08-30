package com.example.tmdbclient.data.repository

import android.util.Log
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.repository.movie.dataSource.MovieCacheDataSource
import com.example.tmdbclient.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.example.tmdbclient.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.tmdbclient.domain.repository.MovieRepo
import java.lang.Exception


class MovieRepoImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource

): MovieRepo {
    override suspend fun getMovies(): List<Movie>? {

        return getMoviesFromCache();
    }

    override suspend fun updateMovies(): List<Movie>? {

        val newListMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListMovies)
        movieCacheDataSource.saveMoviesToCache(newListMovies)

        return newListMovies
    }


    suspend fun getMoviesFromAPI():List<Movie>{
        var movieList:List<Movie> = ArrayList<Movie>()

        try {
            val response =movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body!=null){
                movieList = body.movies
            }

        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }


        return movieList
    }

    suspend fun getMoviesFromDB(): List<Movie> {
        var movieList: List<Movie> = ArrayList<Movie>()
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.size>0){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }

        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{

        var movieList: List<Movie> = ArrayList<Movie>()
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }

        if (movieList.size>0){
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }


}