package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.domain.repository.MovieRepo


class GetMoviesUseCase(private val movieRepo: MovieRepo) {

    suspend fun execute():List<Movie>? = movieRepo.getMovies()
}