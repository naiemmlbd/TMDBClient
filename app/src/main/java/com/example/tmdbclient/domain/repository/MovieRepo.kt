package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.movie.Movie


interface MovieRepo {

    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}