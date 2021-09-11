package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.domain.repository.ArtistRepo
import com.example.tmdbclient.domain.repository.MovieRepo
import com.example.tmdbclient.domain.repository.TvShowRepo
import com.example.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepo: MovieRepo): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepo);
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepo: MovieRepo): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepo);
    }

    @Provides
    fun provideGetArtistsUseCase(artistRepo: ArtistRepo): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepo);
    }

    @Provides
    fun provideUpdateArtistsUseCase(artistRepo: ArtistRepo): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepo);
    }

    @Provides
    fun provideUpdateTvShowsUseCase(tvShowRepo: TvShowRepo): UpdateTvShowsUseCase  {
        return UpdateTvShowsUseCase(tvShowRepo);
    }

    @Provides
    fun provideTvSHowsGetTUseCase(tvShowRepo: TvShowRepo): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepo);
    }



}