package com.example.tmdbclient.data.repository.movie.dataSource

import com.example.tmdbclient.data.model.movie.Movie


interface MovieCacheDataSource {

    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}