package com.example.tmdbclient.data.repository.movie.dataSource

import com.example.tmdbclient.data.model.movie.Movie


interface MovieLocalDataSource {

    suspend fun getMoviesFromDB():List<Movie>
    suspend fun saveMoviesToDB(movies:List<Movie>)
    suspend fun clearAll()
}