package com.example.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.domain.usecase.UpdateArtistsUseCase


class ArtistViewModelFactory(private val getArtistsUseCase: GetArtistsUseCase,
                             private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom((ArtistViewModel::class.java))){
            return ArtistViewModel(getArtistsUseCase,updateArtistsUseCase) as T
        }
        throw IllegalArgumentException("Unknown viewModel Class")
    }
}