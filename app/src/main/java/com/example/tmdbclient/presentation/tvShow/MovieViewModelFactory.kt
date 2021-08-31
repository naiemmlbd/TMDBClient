package com.example.tmdbclient.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.example.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.example.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.example.tmdbclient.presentation.movie.MovieViewModel


class TvShowViewModelFactory(private val getTvShowsUseCase: GetTvShowsUseCase,
                             private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom((TvShowViewModel::class.java))){
            return TvShowViewModel(getTvShowsUseCase,updateTvShowsUseCase) as T
        }
        throw IllegalArgumentException("Unknown viewModel Class")
    }
}