package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.data.db.ArtistDao
import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.TvShowDao
import com.example.tmdbclient.data.repository.artist.dataSource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.movie.dataSource.MovieLocalDataSource
import com.example.tmdbclient.data.repository.movie.dataSourceImpl.MovieLocalDataSourceImpl
import com.example.tmdbclient.data.repository.tvShow.dataSource.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.artist.dataSourceImpl.ArtistLocalDataSourceImpl
import com.example.tmdbclient.data.repository.tvShow.dataSourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun getMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao);
    }

    @Singleton
    @Provides
    fun getArtistLocalDataSource(artistDao: ArtistDao):ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao);
    }

    @Singleton
    @Provides
    fun getTvShowLocalDataSource(tvShowDao: TvShowDao):TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao);
    }
}