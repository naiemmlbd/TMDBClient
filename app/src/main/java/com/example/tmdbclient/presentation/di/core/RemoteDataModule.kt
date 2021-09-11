package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.example.tmdbclient.data.repository.artist.dataSourceImpl.ArtistRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.tmdbclient.data.repository.movie.dataSourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.tmdbclient.data.repository.tvShow.dataSourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun getMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {

        return MovieRemoteDataSourceImpl(tmdbService, apiKey)

    }

    @Singleton
    @Provides
    fun getArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {

        return ArtistRemoteDataSourceImpl(tmdbService, apiKey)

    }

    @Singleton
    @Provides
    fun getTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {

        return TvShowRemoteDataSourceImpl(tmdbService, apiKey)

    }


}