package com.example.tmdbclient.data.repository.movie.dataSource

import com.example.tmdbclient.data.model.movie.MovieList
import retrofit2.Response


interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}