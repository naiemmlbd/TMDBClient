package com.example.tmdbclient.data.repository

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.domain.repository.ArtistRepo


class TvShowRepoImpl:ArtistRepo {
    override suspend fun getArtist(): List<Artist>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateArtist(): List<Artist>? {
        TODO("Not yet implemented")
    }
}