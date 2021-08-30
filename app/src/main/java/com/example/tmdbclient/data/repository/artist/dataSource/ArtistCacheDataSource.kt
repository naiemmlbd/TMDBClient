package com.example.tmdbclient.data.repository.artist.dataSource

import com.example.tmdbclient.data.model.artist.Artist


interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)
}