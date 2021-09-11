package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.repository.ArtistRepoImpl
import com.example.tmdbclient.data.repository.MovieRepoImpl
import com.example.tmdbclient.data.repository.TvShowRepoImpl
import com.example.tmdbclient.data.repository.artist.dataSource.ArtistCacheDataSource
import com.example.tmdbclient.data.repository.artist.dataSource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.artist.dataSource.ArtistRemoteDataSource
import com.example.tmdbclient.data.repository.movie.dataSource.MovieCacheDataSource
import com.example.tmdbclient.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.dataSource.MovieRemoteDataSource
import com.example.tmdbclient.data.repository.tvShow.dataSource.TvShowCacheDataSource
import com.example.tmdbclient.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.tvShow.dataSource.TvShowRemoteDataSource
import com.example.tmdbclient.domain.repository.ArtistRepo
import com.example.tmdbclient.domain.repository.MovieRepo
import com.example.tmdbclient.domain.repository.TvShowRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepositoryModule(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepo {

        return MovieRepoImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)

    }

    @Singleton
    @Provides
    fun provideArtistRepositoryModule(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepo {
        return ArtistRepoImpl(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)
    }


    @Singleton
    @Provides
    fun provideTvShowRepositoryModule(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepo {

        return TvShowRepoImpl(tvShowRemoteDataSource,tvShowLocalDataSource,tvShowCacheDataSource)
    }


}