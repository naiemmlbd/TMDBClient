package com.example.tmdbclient.data.repository.movie.dataSourceImpl

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.repository.artist.dataSource.ArtistRemoteDataSource
import retrofit2.Response


class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService,private val apiKey:String):
    ArtistRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}