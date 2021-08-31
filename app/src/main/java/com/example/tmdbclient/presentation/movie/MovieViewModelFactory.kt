package com.example.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.UpdateMoviesUseCase


class MovieViewModelFactory(private val getMoviesUseCase: GetMoviesUseCase,
                            private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom((MovieViewModel::class.java))){
            return MovieViewModel(getMoviesUseCase,updateMoviesUseCase) as T
        }
        throw IllegalArgumentException("Unknown viewModel Class")
    }
}