package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.model.artist.Artist


interface ArtistRepo {

    suspend fun getArtist():List<Artist>?
    suspend fun updateArtist():List<Artist>?
}